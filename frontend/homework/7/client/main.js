const messages = document.querySelector(".messages-container");

function addMessage(message) {
  console.log(message);
  const senderLogo = document.createElement("div");
  senderLogo.classList.add("sender-logo");
  senderLogo.innerHTML = "U";
  const element = document.createElement("div");
  element.classList.add("message-content");
  element.innerHTML = message;
  const messagediv = document.createElement("div");
  messagediv.classList.add("user");
  messagediv.classList.add("message");
  messagediv.appendChild(senderLogo);
  messagediv.appendChild(element);
  messages.appendChild(messagediv);
}
function addMyMessage(message) {
  console.log(message);
  const senderLogo = document.createElement("div");
  senderLogo.classList.add("sender-logo");
  senderLogo.innerHTML = "Y";
  const element = document.createElement("div");
  element.classList.add("message-content");
  element.innerHTML = message;
  const messagediv = document.createElement("div");
  messagediv.classList.add("message");
  messagediv.appendChild(senderLogo);
  messagediv.appendChild(element);
  messages.appendChild(messagediv);
}

const socket = io("http://localhost:3000");
socket.on("new-message", (message) => {
  addMessage(message);
});
socket.emit("message", "user A");

const messageForm = document.getElementById("input-form");
const messageInput = document.getElementById("input-box");

messageForm.addEventListener("submit", (event) => {
  event.preventDefault();
  const message = messageInput.value;
  addMyMessage(message);
  messageInput.value = "";
  socket.emit("new-message", message);
});
