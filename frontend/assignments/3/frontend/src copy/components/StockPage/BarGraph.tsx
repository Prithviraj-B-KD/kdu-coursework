import { Box } from "@mui/material";
export interface BarGraphProps{
    currentPrice: number,
    base:number,
}

function BarGraph({ currentPrice, base }: BarGraphProps) {
    console.log(base);
    console.log(currentPrice)
    return (
        <div>
        {currentPrice < base && (
          <Box
            sx={{
              minWidth: "20px",
              maxWidth: "20px",
              height: `${currentPrice}px`,
              backgroundColor:  "#ffc9c9",
              border: "2px solid red",
            }}
          />
        )}
        {currentPrice >= base && (
          <Box
            sx={{
              minWidth: "20px",
              maxWidth: "20px",
              height: `${currentPrice}px`,
              backgroundColor:  "#b2f2bb",
              border: "2px solid green",
            }}
          />
        )}
      </div>);
}

export default BarGraph;