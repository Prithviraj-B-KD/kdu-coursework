import { useDispatch, useSelector } from "react-redux";
import OptionButton from "../components/OptionButton";
import SectionHeading from "../components/SectionHeading";
import dayjs, { Dayjs } from "dayjs";
import { useEffect, useState } from "react";
import { AppDispatch, RootState } from "../redux/store";
import { AddOn } from "../types/RoomTypes";
import { DemoContainer } from "@mui/x-date-pickers/internals/demo";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import { pushAddOns, setNumberOfDays, setRoomName, setTotal } from "../redux/slice/SelectedRoomSlice";
import { DatePicker } from "@mui/x-date-pickers/DatePicker";
import { LocalizationProvider } from "@mui/x-date-pickers";
import { differenceInDays } from 'date-fns';
const styles: { [key: string]: React.CSSProperties } = {
  heading: {
    display: "flex",
    width: "100%",
    justifyContent: "center",
    fontSize: "1rem",
    marginBottom: "1rem",
  },
  optionContainer: {
    width: "100%",
    marginBottom: "1rem",
  },
  ulStyle: {
    display: "flex",
    flexWrap: "wrap",
    gap: "10px",
    width: "100%",
  },
  submitButton: {
    cursor: "pointer",
    padding: "15px 30px",
    fontSize: "0.5rem",
    border: "none",
    backgroundColor: "#f08a5d",
    color: "#fff",
    },
    optionButton: {
        cursor:"pointer",
        color: "#333",
        padding: "15px 30px",
        fontSize: "0.5rem",
        border: "1px solid black",
        backgroundColor:"white"
    }
};

function RoomSelectionPage() {
  const [beginDate, setBeginDate] = useState<Dayjs|null>(dayjs("2024-03-1"));
    const [endDate, setEndDate] = useState<Dayjs| null>(dayjs("2024-03-1"));
    const [cost, setCost] = useState<number>(0);
  const reduxDispatch: AppDispatch = useDispatch();

  const roomTypes = useSelector(
    (state: RootState) => state.roomTypes.roomTypes
  );
    const selectedRoom = useSelector((state: RootState) => state.selectedRoom);
    useEffect(() => {
        if (beginDate && endDate) {
          const numberOfDays = differenceInDays(endDate, beginDate);
          reduxDispatch(setNumberOfDays(numberOfDays)); 
        }
      }, [beginDate, endDate, selectedRoom]);
    
    const calulateTotal = () => {
        setCost((parseInt(selectedRoom.costPerNight)+ selectedRoom.addOnprice) * selectedRoom.numberOfDays);
        reduxDispatch(setTotal(cost + cost * 0.18));
    }
    
    useEffect((
    ) => (
        calulateTotal()
    ), [selectedRoom.name, selectedRoom.addOns, selectedRoom.numberOfDays]);

  const handleSelectRoomType = (name: string) => {
    reduxDispatch(setRoomName(name));
    console.log(selectedRoom.name);
  };
    const handleSelectAddOnType = (addOn: number) => {
        reduxDispatch(pushAddOns(addOn));
    }
    const handleSubmit = () => {
        console.log(selectedRoom.name);
        console.log(selectedRoom.numberOfDays);
        console.log(selectedRoom.addOns);
        console.log(selectedRoom.total);
    }

  return (
    <div className="room-selection">
      <div className="heading" style={styles.heading}>
        Hotel Booking
      </div>
      <SectionHeading name={"Select Room Type"} />
      <div className="option-container" style={styles.optionContainer}>
        <ul style={styles.ulStyle}>
          {
            roomTypes.map((roomType) => (
              <li key={roomType.id}>
                <button style={styles.optionButton} onClick={()=>handleSelectRoomType(roomType.name)}>{roomType.name}</button>
              </li>
            ))}
        </ul>
      </div>
      <SectionHeading name={"Select Date"} />
      <div className="option-container" style={styles.optionContainer}>
        <LocalizationProvider dateAdapter={AdapterDayjs}>
          <DemoContainer components={["DatePicker", "DatePicker"]}>
            <DatePicker
              label="Begin Date"
              value={beginDate}
              onChange={(newValue) => setBeginDate(newValue)}
            />
            <DatePicker
              label="End Date"
              value={endDate}
              onChange={(newValue) => setEndDate(newValue)}
            />
          </DemoContainer>
        </LocalizationProvider>
      </div>
      <SectionHeading name={"Select additional adds ons/preferences"} />
      <div className="option-container" style={styles.optionContainer}>
        {selectedRoom.addOns.length === 0 && (
          <div>Select a Room Type first</div>
        )}
        {selectedRoom.addOns.length !== 0 &&
          selectedRoom.addOns.map((addOn: AddOn) => (
           <li >
                <button style={styles.optionButton} onClick={()=>handleSelectAddOnType(parseInt(addOn.cost))}>{addOn.name}</button>
              </li>
          ))}
      </div>
          <div className="total-container">
              <div style={styles.optionContainer}>{cost} + 18% = <span>{selectedRoom.total}</span></div>
        <button style={styles.submitButton} onClick={handleSubmit}>Submit</button>
      </div>
    </div>
  );
}

export default RoomSelectionPage;
