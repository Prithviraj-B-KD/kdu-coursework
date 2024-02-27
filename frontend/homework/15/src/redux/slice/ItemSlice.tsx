import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { ItemProps } from "../../types/ItemProps";

interface ItemState{
    items : ItemProps[]
}

const initialState: ItemState= {
    items: []
}

const ItemSlice = createSlice({
    name: "items",
    initialState: initialState,
    reducers: {
        addTODO: ((state, action: PayloadAction<ItemProps>) => {
            state.items.push(action.payload)
        }),
        deleteTODO: ((state, action: PayloadAction<number>) => {
           state.items= state.items.filter((item: ItemProps) => item.id !== action.payload);
          
        }),
        clearTODO: ((state) => {
            state.items = []
        }),
        toggleTODO: ((state, action: PayloadAction<number>) => {
            const todo = state.items.find((item: ItemProps) => item.id === action.payload);
            if (todo) {
                todo.completed = !todo.completed;
            }
        })   
    
    
    }
});
export const { addTODO,deleteTODO,clearTODO,toggleTODO} = ItemSlice.actions;
export default ItemSlice.reducer;