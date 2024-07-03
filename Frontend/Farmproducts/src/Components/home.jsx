import React from 'react';
import { Link } from 'react-router-dom';

function Home() {
    return (
        <div>
        <h1>Home</h1>
        <h3>Do you have an Account ?</h3>
        <Link to="/login">Login</Link><br/>
        <Link to="/register">Signup</Link><br/>
        <Link to="/payment">Payment</Link>
        </div>
    )
    
}

export default Home;