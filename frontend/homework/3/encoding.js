function enCoder(inputString) {
  encodedString = inputString.trim();
  encodedString = encodedString.replaceAll("a", "4");
  encodedString = encodedString.replaceAll("e", "3");
  encodedString = encodedString.replaceAll("o", "0");
  encodedString = encodedString.replaceAll("s", "5");
  return encodedString;
}

console.log(enCoder("javascript is cool "));
console.log(enCoder("programming is fun"));
console.log(enCoder(" become a coder"));
