const inputString =
  '{"firstName":"Alex","lastName":"Hunter","email":"alex@yahoo.com","age":24, "city":"london", "country":"england"}';

const jsonObject = JSON.parse(inputString);
console.log(jsonObject);

function convertValues(obj) {
  for (const [key, value] of Object.entries(obj)) {
    if (key === "email" || key == "age") {
      continue;
    }
    obj[key] = value.toUpperCase();
  }
  return obj;
}

function removeEmail(obj) {
  delete obj.email;
  return JSON.stringify(obj);
}

console.log("a output \n");
console.log(convertValues(jsonObject));

console.log("\nb output: \n");
console.log(removeEmail(jsonObject));
