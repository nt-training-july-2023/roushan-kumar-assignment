import Home from '../Components/Home'
import {connect} from 'react-redux'
import {addToCart,removeToCart,getPrice} from '../service/actions/actions'


const mapStateToProps=state=>({
     data:state.cartItem

})
const mapDispatchToProps=(dispatch)=>({
    addToCartHandler:data=>dispatch(addToCart(data)),
    removeToCartHandler:data=>dispatch(removeToCart(data)),
    getPriceHandler:data=>dispatch(getPrice(data))

})
export default connect(mapStateToProps,mapDispatchToProps)(Home)
// export default Home;