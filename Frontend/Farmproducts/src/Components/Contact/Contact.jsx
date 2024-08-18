import React from 'react';
import { Link } from 'react-router-dom';

function Contact() {
    return ( <>
        <Link to="/login">Login</Link><br/>
        <Link to="/register">Signup</Link><br/>
        <Link to="/payment">Payment</Link><br/>
        <Link to="/product">Products</Link><br />
        <Link to='/about'>About Us</Link>

        <h2>This is our contacts: <contacts> 0721454207</contacts></h2>
    </> );
}

export default Contact;