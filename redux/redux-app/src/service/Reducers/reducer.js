import { ADD_TO_CART, REMOVE_TO_CART,GET_PRICE } from "../constants";

const intialState={
    cardData:[]
}

export default function cartItem (state=[],action)
{
    
    switch (action.type) {
        case ADD_TO_CART:
               // console.warn("reducer ADD_TO_CART",action)
                return [
                    ...state,
                    {cardData:action.data}
                ]
        case REMOVE_TO_CART:
                //console.log("reducer REMOVE_TO_CART",action.data)
                //state.pop();
                let index=-1;
                let a=-1;
                state.forEach(element => {
                    a++;
                    
                    if(action.data===element.cardData.name)
                    {
                        console.log(" cardData name :",element.cardData.name);
                        index=a;
                        
                    }
                });
                if(index>-1)
                state.splice(index, 1);

                return [
                    ...state
                ]
        case GET_PRICE:
                
               // console.log("reducer GET_PRICE",action)
                return 1000;

        default:
            return state
    }

} 