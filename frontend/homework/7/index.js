const express = require("express");
const http = require("http");
const cors = require("cors");
const socketIo = require("socket.io");

const app = express();
const server = http.createServer(app);

const io = new socketIo.Server(server, {
  cors: {
    origin: "http://127.0.0.1:5500",
  },
});
app.use(cors());

app.use(express.json());

app.get("/", (req, res) => {
  res.json({
    msg: "Hello World",
  });
});

io.on("connection", (socket) => {
  socket.emit("message", "Welcome to ChatCord");
  socket.broadcast.emit("message", "A user has joined the chat");
  socket.on("new-message", (payload) => {
    io.except(socket.id).emit("new-message", payload);
  });
  socket.on("disconnect", () => {
    io.emit("message", "user has left the chatchat");
  });
});
server.listen(3000, () => {
  console.log(`Server is running on  http://localhost:3000`);
});
