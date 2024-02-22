const socket = io("http://localhost:3000");

let user = JSON.parse(localStorage.getItem("user"));
socket.emit("storeSocketId", user);

socket.on("connect", () => {
  console.log("Connected with socket ID:", socket.id);
});

socket.emit("join", user.username, user.firstname);

let page = 1;
let pageSize = 5;

async function fetchPosts() {
  await fetch(
    `http://localhost:3000/api/v1/posts?page=${page}&pageSize=${pageSize}`
  )
    .then((response) => response.json())
    .then((data) => {
      const posts = data.posts;
      console.log(posts);
      let postsContainer = document.querySelector(".posts");
      posts.forEach((post) => {
        const newPost = createPost(post);
        postsContainer.appendChild(newPost);
      });
      page++;
    })
    .catch((error) => {
      console.error("Error while fetching the posts:", error);
    });
}
fetchPosts();

function checkScroll() {
  const scrollTop =
    document.documentElement.scrollTop || document.body.scrollTop;
  const windowInnerHeight = window.innerHeight;
  const scrollHeight = document.documentElement.scrollHeight;

  if (scrollTop + windowInnerHeight >= scrollHeight - 50) {
    fetchPosts();
  }
}

window.addEventListener("scroll", checkScroll);

const tweetInput = document.querySelector(".post-text-input");
const addPostButton = document.querySelector(".tweet-post-button");
function toggleButtonState(input, button) {
  if (input.value.trim() !== "") {
    button.removeAttribute("disabled");
    button.classList.add("active-button");
    button.classList.remove("inactive-button");
  } else {
    button.setAttribute("disabled", "disabled");
    button.classList.remove("active-button");
    button.classList.add("inactive-button");
  }
}

tweetInput.addEventListener("input", () => {
  toggleButtonState(tweetInput, addPostButton);
});

function createPost(post) {
  let tweetText = post.content.replace(
    /#(\w+)/g,
    '<span class="hashtag">#$1</span>'
  );

  const postDiv = document.createElement("div");
  postDiv.classList.add("post");
  const imgProfileDiv = document.createElement("div");
  const imgProfile = document.createElement("img");
  imgProfileDiv.classList.add("profile-img-div");

  imgProfile.src = post.profileImg;
  imgProfile.alt = "";
  imgProfile.classList.add("profile-img");
  imgProfileDiv.appendChild(imgProfile);

  const divPostContentRight = document.createElement("div");
  divPostContentRight.classList.add("post-content-right");

  const divPostUpper = document.createElement("div");
  divPostUpper.classList.add("post-upper");

  const divPostOwnerHandle = document.createElement("div");
  divPostOwnerHandle.classList.add("post-owner-handle");

  const pOwnerHandle = document.createElement("p");
  pOwnerHandle.textContent = post.firstname;
  const spanHandle = document.createElement("span");
  spanHandle.textContent = "@" + post.username;
  pOwnerHandle.appendChild(spanHandle);
  divPostOwnerHandle.appendChild(pOwnerHandle);

  const aThreeDots = document.createElement("a");
  aThreeDots.href = "";
  const imgThreeDots = document.createElement("img");
  imgThreeDots.src = "icons/side-nav-icons/three_dots.svg";
  imgThreeDots.alt = "";
  imgThreeDots.id = "three-dots";
  imgThreeDots.classList.add("post-icon");
  aThreeDots.appendChild(imgThreeDots);

  divPostUpper.appendChild(divPostOwnerHandle);
  divPostUpper.appendChild(aThreeDots);

  const divPostMiddle = document.createElement("div");
  divPostMiddle.classList.add("post-middle");
  const pTweetText = document.createElement("p");
  pTweetText.textContent = tweetText;
  const imgTweet = document.createElement("img");
  imgTweet.classList.add("tweet-image");
  imgTweet.src = post.img;

  divPostMiddle.appendChild(pTweetText);
  if (post.img) divPostMiddle.appendChild(imgTweet);

  const divPostLower = document.createElement("div");
  divPostLower.classList.add("post-lower");

  const divPostActionsLinks = document.createElement("div");
  divPostActionsLinks.classList.add("post-actions-links");

  const aComment = document.createElement("a");
  aComment.href = "";
  const imgComment = document.createElement("img");
  imgComment.src = "icons/side-nav-icons/comment.svg";
  imgComment.alt = "";
  imgComment.classList.add("post-icon");
  aComment.appendChild(imgComment);

  const aRetweet = document.createElement("a");
  aRetweet.href = "";
  const imgRetweet = document.createElement("img");
  imgRetweet.src = "icons/side-nav-icons/retweet.svg";
  imgRetweet.alt = "";
  imgRetweet.classList.add("post-icon");
  aRetweet.appendChild(imgRetweet);

  const buttonLike = document.createElement("button");
  buttonLike.classList.add("like-button");
  const imgHeart = document.createElement("img");
  imgHeart.src = "icons/side-nav-icons/heart.svg";
  imgHeart.alt = "";
  imgHeart.id = "heart";
  imgHeart.classList.add("post-icon");
  const spanLikeCount = document.createElement("span");
  spanLikeCount.classList.add("like-count");
  spanLikeCount.textContent = "0";
  buttonLike.appendChild(imgHeart);
  buttonLike.appendChild(spanLikeCount);

  buttonLike.addEventListener("click", () => {
    const currentLikes = parseInt(spanLikeCount.textContent);
    const isLiked = buttonLike.classList.contains("liked");

    if (isLiked) {
      spanLikeCount.textContent = currentLikes - 1;
      buttonLike.classList.remove("liked");
      imgHeart.src = "icons/side-nav-icons/heart.svg";
    } else {
      spanLikeCount.textContent = currentLikes + 1;
      buttonLike.classList.add("liked");
      imgHeart.src = "icons/side-nav-icons/heart_full.svg";
    }
  });

  const aStats = document.createElement("a");
  aStats.href = "";
  const imgStats = document.createElement("img");
  imgStats.src = "icons/side-nav-icons/stats.svg";
  imgStats.alt = "";
  imgStats.classList.add("post-icon");
  aStats.appendChild(imgStats);

  const aBookmarkPost = document.createElement("a");
  aBookmarkPost.href = "";
  const imgBookmarkPost = document.createElement("img");
  imgBookmarkPost.src = "icons/side-nav-icons/bookmark-post.svg";
  imgBookmarkPost.alt = "";
  imgBookmarkPost.classList.add("post-icon");
  aBookmarkPost.appendChild(imgBookmarkPost);

  divPostActionsLinks.appendChild(aComment);
  divPostActionsLinks.appendChild(aRetweet);
  divPostActionsLinks.appendChild(buttonLike);
  divPostActionsLinks.appendChild(aStats);
  divPostActionsLinks.appendChild(aBookmarkPost);

  const aShare = document.createElement("a");
  aShare.href = "";
  const imgShare = document.createElement("img");
  imgShare.src = "icons/side-nav-icons/share.svg";
  imgShare.alt = "";
  imgShare.classList.add("post-icon");
  aShare.appendChild(imgShare);

  divPostLower.appendChild(divPostActionsLinks);
  divPostLower.appendChild(aShare);

  divPostContentRight.appendChild(divPostUpper);
  divPostContentRight.appendChild(divPostMiddle);
  divPostContentRight.appendChild(divPostLower);

  postDiv.appendChild(imgProfileDiv);
  postDiv.appendChild(divPostContentRight);
  return postDiv;
}

