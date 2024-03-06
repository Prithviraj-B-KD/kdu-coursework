import { PayloadAction, createSlice } from "@reduxjs/toolkit";

interface PriceState {
  price: number;
}

const initialState: PriceState = {
  price: 0,
};

const PriceSlice = createSlice({
  name: "filter",
  initialState: initialState,
  reducers: {
    setStockPrice: (state, action: PayloadAction<number>) => {
      state.price = action.payload;
    },
  },
});
export const { setStockPrice } = PriceSlice.actions;
export default PriceSlice.reducer;
