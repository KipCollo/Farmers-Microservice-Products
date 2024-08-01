import React from 'react';

function Signup() {
    return(
        <>
        <h1>Signup</h1>
        <form  action='/login'>
            <label htmlFor="username">Username</label>
            <input type="text" id='username'/><br/><br/>

            <label htmlFor="email">Email</label>
            <input type="email" name="" id="email"/><br/><br/>

            <label htmlFor="password">Password</label>
            <input type="password" name="" id="password" /><br/><br/>

            <input type="submit" value="Register"/>
        </form>
        </>
    )


}

export default Signup;