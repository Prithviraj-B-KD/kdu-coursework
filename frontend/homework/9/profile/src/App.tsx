import React from "react";

import "./App.css";
import { Header } from "./components/Header";

import { ProfileInfo } from "./components/profile-info-section/ProfileInfo";

function App() {
  const ApiResponse = {
    name: "Prithvi",
    fullName: "Prithviraj B",
    qualification: "SDE",
    skills: [
      {
        id: 1,
        skill: "Python",
      },
      {
        id: 2,
        skill: "React",
      },
    ],
    hobbies: [
      {
        id: 1,
        hobby: "Cricket",
      },
    ],
  };
  return (
    <div className="App">
      <Header name={ApiResponse.name} fullName={ApiResponse.fullName} qualification={ApiResponse.qualification}/>
      <ProfileInfo skills={ApiResponse.skills} hobbies={ApiResponse.hobbies}/>
    </div>
  );
}

export default App;
