import React from 'react';
import { Link } from 'react-router-dom';

function About() {
    return ( <>
        <Link to="/login">Login</Link><br/>
        <Link to="/register">Signup</Link><br/>
        <Link to="/payment">Payment</Link><br/>
        <Link to="/product">Products</Link><br />
        <Link to="/contact">Contact Us</Link>

        <h2>This is about page</h2>
    
    </> );
}

export default About;