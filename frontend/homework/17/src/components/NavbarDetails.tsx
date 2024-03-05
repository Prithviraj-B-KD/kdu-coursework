import { useContext, useState } from "react";

import "../styles/Navbar.css";
import { FaSearch } from "react-icons/fa";
import React from "react";
function NavbarDetails() {
  const [ searchQuery, setSearchQuery ]= useState("");
  const handleSearchChange = (event: React.ChangeEvent<HTMLInputElement>) => {
   
  };
  return (
    <div className="navbar">
      <div className="search-bar-container">
        <input
          className="search-input"
          name="search-input"
          placeholder="Search.."
          value={searchQuery}
          onChange={handleSearchChange}
        />
        <button className="search-button">
          <FaSearch className="search-icon"/>
        </button>
      </div>
    </div>
  );
}

export default NavbarDetails;
