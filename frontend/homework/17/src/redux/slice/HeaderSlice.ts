import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { Search } from "react-router-dom";

interface HeaderState {
  searchQuery: string;
}

const initialState: HeaderState = {
  searchQuery: "",
};

const HeaderSlice = createSlice({
  name: "searchQuery",
  initialState: initialState,
  reducers: {
    updateSearch: (state, action: PayloadAction<string>) => {
      state.searchQuery = action.payload;
    },
  },
});
