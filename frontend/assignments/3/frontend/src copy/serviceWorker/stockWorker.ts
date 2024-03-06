import { Summary } from "../pages/SummarizerPage";
import { Datum } from "../types/AllStocksTransaction";

interface StockWorkerProps {
  stock_name: string;
  symbol: string;
  data: Datum[];
}

function calculateBestBuySell({
  stock_name,
  symbol,
  data,
}: StockWorkerProps): Summary {
  console.log("cal");
  let maxProfit = 0;
  let buyDate = "";
  let sellDate = "";
  let minPrice = Infinity;
  let buyPrice = 0;
  let sellPrice = 0;

  for (let { date, prices: currentPrices } of data) {
    for (const currentPrice of currentPrices) {
      if (currentPrice < minPrice) {
        minPrice = currentPrice;
        date = new Date(date);
        buyDate = date.toISOString();
        buyPrice = currentPrice;
        console.log(buyPrice);
      } else {
        const profit = currentPrice - minPrice;
        if (profit > maxProfit) {
          maxProfit = profit;
          date = new Date(date);
          sellDate = date.toISOString();
          sellPrice = currentPrice;
        }
      }
    }
  }
  return {
    stock_name,
    symbol,
    buyDate,
    sellDate,
    maxProfit,
    buyPrice,
    sellPrice,
  };
}

onmessage = function (e: MessageEvent<StockWorkerProps[]>) {
  const stocks: StockWorkerProps[] = e.data;
  const results: Summary[] = [];

  stocks.forEach((stock) => {
    const { stock_name, symbol, data } = stock;
    const result = calculateBestBuySell({ stock_name, symbol, data });

    results.push(result);
  });

  postMessage(results);
};
