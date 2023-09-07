import { ADD_TO_CART, REMOVE_TO_CART ,GET_PRICE} from "../constants"
export const addToCart=(data)=>{
   // console.warn("Action addToCart",data);
    return {
        type:ADD_TO_CART,
        data:data
    }
}

export const removeToCart=(data)=>{
    //console.log('Action removeToCart',data);
    return {
        type:REMOVE_TO_CART,
        data:data
    }
}

export const getPrice=(data)=>{
    //console.log('Action getPrice',data)
    return {
        type:GET_PRICE,
        data:data
    }
}