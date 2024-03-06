import { createContext } from "react";
import { ItemProps } from "../types/ItemProps";

export const DeleteContext = createContext<{
  deleteItem: (itemId: number) => void | Promise<void>; // Handles async errors
  items: ItemProps[];
} | null>(null);
