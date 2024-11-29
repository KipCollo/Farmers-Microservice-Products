/* eslint-disable no-unused-vars */
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function Products(){

    return(
        <> 
        <Link to="/login">Login</Link><br/>
        <Link to="/register">Signup</Link><br/>
        <Link to="/payment">Payment</Link><br/>
        <Link to="/product">Products</Link>

         <h3>Products Here</h3>
        </>
    );

}


export default Products;