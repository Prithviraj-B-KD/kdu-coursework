import React from "react";
import "../styles/Header.css"
import { HeadProps } from "../types/HeaderProps";



export function Header({name,fullName,qualification}:HeadProps){
    return (
        <div id="Header">
            <h1>{name}</h1>
            <h2>{fullName}</h2>
            <h3>{qualification}</h3>
        </div>
    );
}