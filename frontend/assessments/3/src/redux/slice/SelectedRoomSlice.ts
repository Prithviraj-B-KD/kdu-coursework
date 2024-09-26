import { AddOn } from "../../types/RoomTypes";
import { PayloadAction } from "./../../../node_modules/@reduxjs/toolkit/dist/createAction.d";

import { createSlice } from "@reduxjs/toolkit";

interface SelectedRoomState {
  name: string;
  costPerNight: string;
  currency: string;
  addOnprice: number;
  numberOfDays: number;
  total: number;
  addOns: AddOn[];
}
const initialState: SelectedRoomState = {
  name: "",
  costPerNight: "",
  currency: "",
  numberOfDays: 0,
  total: 0,
  addOns: [],
  addOnprice: 0,
};

const SelectedRoomSlice = createSlice({
  name: "selectedRoom",
  initialState: initialState,
  reducers: {
    setRoomName: (state, action: PayloadAction<string>) => {
      state.name = action.payload;
      state.addOnprice = 0;
      state.addOns;
    },
    setCostPerNight: (state, action: PayloadAction<string>) => {
      state.costPerNight = action.payload;
    },
    setCurrency: (state, action: PayloadAction<string>) => {
      state.currency = action.payload;
    },
    pushAddOns: (state, action: PayloadAction<number>) => {
      state.addOnprice += action.payload;
    },
    removeAddOns: (state, action: PayloadAction<number>) => {
      state.addOnprice -= action.payload;
    },
    setTotal: (state, action: PayloadAction<number>) => {
      state.total = action.payload;
    },
    setNumberOfDays: (state, action: PayloadAction<number>) => {
      state.numberOfDays = action.payload;
    },
  },
});

export default SelectedRoomSlice.reducer;
export const {
  setRoomName,
  setCostPerNight,
  setCurrency,
  pushAddOns,
  removeAddOns,
  setTotal,
} = SelectedRoomSlice.actions;
