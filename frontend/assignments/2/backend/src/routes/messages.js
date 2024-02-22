const express = require("express");
const router = express.Router();
const registeredUsers = require("../data/registeredUsers");
const activeUsers = require("../data/socketConnection");
const chatToUserMap = require("../data/chatToUserMap");

router.get("/messages/:socketSelf/:socketOther", (req, res) => {
  const socketSelf = req.params.socketSelf;
  const socketOther = req.params.socketOther;
  let chats = [];

  chatToUserMap.forEach((msg) => {
    if (msg.senderId === socketSelf && msg.receiverId === socketOther) {
      const obj1 = {
        content: msg.content,
        time: msg.time,
        action: "sent",
      };
      chats.push(obj1);
    } else if (msg.senderId === socketOther && msg.receiverId === socketSelf) {
      const obj1 = {
        content: msg.content,
        time: msg.time,
        action: "receive",
      };
      chats.push(obj1);
    }
  });
  const obj = {
    name: findName(socketOther),
    chats: chats,
  };
  res.json(obj);
});

function findName(socketId) {
  let name = "Sarah Brown";
  activeUsers.forEach((obj) => {
    if (obj.socketId === socketId) {
      name = obj.name;
    }
  });
  return name;
}

module.exports = router;
