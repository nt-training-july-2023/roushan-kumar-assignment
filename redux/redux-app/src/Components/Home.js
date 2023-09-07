import React, { useEffect, useState } from 'react'

export default function Home(props) {
    //console.warn("Home props",props.data);

    const [price,setPrice]=useState(0);
    
    const getPrice=()=>{
        let sum=0;
        props.data.forEach(element => {
            // console.log("element",element.cardData);
            sum+=element.cardData.price;
        });
        setPrice(sum);
    }

    useEffect(()=>{
        getPrice();
    },[price,props.data])

    

  return (
    <div>
        
        <h1>Home Component</h1>

            <div className="cart-wrapper">
                <div className="img-wrapper item">
                    <img src="https://images.macrumors.com/t/9r84bU_ZTOTrUixxwhjHUFsAvD4=/800x0/smart/article-new/2017/09/iphonexdesign.jpg?lossy" />
                </div>
                <div className="text-wrapper item">
                    <span>
                        I-Phone
                    </span>
                    <span>
                        Price: $1000.00
                    </span>
                </div>
                <div className="btn-wrapper item">
                    <button 
                    onClick={
                        ()=>{props.addToCartHandler({price:1000,name:'i phone 11'})}
                        }>
                        Add To Cart</button>
                    <button
                        onClick={()=>{props.removeToCartHandler('i phone 11')}}
                    >Remove </button>
                </div>
                
                
            </div>

            <div className="cart-wrapper">
                <div className="img-wrapper item">
                    <img src="https://images.macrumors.com/t/9r84bU_ZTOTrUixxwhjHUFsAvD4=/800x0/smart/article-new/2017/09/iphonexdesign.jpg?lossy" />
                </div>
                <div className="text-wrapper item">
                    <span>
                        Moto
                    </span>
                    <span>
                        Price: $2000.00
                    </span>
                </div>
                <div className="btn-wrapper item">
                    <button 
                    onClick={
                        ()=>{props.addToCartHandler({price:2000,name:'Moto'})}
                        }>
                        Add To Cart</button>
                    <button
                        onClick={()=>{props.removeToCartHandler('Moto')}}
                    >Remove </button>
                </div>
                
                
            </div>

            <div className="btn-wrapper item">
                            Price : 
                            {price}
            </div>
    </div>
  )
}
