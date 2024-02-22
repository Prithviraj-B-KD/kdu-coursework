const express = require("express");
const router = express.Router();
const registeredUsers = require("../data/registeredUsers");
let isLoggedIn = require("../data/isLoggedIn");

router.post("/login", (req, res) => {
  const { username, password } = req.body;

  const user = registeredUsers[username];

  if (user && user.password === password) {
    isLoggedIn.push(username);
    res.status(200).json({
      username: registeredUsers[username].name,
      firstname: registeredUsers[username].user_name,
    });
  } else {
    res.status(401).json({ error: "Invalid username or password" });
  }
});

module.exports = router;
