/* eslint-disable no-unused-vars */
import React from 'react';
import { Route } from 'react-router-dom';


<Route path='/login' element={<Login/>}></Route>
function Login() {
    return(
        <>
        <h1>Login Page</h1>
   
        <form action='/Dashboard'> 
        <label htmlFor="username">Username</label>
            <input type="text" id='username'/><br/><br/>

        <label htmlFor="password">Password</label>
            <input type="password" name="" id="password" /><br/><br/>

        <input type="submit" value="Login"/>

        </form>
        </>
    )
}

export default Login;
