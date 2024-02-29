import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { getProducts } from "../thunks/getProducts";

interface SnackBarState {
  show: boolean;
  message: string;
}

const initialState: SnackBarState = {
  show: false,
  message: "",
};

const SnackbarSlice = createSlice({
  name: "snackBar",
  initialState: initialState,
  reducers: {
    setShow(state, action: PayloadAction<boolean>) {
      state.show = action.payload;
    },
    setMessage(state, action: PayloadAction<string>) {
      state.message = action.payload;
    },
  },
  extraReducers(builder) {
    builder
      .addCase(getProducts.fulfilled, (state) => {
        state.message = "Products loaded successfully";
        state.show = true;
      })
      .addCase(getProducts.rejected, (state, action) => {
        state.message = action.payload as string;
        state.show = true;
      });
  },
});

export const { setMessage, setShow } = SnackbarSlice.actions;
export default SnackbarSlice.reducer;
