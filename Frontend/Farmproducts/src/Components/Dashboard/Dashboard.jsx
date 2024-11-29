/* eslint-disable no-unused-vars */

import React from 'react';
import { Link } from 'react-router-dom';

function Dashboard(props) {

    return(
        <>
        <Link to="/login">Login</Link><br/>
        <Link to="/register">Signup</Link><br/>
        <Link to="/payment">Payment</Link><br/>
        <Link to="/product">Products</Link>
        
        </>
    )


}

export default Dashboard;