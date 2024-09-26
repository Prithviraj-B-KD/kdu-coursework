import { useEffect } from "react";
import "./App.css";
import RoomSelectionPage from "./pages/RoomSelectionPage";
import { getRoomTypes } from "./redux/thunks/GetRoomTypes";
import { useDispatch } from "react-redux";
import { AppDispatch } from "./redux/store";

function App() {
  const reduxDispatch: AppDispatch = useDispatch();
  useEffect(() => {
    reduxDispatch(getRoomTypes());
  }, []);

  return <RoomSelectionPage />;
}

export default App;
