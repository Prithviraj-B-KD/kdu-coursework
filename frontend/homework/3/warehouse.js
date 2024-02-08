const shoe1 = { type: "shoe", color: "white", size: "10", price: 5000 };
const shoe2 = { type: "shoe", color: "black", size: "10", price: 3000 };
const shirt1 = { type: "shirt", color: "white", size: "M", price: 2000 };
const shirt2 = { type: "shirt", color: "blue", size: "M", price: 1000 };

const shoes = [shoe1, shoe2];
const shirts = [shirt1, shirt2];
const warehouse = [...shoes, ...shirts];

console.log("Warehouse:");
const total = warehouse.reduce((sum, Product) => sum + Product.price, 0);
console.log("Total price of Products: " + total);

warehouse.sort((a, b) => b.price - a.price);
console.log("\nProducts in descending order: \n");

warehouse.forEach((product) => {
  console.log(
    `${product.type} - ${product.color} - ${
      product.size
    } - $${product.price.toFixed(2)}`
  );
});

const blueProduct = warehouse.filter((a) => a.color == "blue");
console.log("\nBlue Product:");
blueProduct.forEach((product) => {
  console.log(
    `${product.type} - ${product.color} - ${
      product.size
    } - $${product.price.toFixed(2)}`
  );
});
