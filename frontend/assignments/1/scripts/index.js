function createPost() {
  const userInput = document.getElementById("post-input").value.trim(); // Trim whitespace

  if (!userInput) {
    console.error("Please enter a post.");
    return;
  }

  // Create the post element structure
  const postDiv = document.createElement("div");
  postDiv.classList.add("post");

  const profileImg = document.createElement("img");
  profileImg.src = "images/profile pic.png";
  profileImg.alt = "profile";
  profileImg.classList.add("profile-image");

  const nameParagraph = document.createElement("p");
  nameParagraph.classList.add("post-profile-name");
  nameParagraph.textContent = "Nitesh Gupta";

  const usernameParagraph = document.createElement("p");
  usernameParagraph.classList.add("post-profile-username");
  usernameParagraph.textContent = "@nit_hck • 0s";

  const postContent = document.createElement("p");
  postContent.classList.add("post-content");
  postContent.textContent = userInput;

  const postIconsDiv = document.createElement("div");
  postIconsDiv.classList.add("post-icons");

  const commentIcon = document.createElement("div");
  commentIcon.classList.add("post-icon");
  commentIcon.innerHTML =
    '<img src="icons/comment.svg" alt="comment-icon" class="comment-icon"/>';

  const retweetIcon = document.createElement("div");
  retweetIcon.classList.add("post-icon");
  retweetIcon.innerHTML =
    '<img src="icons/retweet.svg" alt="retweet" class="retweet"/>';

  const likeIcon = document.createElement("div");
  likeIcon.classList.add("post-icon");
  likeIcon.innerHTML =
    '<img src="icons/like.svg" alt="like" class="like-post"/>';

  const statsIcon = document.createElement("div");
  statsIcon.classList.add("post-icon");
  statsIcon.innerHTML =
    '<img src="icons/stats.svg" alt="stats" class="stats-icon"/>';

  const postProfileTitle = document.createElement("div");
  postProfileTitle.classList.add("post-Profile-title");

  const postDisplayContent = document.createElement("div");
  postDisplayContent.classList.add("post-display");

  const postActions = document.createElement("div");
  postActions.classList.add("post-actions");

  const postHeader = document.createElement("div");
  postHeader.classList.add("post-header");

  const bookmarkShareIcon = document.createElement("div");
  bookmarkShareIcon.classList.add("post-icon");
  bookmarkShareIcon.innerHTML =
    '<img src="icons/bookmark-post.svg" alt="bookmark-icon" class="bookmark-icon"/>';
  postProfileTitle.appendChild(nameParagraph);
  postProfileTitle.appendChild(usernameParagraph);
  postDisplayContent.appendChild(postProfileTitle);
  postDisplayContent.appendChild(postContent);
  postHeader.appendChild(profileImg);
  postHeader.appendChild(postDisplayContent);
  postDiv.appendChild(postHeader);
  postIconsDiv.appendChild(commentIcon);
  postIconsDiv.appendChild(retweetIcon);
  postIconsDiv.appendChild(likeIcon);
  postIconsDiv.appendChild(statsIcon);
  postIconsDiv.appendChild(bookmarkShareIcon);
  postActions.appendChild(postIconsDiv);
  postDiv.appendChild(postActions);
  // Append the post to the container
  const postContainer = document.querySelector(".post-container");
  postContainer.insertBefore(postDiv, postContainer.children[0]);

  // Clear the input field
  document.getElementById("post-input").value = "";
}

const tweetInput = document.querySelector("#post-input");
const addPostButtons = document.querySelector(".tweet-btns");
addPostButtons.addEventListener("onClick");

function toggleButtonState() {
  if (tweetInput.value.trim() !== "") {
    addPostButtons.forEach(function (button) {
      button.removeAttribute("disabled");
      button.classList.add("active-button");
      button.classList.remove("inactive-button");
    });
  } else {
    addPostButtons.forEach(function (button) {
      button.setAttribute("disabled", "disabled");
      button.classList.remove("active-button");
      button.classList.add("inactive-button");
    });
  }
}
tweetInput.addEventListener("input", toggleButtonState);
