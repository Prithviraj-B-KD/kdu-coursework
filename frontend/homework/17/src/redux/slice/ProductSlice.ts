import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { ProductProps } from "../../types/ProductProps";
import { getProducts } from "../thunks/getProducts";

interface ProductState {
  products: ProductProps[];
  state: "fulfilled" | "pending" | "error";
  error?: string;
}

const initialState: ProductState = {
  products: [],
  state: "pending",
};

const productSlice = createSlice({
  name: "products",
  initialState: initialState,
  reducers: {
    setData: (state, action: PayloadAction<ProductProps[]>) => {
      state.products = action.payload;
    },
    setError: (state, action: PayloadAction<string>) => {
      state.state = "error";
    },
  },
  extraReducers(builder) {
    builder
      .addCase(getProducts.pending, (state) => {
        state.state = "pending";
      })
      .addCase(
        getProducts.fulfilled,
        (state, action: PayloadAction<ProductProps[]>) => {
          state.state = "fulfilled";
          state.products = action.payload;
        }
      )
      .addCase(getProducts.rejected, (state, action) => {
        state.error = action.payload as string;
        state.state = "error";
      });
  },
});

export const { setData, setError } = productSlice.actions;
export default productSlice.reducer;
