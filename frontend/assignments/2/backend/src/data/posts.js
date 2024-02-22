const registeredUsers = require("./registeredUsers.js");

let posts = [
  {
    id: 1,
    username: "jane_smith",
    firstname: registeredUsers["jane_smith"].name,
    timestamp: getRandomTimestamp(),
    content: "Hello from Jane Smith!",
    profileImg: registeredUsers["jane_smith"].profile_url,
  },

  {
    id: 3,
    username: "sarah_brown",
    firstname: registeredUsers["sarah_brown"].name,
    timestamp: getRandomTimestamp(),
    content: "Sarah Brown says hi to everyone!",
    img: "https://pbs.twimg.com/media/GGyk2cYaAAAxTfv?format=jpg&name=medium",
    profileImg: registeredUsers["sarah_brown"].profile_url,
  },
  {
    id: 4,
    username: "jane_smith",
    firstname: registeredUsers["jane_smith"].name,
    timestamp: getRandomTimestamp(),
    content: "Jane Smith checking in again!",
    profileImg: registeredUsers["jane_smith"].profile_url,
  },
  {
    id: 5,
    username: "jane_smith",
    firstname: registeredUsers["jane_smith"].name,
    timestamp: getRandomTimestamp(),
    content: "Hello from Jane Smith!",
    profileImg: registeredUsers["jane_smith"].profile_url,
  },
  {
    id: 2,
    username: "michael_john",
    firstname: registeredUsers["michael_johnson"].name,
    timestamp: getRandomTimestamp(),
    content: "Michael John here, checking in!",
    profileImg: registeredUsers["michael_johnson"].profile_url,
  },
  {
    id: 6,
    username: "michael_john",
    firstname: registeredUsers["michael_johnson"].name,
    timestamp: getRandomTimestamp(),
    content: "Michael John here, checking in!",
    profileImg: registeredUsers["michael_johnson"].profile_url,
  },
  {
    id: 7,
    username: "sarah_brown",
    firstname: registeredUsers["sarah_brown"].name,
    timestamp: getRandomTimestamp(),
    content: "Sarah Brown says hi to everyone!",
    img: "https://pbs.twimg.com/media/GG6coEubEAAHk2w?format=jpg&name=small",
    profileImg: registeredUsers["sarah_brown"].profile_url,
  },
  {
    id: 8,
    username: "jane_smith",
    firstname: registeredUsers["jane_smith"].name,
    timestamp: getRandomTimestamp(),
    content: "Jane Smith checking in again!",
    profileImg: registeredUsers["jane_smith"].profile_url,
  },
  {
    id: 9,
    username: "jane_smith",
    firstname: registeredUsers["jane_smith"].name,
    timestamp: getRandomTimestamp(),
    content: "Hello from Jane Smith!",
    profileImg: registeredUsers["jane_smith"].profile_url,
  },
  {
    id: 10,
    username: "michael_john",
    firstname: registeredUsers["michael_johnson"].name,
    timestamp: getRandomTimestamp(),
    content: "Michael John here, checking in!",
    profileImg: registeredUsers["michael_johnson"].profile_url,
  },
  {
    id: 11,
    username: "sarah_brown",
    firstname: registeredUsers["sarah_brown"].name,
    timestamp: getRandomTimestamp(),
    content: "Sarah Brown says hi to everyone!",
    img: "https://images.pexels.com/photos/906150/pexels-photo-906150.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
    profileImg: registeredUsers["sarah_brown"].profile_url,
  },
  {
    id: 12,
    username: "jane_smith",
    firstname: registeredUsers["jane_smith"].name,
    timestamp: getRandomTimestamp(),
    content: "Jane Smith checking in again!",
    profileImg: registeredUsers["jane_smith"].profile_url,
  },
];

function getRandomTimestamp() {
  const currentTime = new Date().getTime();
  const randomTimeDifference = Math.floor(
    Math.random() * 30 * 24 * 60 * 60 * 1000
  );
  const randomTimestamp = new Date(
    currentTime - randomTimeDifference
  ).toISOString();
  return randomTimestamp;
}

module.exports = posts;
