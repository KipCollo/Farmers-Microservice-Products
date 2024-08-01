/* eslint-disable no-unused-vars */
import React from 'react';
import { Link } from 'react-router-dom';
import Dashboard from '../Dashboard/Dashboard';

function Home() {
    return (
        <div>
        <h1>Home</h1>
        <h3>Do you have an Account ?</h3>
        <Link to="/login">Login</Link><br/>
        <Link to="/register">Signup</Link><br/>
        <Link to="/payment">Payment</Link><br/>
        <Link to="/product">Products</Link>

{/* 
        <Dashboard fname='maize' price='300' quantity='3'/>
        <Dashboard fname='Beans' price='350' quantity='5'/> */}
        </div>
    )
    
}

export default Home;