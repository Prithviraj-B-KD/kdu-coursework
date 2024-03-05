import { configureStore } from "@reduxjs/toolkit";
import productReducer from "./slice/ProductSlice";
import snackbarReducer from "./slice/SnackbarSlice";

export const store = configureStore({
  reducer: {
    products: productReducer,
    snackbar: snackbarReducer,
  },
});
export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
