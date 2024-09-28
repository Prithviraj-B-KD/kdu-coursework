const express = require("express");
const router = express.Router();
const posts = require("../data/posts");
const registeredUsers = require("../data/registeredUsers");

router.get("/posts", (req, res) => {
  const page = parseInt(req.query.page);
  const pageSize = parseInt(req.query.pageSize);
  const startIndex = (page - 1) * pageSize;
  const endIndex = page * pageSize;

  let paginatedPosts = posts.slice(startIndex, endIndex);
  paginatedPosts.reverse();
  setTimeout(() => {
    res.json({
      posts: paginatedPosts,
    });
  }, 2200);
});
router.post("/posts", (req, res) => {
  const content = req.body.content;
  const imgContent = req.body.imgContent;
  const username = req.body.username;
  const firstname = req.body.firstname;

  const newPost = {
    id: posts.length + 1,
    username: username,
    firstname: firstname,
    timestamp: new Date(),
    content: content,
    profileImg: registeredUsers[firstname].profile_url,
  };
  posts.push(newPost);
  res.json({ message: "Post created successfully", post: newPost });
});
router.get("/:id", (req, res) => {
  const postId = req.params.id;
  const post = posts.find((post) => post.id === postId);

  if (!post) {
    return res.status(404).json({ message: "Post not found" });
  }

  res.json(post);
});
module.exports = router;
