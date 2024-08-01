/* eslint-disable no-unused-vars */

import React from 'react';

function Dashboard(props) {

    return(
        <>
        <h1>{props.fname}</h1>
        <h2>{props.price}</h2>
        <h3>{props.quantity}</h3>
        <h3>{props.availability}</h3>
        
        </>
    )


}

export default Dashboard;