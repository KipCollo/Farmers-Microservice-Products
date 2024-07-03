import React from 'react'
import { Route, Routes, BrowserRouter } from 'react-router-dom'
import Home from './Components/home'
import Signup from './Components/Signup'
import Login from './Components/Login'
import Payment from './Components/Payment'
import Dashboard from './Components/Dashboard'


function App() {

  return (
  
    <BrowserRouter>
    <Routes>
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
