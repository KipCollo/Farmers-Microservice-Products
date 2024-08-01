/* eslint-disable no-unused-vars */
import React, { useState, useEffect } from 'react';
import axios from 'axios';

function Products(){

    const [post, setPost] = useState();
    const [price, setPrice] = useState()
    const [description, setDescription]=useState()
    const [availability, setAvailability]=useState()

    useEffect(() => {
        // axios.get("http://localhost:8083/api/products").then((response) => {

        // console.log(response)
        // setPost(response.data[3].name);
        // setPrice(response.data[4].price)
        // setDescription(response.data[4].description)
        // setAvailability(response.data[3].availability)
        axios.post("http://localhost:8083/api/products", {
            name: "milk",
            description: "This is milk.",
            availability: false,
            price:60
            })
            .then((response) => {
            setPost(response.data);
            console.log(response)
            
        
        });
        }, []);

        // function createPost() {
        

    return(
        <>
        <h1>created</h1>
{/*         
        <h1>{post}</h1>
        <h2>{description}</h2>
        <h3>{price}</h3>
        <h3>{availability}</h3> */}

        </>
    )


}


export default Products;