import { useState } from 'react'
import './App.css'
import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import ProductDetailPage from './pages/ProductDetailPage'
import ProductListPage from './pages/ProductList'

function App() {
  const [count, setCount] = useState(0)

  return (
    <BrowserRouter>
      <Routes>
      <Route path='/' element={<ProductListPage />}/>
      <Route path='/product/:id' element={<ProductDetailPage />} />
      </Routes>
      </BrowserRouter>
  
  )
}

export default App