addPostButton.addEventListener("click", function () {
  let postsContainer = document.querySelector(".posts");
  let tweetText = tweetInput.value.trim();
  if (tweetText === "") {
    alert("Post content is empty !!");
    return;
  }

  fetch("http://localhost:3000/api/v1/posts", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      content: tweetText,
      username: user.username,
      firstname: user.firstname,
    }),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log("New post created:", data.post);
      const createdPost = createPost(data.post);
      postsContainer.prepend(createdPost);
    })
    .catch((error) => {
      console.error("Error creating post:", error);
    });

  tweetInput.value = "";

  addPostButton.setAttribute("disabled", "disabled");
  addPostButton.classList.remove("active-button");
  addPostButton.classList.add("inactive-button");

  console.log("filled the posts section");
});
const floatingTweetBoxIcon = document.querySelector(".floating-tweet-icon");
const posts = document.querySelector(".posts");
const tweetBoxProfileMobile = document.querySelector(
  ".tweet-box-profile-mobile-view"
);
const topNavMobilebar = document.querySelector(".top-navigation-bar");
const tweetBox = document.querySelector(".tweet-box");

floatingTweetBoxIcon.addEventListener("click", function () {
  if (tweetBoxProfileMobile.style.display === "none") {
    console.log("here");
    tweetBoxProfileMobile.style.display = "block";
    posts.style.display = "none";
    tweetBox.style.display = "block";
    topNavMobilebar.style.display = "none";
    tweetInput.style.display = "block";
    profileIcon.style.display = "none";
    floatingTweetBoxIcon.style.display = "none";
  } else {
    tweetBoxProfileMobile.style.display = "none";
  }
});

let backArrow = document.querySelector(".back-arrow");
backArrow.addEventListener("click", function () {
  tweetBoxProfileMobile.style.display = "none";
  posts.style.display = "block";
  tweetInput.style.display = "block";
  profileIcon.style.display = "flex";
  floatingTweetBoxIcon.style.display = "flex";
  tweetBox.style.display = "none";
});
