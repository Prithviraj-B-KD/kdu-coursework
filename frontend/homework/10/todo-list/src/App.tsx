import React, {useState } from 'react';
import './App.css';
import Navbar from './components/Navbar';

import ItemContainer from './components/ItemManger/ItemContainer';



function App() {
  const [searchQuery, setSearchQuery] = useState('');
  return (
    <div className="App">
        <Navbar searchQuery={searchQuery} setSearchQuery={setSearchQuery} />
        <ItemContainer searchQuery={searchQuery} />
    </div>
  );
}

export default App;
