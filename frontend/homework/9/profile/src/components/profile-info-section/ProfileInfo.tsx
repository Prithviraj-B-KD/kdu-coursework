import React from "react";
import "../../styles/Profile-info.css"
import { Skills } from "./Skills";
import { Hobbies } from "./Hobbies";
import { ProfileInfoProps } from "../../types/ProfileInfoProps";

export function ProfileInfo({skills,hobbies}:ProfileInfoProps){
    return (
        <div id="ProfileInfo">
               <Skills skills={skills}/>
               <Hobbies hobbies={hobbies}/>
        </div>
     
    );
}
