player = {
  firstName: "Leo",
  lastName: "Messi",
  address: {
    country: "Spain",
    city: "Barcelona",
  },
  careerInfo: {
    fcBarcelona: {
      appearances: 780,
      goals: {
        premierLeagueGoals: 590,
        championsLeagueGoals: 50,
      },
    },
  },
};

function printKeys(obj) {
  if (typeof obj !== "object" || obj === null) {
    console.error("Input must be a valid object!");
    return;
  }
  const keys = Object.keys(obj);

  for (const key of keys) {
    if (typeof key == "object") {
      printKeys(key);
    } else {
      console.log(key);
    }
  }
}

function printValues(obj) {
  if (typeof obj !== "object" || obj === null) {
    console.error("Input must be a valid object!");
    return;
  }
  const values = Object.values(obj);

  for (const value of values) {
    if (typeof value == "object") {
      printValues(value);
    } else {
      console.log(value);
    }
  }
}
console.log("Keys:");
printKeys(player);
console.log("\nValues:");
printValues(player);
