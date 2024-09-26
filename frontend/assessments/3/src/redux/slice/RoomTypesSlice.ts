import { getRoomTypes } from "../thunks/GetRoomTypes";
import { RoomTypes } from "./../../types/RoomTypes";
import { PayloadAction, createSlice } from "@reduxjs/toolkit";

interface RoomTypesState {
  roomTypes: RoomTypes[];
  state: "fulfilled" | "pending" | "error";
  error?: string;
}

const initialState: RoomTypesState = {
  roomTypes: [],
  state: "pending",
};

const RoomTypeSlice = createSlice({
  name: "RoomType",
  initialState: initialState,
  reducers: {
    setData: (state, action: PayloadAction<RoomTypes[]>) => {
      state.roomTypes = action.payload;
    },
    setError: (state, action: PayloadAction<string>) => {
      state.state = "error";
      state.error = action.payload as string;
    },
  },
  extraReducers(builder) {
    builder
      .addCase(getRoomTypes.pending, (state) => {
        state.state = "pending";
      })
      .addCase(
        getRoomTypes.fulfilled,
        (state, action: PayloadAction<RoomTypes[]>) => {
          state.state = "fulfilled";
          state.roomTypes = action.payload;
        }
      )
      .addCase(getRoomTypes.rejected, (state, action) => {
        state.error = action.payload as string;
        state.state = "error";
      });
  },
});

export default RoomTypeSlice.reducer;
export const { setData, setError } = RoomTypeSlice.actions;
