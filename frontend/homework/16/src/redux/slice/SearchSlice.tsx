import {  PayloadAction,createSlice } from "@reduxjs/toolkit";

interface SearchState{
    searchQuery:string
}

const initialState: SearchState= {
    searchQuery: ""
}

const SearchSlice = createSlice({
    name: "searchQuery",
    initialState: initialState,
    reducers: {
        updateSearch: (state, action: PayloadAction<string>) => {
            state.searchQuery = action.payload;
        }
    }
})
export const { updateSearch } = SearchSlice.actions;
export default SearchSlice.reducer;