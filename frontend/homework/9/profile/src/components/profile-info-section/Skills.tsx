import React from "react";
import "../../styles/Skills.css";
import { SkillsProps } from "../../types/SkillProps";
import { ListItem } from "../Lists/ListItem";

export function Skills({skills}:SkillsProps) {
    return (
        <div id="Skills">
             <div className="heading"><h1>Skills</h1></div>
            <ul>
                {skills.map((skill) => (
                        <ListItem key={skill.id} text={skill.skill}/>
                       ))}
            </ul>
        </div>
    );
}