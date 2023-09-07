import Header from '../Components/Header'
import {connect} from 'react-redux'

const mapStateToProps=state=>({
     data:state.cartItem

})
const mapDispatchToProps=(dispatch)=>({

})
export default connect(mapStateToProps,mapDispatchToProps)(Header)