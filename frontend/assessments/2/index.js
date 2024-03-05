const express = require("express");
const http = require("http");
const cors = require("cors");
const socketIo = require("socket.io");
const { getEventListeners } = require("events");
var stocksOwned = 0;

const app = express();
const server = http.createServer(app);

const io = new socketIo.Server(server, {
  cors: {
    origin: "http://127.0.0.1:5500",
  },
});
app.use(cors());

app.use(express.json());

io.on("connection", (socket) => {
  socket.on("buy", (payload) => {
    let quantity = parseInt(payload);
    stocksOwned += quantity;
    console.log(stocksOwned);
  });
  socket.on("update-request", (payload) => {
    value = getRandomValue();
    socket.emit("updated-price", value);
  });
  socket.on("sell", (payload) => {
    let quantity = parseInt(payload);
    console.log(quantity);
    console.log(stocksOwned);
    if (stocksOwned < quantity) {
      socket.emit("output", -1);
    } else {
      stocksOwned -= quantity;
      console.log(stocksOwned);
      socket.emit("output", 1);
    }
  });
});

function getRandomValue() {
  const range = 145 - 135;
  const increaseAmount = range * 0.1;
  const randomValue = Math.floor(Math.random() * range) + 135;

  return randomValue + increaseAmount;
}

server.listen(3000, () => {
  console.log(`Server is running on  http://localhost:3000`);
});
