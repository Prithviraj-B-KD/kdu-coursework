import React from "react";
import "../../styles/ListItem.css";
import { ListItemProps } from "../../types/ListItemProps";

export function ListItem({text}:ListItemProps) {
    return (
        <li className="list-Item">{text}</li>
    );
}