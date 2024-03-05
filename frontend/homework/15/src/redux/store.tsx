import { configureStore } from "@reduxjs/toolkit";
import ItemReducer from "./slice/ItemSlice";
import SearchReducer from "./slice/SearchSlice";




export const store = configureStore({
    reducer: {
        items: ItemReducer,
        searchQuery : SearchReducer
    }
})

export type RootState = ReturnType<typeof store.getState>