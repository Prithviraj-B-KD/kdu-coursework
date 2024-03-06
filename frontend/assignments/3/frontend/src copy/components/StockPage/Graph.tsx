import { Box } from "@mui/material";
import BarGraph from "./BarGraph";
interface GraphProps{
  base: number;
  barGaphValues: number[];
}
const styles: { [key: string]: React.CSSProperties } = {
  graphGrid: {
    zIndex: "0",
    display: "flex",
    height: "100%",
    width: "100%",
    border: "1px solid #000"
  },
  row: {
    height: "25%",
  borderBottom: "1px dotted #000",
  opacity: "0.5",
  },
  lastRow: {
    height: "25%",
  borderBottom: "1px dotted #000",
  opacity: "0.5",
  },
  col: {
    height: "100%",
    width: "16.667%",
    flex: "1",
    borderRight: "1px dotted #000",
    opacity: "0.5",
    display: "flex",
    flexDirection: "column",
  },
  lastCol: {
    height: "100%",
    width: "16.667%",
    flex: "1",
    borderRight: "none",
    opacity: "0.5",
    display: "flex",
    flexDirection: "column",
  },
  graphBars: {
    display: "flex",
 alignItems:"flex-end",
  zIndex: "10",
  position: "absolute",
  bottom: "0",
  width: "100%",
  }

}

function Graph({base,barGaphValues}:GraphProps) {
    return ( 
      <Box style={styles.graphGrid}>
              <Box style={styles.col}>
                <Box style={styles.row}></Box>
                <Box style={styles.row}></Box>
                <Box style={styles.row}></Box>
                <Box style={styles.lastRow}></Box>
              </Box>
              <Box style={styles.col}>
                <Box style={styles.row}></Box>
                <Box style={styles.row}></Box>
                <Box style={styles.row}></Box>
                <Box style={styles.lastRow}></Box>
              </Box>
              <Box style={styles.col}>
                <Box style={styles.row}></Box>
                <Box style={styles.row}></Box>
                <Box style={styles.row}></Box>
                <Box style={styles.lastRow}></Box>
              </Box>
              <Box style={styles.col}>
                <Box style={styles.row}></Box>
                <Box style={styles.row}></Box>
                <Box style={styles.row}></Box>
                <Box style={styles.lastRow}></Box>
              </Box>
              <Box style={styles.col}>
                <Box style={styles.row}></Box>
                <Box style={styles.row}></Box>
                <Box style={styles.row}></Box>
                <Box style={styles.row}></Box>
              </Box>
              <Box style={styles.lastCol}>
                <Box style={styles.row}></Box>
                <Box style={styles.row}></Box>
                <Box style={styles.row}></Box>
                <Box style={styles.lastRow}></Box>
        </Box>
        <Box style={styles.graphBars}>
        {
          barGaphValues.map((value) => (
            <BarGraph currentPrice={value} base={base} />
          ))
        }
        </Box>
       
     
            </Box>
            
     
     );
}

export default Graph;