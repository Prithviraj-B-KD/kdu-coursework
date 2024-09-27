import { combineReducers, configureStore } from "@reduxjs/toolkit";
import ItemReducer from "./slice/ItemSlice";
import SearchReducer from "./slice/SearchSlice";
import { persistReducer,persistStore } from 'redux-persist';
import storage from "redux-persist/lib/storage";

const rootReducer = combineReducers({
    items:ItemReducer
})

const persistConfig = {
    key: 'items',
    storage,
    version:1,
}

const persistedReducer = persistReducer(persistConfig, rootReducer);


export const store = configureStore({
    reducer: {
      persistedReducer,
        searchQuery : SearchReducer
    },
    middleware: (getDefaultMiddleware) => getDefaultMiddleware({
        serializableCheck: false,
    })
})

export type RootState = ReturnType<typeof store.getState>
export const persistor = persistStore(store);