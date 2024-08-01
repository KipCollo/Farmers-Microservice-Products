/* eslint-disable no-unused-vars */
import React from 'react'
import { Route, Routes, BrowserRouter } from 'react-router-dom'
import Home from './Components/Home/home'
import Signup from './Components/Registration/Signup'
import Login from './Components/Registration/Login'
import Payment from './Components/Payments/Payment'
import Dashboard from './Components/Dashboard/Dashboard'
import Product from './Components/Products/Products'


function App() {

  return (
  
    <BrowserRouter>
    <Routes>
    <Route path='/product' Component={Product}></Route>
     <Route path='/register' Component={Signup}></Route>
     <Route path='/login' Component={Login}></Route>
     <Route path='/payment' Component={Payment}></Route>
     <Route path='/dashboard' Component={Dashboard}></Route>
     <Route path='/' Component={Home}></Route>
     
    </Routes>
     
  
    </BrowserRouter>
  
  )
}

export default App
