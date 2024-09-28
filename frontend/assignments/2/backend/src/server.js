const express = require("express");
const http = require("http");
const socketIO = require("socket.io");
const cors = require("cors");
const postRouter = require("./routes/posts");
const loginRouter = require("./routes/login");
const messagesRouter = require("./routes/messages");
const activeUsers = require("./data/socketConnection");
const registeredUsers = require("./data/registeredUsers");
const chatToUserMap = require("./data/chatToUserMap");
const app = express();
app.use(express.json());
app.use(cors());

app.use("/api/v1", postRouter);
app.use("/api/v1", loginRouter);
app.use("/api/v1", messagesRouter);

const server = http.createServer(app);
const io = new socketIO.Server(server, {
  cors: {
    origin: "http://127.0.0.1:5500",
  },
});

io.on("connection", (socket) => {
  console.log("New client connected : " + socket.id);
  socket.on("join", (username, firstname) => {
    console.log("name recieved : ", firstname);
    const activeUser = {
      socketId: socket.id,
      name: username,
      username: firstname,
      profile_img: registeredUsers[firstname].profile_url,
    };
    io.except(socket.id).emit("new-user", activeUser);
    const activeU = {
      socketId: socket.id,
      name: firstname,
    };
    activeUsers.push(activeU);
    socket.emit("activeUsers", activeUsers);
  });
  socket.on("sendMessage", (message) => {
    console.log(message);
    const senderSocketId = message.sender;
    const receiverSocketId = message.receiver;

    const newMessage = {
      senderId: senderSocketId,
      receiverId: receiverSocketId,
      content: message.content,
      time: message.time,
    };

    chatToUserMap.push(newMessage);

    io.to(receiverSocketId).emit("addMsg", {
      content: message.content,
      time: message.time,
      action: "receive",
      from: senderSocketId,
    });
  });
});

server.listen(3000, () => {
  console.log("Listening on port 3000");
});
