/* eslint-disable no-unused-vars */
import React from 'react'
import { Route, Routes, BrowserRouter } from 'react-router-dom'
import Home from './Components/Home/home'
import Register from './Components/Registration/Register'
import Payment from './Components/Payments/Payment'
import Dashboard from './Components/Dashboard/Dashboard'
import Product from './Components/Products/Products'
import Contact from './Components/Contact/Contact'
import About from './Components/About/About'


function App() {

  return (

    <Routes>
     <Route path='/product' element={<Product/>}></Route>
     <Route path='/register' element={<Register/>}></Route>
     <Route path='/payment' element={<Payment/>}></Route>
     <Route path='/dashboard'element={<Dashboard/>}></Route>
     <Route path='/contact' element={ <Contact/>}></Route>
     <Route path='/about' element = {<About/>}></Route>
     <Route path='/' element={<Home/>}></Route>


    </Routes>
  
  )
}

export default App
