const socket = io("http://localhost:3000");

let user = JSON.parse(localStorage.getItem("user"));
socket.emit("storeSocketId", user);

socket.on("connect", () => {
  console.log("Connected with socket ID:", socket.id);
});

socket.emit("join", user.username, user.firstname);

function switchUser(socketSelf, socketOther) {
  fetch(`http://localhost:3000/api/v1/messages/${socketSelf}/${socketOther}`)
    .then((response) => response.json())
    .then((data) => {
      createChatWindow(data, socketOther);
    })
    .catch((error) => console.error("Error fetching chat messages:", error));
}

function formatRelativeTime(messageTime) {
  const currentTime = new Date();
  const [time, period] = messageTime.split(" ");
  const [hour, minutes] = time.split(":");
  let messageHour = parseInt(hour);
  const messageMinutes = parseInt(minutes);
  if (period === "PM") {
    messageHour = (messageHour % 12) + 12;
  }
  const currentHour = currentTime.getHours();
  const currentMinutes = currentTime.getMinutes();
  const minutesDifference =
    (currentHour - messageHour) * 60 + (currentMinutes - messageMinutes);

  if (minutesDifference < 1) {
    return "Just now";
  } else if (minutesDifference < 10) {
    return (
      minutesDifference +
      " minute" +
      (minutesDifference === 1 ? "" : "s") +
      " ago"
    );
  } else {
    return messageTime;
  }
}

function addMsgToChats(messageContainer, message) {
  const msgDiv = document.createElement("div");
  msgDiv.classList.add("each-msg");
  msgDiv.classList.add(message.action);

  const msgContent = document.createElement("div");
  msgContent.classList.add("msg-content");
  msgContent.textContent = message.content;

  const msgTime = document.createElement("div");
  msgTime.classList.add("msg-time");

  msgTime.textContent = formatRelativeTime(message.time);
  setInterval(() => {
    msgTime.textContent = formatRelativeTime(message.time);
  }, 60000);

  msgDiv.appendChild(msgContent);
  msgDiv.appendChild(msgTime);

  messageContainer.appendChild(msgDiv);
}

socket.on("addMsg", (message) => {
  if (message.from !== selectedChat) return;
  const messageContainer = document.querySelector(".messages-container");
  addMsgToChats(messageContainer, message);
});

function createChatWindow(data, receiver) {
  const messageContainer = document.querySelector(".messages-container");
  messageContainer.innerHTML = "";

  const userChatsTopBar = document.querySelector(".username-div");
  userChatsTopBar.innerHTML = "";

  const newMessage = document.querySelector(".message-input-box");

  const backArrow = document.createElement("img");
  backArrow.src = "../icons/back-button.svg";

  backArrow.addEventListener("click", () => {
    const bottomNav = document.querySelector(".bottom-navigation-bar");
    const activeUsersMobile = document.querySelector(".center-container");
    activeUsersMobile.style.display = "block";
    const userChats = document.querySelector(".right-container");
    userChats.style.display = "none";
    bottomNav.style.display = "flex";
  });

  const nameDiv = document.createElement("div");
  nameDiv.textContent = data.name;

  userChatsTopBar.appendChild(backArrow);
  userChatsTopBar.appendChild(nameDiv);

  const chats = data.chats;
  chats.forEach((message) => {
    const msgDiv = document.createElement("div");
    msgDiv.classList.add("msg");
    msgDiv.classList.add(message.action);

    const msgContent = document.createElement("div");
    msgContent.classList.add("msg-content");
    msgContent.textContent = message.content;

    const msgTime = document.createElement("div");
    msgTime.classList.add("msg-time");
    msgTime.textContent = formatRelativeTime(message.time);
    setInterval(() => {
      msgTime.textContent = formatRelativeTime(message.time);
    }, 60000);

    msgDiv.appendChild(msgContent);
    msgDiv.appendChild(msgTime);

    messageContainer.appendChild(msgDiv);
  });

  const newMessageInput = document.getElementById("message-input-box");

  const sendMessageButton = document.querySelector(".message-button");

  sendMessageButton.addEventListener("click", () => {
    const msg = newMessageInput.value;
    socket.emit("sendMessage", {
      content: msg,
      sender: socket.id,
      receiver: receiver,
      time: getCurrentTime(),
    });
    addMsgToChats(messageContainer, {
      content: msg,
      time: getCurrentTime(),
      action: "sent",
    });
  });
}

function getCurrentTime() {
  const now = new Date();
  let hours = now.getHours();
  let minutes = now.getMinutes();
  const ampm = hours >= 12 ? "PM" : "AM";
  hours = hours % 12;
  hours = hours ? hours : 12;
  minutes = minutes < 10 ? "0" + minutes : minutes;
  const formattedTime = hours + ":" + minutes + " " + ampm;
  return formattedTime;
}

function createActiveUsersDiv(user) {
  const userDiv = document.createElement("div");
  userDiv.classList.add("user");

  const span = document.createElement("span");
  span.textContent = user.socketId;
  span.style.display = "none";
  userDiv.appendChild(span);

  const image = document.createElement("img");
  image.src = user.profile_img;
  image.alt = "profile-image";
  image.classList.add("profile-img");
  const nameParagraph = document.createElement("div");
  nameParagraph.textContent = user.name;

  const handleSpan = document.createElement("span");
  handleSpan.textContent = user.username;

  userDiv.appendChild(image);
  userDiv.appendChild(nameParagraph);
  userDiv.appendChild(handleSpan);

  userDiv.addEventListener("click", () => {
    console.log(window.innerWidth);
    if (window.innerWidth <= 430) {
      const floatingMessageBoxIcon = document.querySelector(
        ".floating-message-box-icon"
      );
      const messageInputBox = document.querySelector(".messages-input-div ");
      const bottomNav = document.querySelector(".bottom-navigation-bar");
      const activeUsersMobile = document.querySelector(".center-container");
      activeUsersMobile.style.display = "none";
      const messageChats = document.querySelector(".right-container");
      messageChats.style.display = "block";
      floatingMessageBoxIcon.style.display = "none";
      bottomNav.style.display = "none";
      messageInputBox.style.display = "block";
    }
    selectedChat = user.socketId;
    switchUser(socket.id, user.socketId);
  });
  const activeUserContainer = document.querySelector(".active-users-container");
  activeUserContainer.appendChild(userDiv);
  return userDiv;
}

socket.on("new-user", (activeUser) => {
  createActiveUsersDiv(activeUser);
});

socket.on("activeUsers", (activeUsers) => {
  const activeUserContainer = document.querySelector(".active-users-container");
  let cnt = 0;
  activeUsers.forEach((activeUser) => {
    if (cnt == 0) {
      selectedChat = activeUser.socketId;
      switchUser(socket.id, activeUser.socketId);
    }
    activeUserContainer.appendChild(createActiveUsersDiv(activeUser));
    cnt++;
  });
});
