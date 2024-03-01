import { configureStore } from "@reduxjs/toolkit";
import RoomTypesReducer from "./slice/RoomTypesSlice";
import SelectedRoomReducer from "./slice/SelectedRoomSlice";

export const store = configureStore({
  reducer: {
    roomTypes: RoomTypesReducer,
    selectedRoom: SelectedRoomReducer,
  },
});
export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
