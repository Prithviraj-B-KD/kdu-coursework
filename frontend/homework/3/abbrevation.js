const days = [
  "Sunday ",
  "Monday ",
  " Tuesday",
  "Wednesday ",
  "Thursday ",
  "Friday",
  "Saturday ",
];

function abbrevator(days) {
  let abbrevations = [];
  for (let i = 0; i < days.length; i++) {
    let trimString = days[i].trim().slice(0, 3);
    abbrevations.push(trimString.toUpperCase());
  }
  return abbrevations;
}

console.log(abbrevator(days));
