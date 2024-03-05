const transactions = document.querySelector(".transactions-container");
const barcontainer = document.querySelector(".graph-bars");
const socket = io("http://localhost:3000");
const stockPricePreviousDay = 137;
const tradingInput = document.getElementById("stock-trader-input-box");
buyButton = document.getElementById("buy-button");
sellButton = document.getElementById("sell-button");

buyButton.addEventListener("click", (event) => {
  socket.emit("buy", tradingInput.value);
  const transaction = document.createElement("div");
  transaction.classList.add("transaction");
  const transactioncontent = `
  <div class="transaction-info">
    <div class="quantity">
      <div class="stock-number">${tradingInput.value} Stocks ${
    tradingInput.value * 142
  }</div>
      <div class="stock-date">${new Date()}</div>
    </div>
  </div>
  <div class="transaction-type market-up">BUY</div>
`;
  transaction.innerHTML = transactioncontent;
  transactions.appendChild(transaction);
});
sellButton.addEventListener("click", (event) => {
  socket.emit("sell", tradingInput.value);
  socket.on("output", (message) => {
    if (message == -1) {
      console.log("You own less stocks");
    } else {
      const transaction = document.createElement("div");
      transaction.classList.add("transaction");
      const transactioncontent = `
    <div class="transaction-info">
      <div class="quantity">
        <div class="stock-number">${tradingInput.value} Stocks ${
        tradingInput.value * 142
      }</div>
        <div class="stock-date">${new Date()}</div>
      </div>
    </div>
    <div class="transaction-type market-down">SELL</div>
  `;
      transaction.innerHTML = transactioncontent;
      transactions.appendChild(transaction);
    }
  });
});

const stockPrice = document.getElementById("stock-price");
const stockPriceArrow = document.getElementById("stock-price-arrow");
const stockPricePercentage = document.getElementById("stock-price-percentage");

function updatePrice() {
  socket.emit("update-request", "price");
  socket.on("updated-price", (data) => {
    stockPrice.innerHTML = data;
    if (parseFloat(data) < stockPricePreviousDay) {
      const bar = document.createElement("div");
      bar.classList.add("bar");
      bar.classList.add("market-down-bar");
      barcontainer.appendChild(bar);
      stockPrice.classList.add("market-down");
      stockPrice.classList.remove("market-up");
      stockPriceArrow.innerHTML = "&#8595;";
      stockPriceArrow.classList.add("market-d own");
      stockPriceArrow.classList.remove("market-up");
    } else {
      const bar = document.createElement("div");
      bar.classList.add("bar");
      bar.classList.add("market-down-up");
      barcontainer.appendChild(bar);
      stockPrice.classList.add("market-up");
      stockPrice.classList.remove("market-down");
      stockPriceArrow.innerHTML = "&#8593;";
      stockPriceArrow.classList.add("market-up");
      stockPriceArrow.classList.remove("market-down");
    }
  });
}
setInterval(updatePrice, 5000);
clearInterval(intervalId);
