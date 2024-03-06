import { useParams } from "react-router-dom";
import Navbar from "../components/Navbar";
import HistoryContainer from "../components/StockPage/History";
import { Box} from "@mui/material";
import LiveBroadBastBox from "../components/StockPage/LiveBroadCastBox.tsx";
import ControlPanel from "../components/StockPage/ControlPanel.tsx";
import Graph from "../components/StockPage/Graph.tsx";
import { useDispatch, useSelector } from "react-redux";
import { AppDispatch, RootState } from "../redux/store.ts";
import { useEffect, useState } from "react";
import { Stocks } from "../types/Stocks.ts";
import { setStockPrice } from "../redux/slice/PriceSlice.ts";

function StockPage() {
  const reduxDispatch: AppDispatch = useDispatch();
  const { id } = useParams();
  const stocks = useSelector((state: RootState) => state.stocks.stocks);
  const price = useSelector((state: RootState) => state.price.price);
  const [stock, setStock] = useState<Stocks>();
  const [graphBarValues, setGraphBarValues] = useState<number[]>([]);
  useEffect(() => {
    const intervalId = setInterval(() => {
      const newData = Math.floor(Math.random() * 500);
      if (graphBarValues.length > 37) {
        setGraphBarValues([]);
      }
      setGraphBarValues((prevPrices) => [...prevPrices, newData]);
reduxDispatch(setStockPrice(newData))
    }, 2000);

    return () => clearInterval(intervalId);
  }, [graphBarValues, reduxDispatch]);


  useEffect(
    () => setStock(stocks.find((stock) => stock.stock_name === id)),
    [stock, id, stocks]
  );
  return (
    <>
      <Navbar />
      <Box sx={{display:"flex" , marginTop:"10px"}}>
        <Box sx={{ width: "75%" }}>
          {stock && <>
            <ControlPanel stocks={stocks} id={id} price={price} />
            <Box sx={{ position: "relative",height:"500px",marginTop:"20px",marginRight:"30px",marginLeft:"29px"}}>
              <Graph base={stock?.base_price} barGaphValues={graphBarValues} />
            </Box>
          </>
          }
      </Box>
      <Box sx={{width:"25%"}}>
        <HistoryContainer id={id} />
        <LiveBroadBastBox id={id}/>
      </Box>
      </Box>
      
   
    </>
  );
}

export default StockPage;
