import React from "react";
import "../../styles/Hobbies.css";
import { HobbiesProps } from "../../types/HobbiesProps";
import { ListItem } from "../Lists/ListItem";
import { text } from "stream/consumers";


export function Hobbies({hobbies}:HobbiesProps) {
    return (
        <div id="Hobbies">
            <div className="heading"><h1>Hobbies</h1></div>
            
            <ul>
            {hobbies.map((hobby) => (
          <ListItem key={hobby.id} text={hobby.hobby} /> // Assuming ListItem takes text prop
        ))}
            </ul>
   
        </div>
    );
}