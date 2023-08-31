
import { createBrowserRouter } from "react-router-dom"
import Home from "../pages/Home";
import Login from "../component/Login";
import App from "../../App"
import Admin from "../pages/admin/Admin";
import NewUser from "../pages/admin/NewUser";
import NewTicket from "../pages/admin/NewTicket";
export default createBrowserRouter([
    {
        path: "/app",
        element: <App/>

    },
    {
        path: "/login",
        element: <Login />

    },
    {
        path: "/",
        element:  <Login />
    },
    {
        path:"/admin",
        element:<Admin/>,
        children:[
            {
                path: "home",
                element: <Home/>,
            },
            {
                path: "newuser",
                element: <NewUser/>,
            },
            {
                path: "newticket",
                element: <NewTicket/>,
            },
        ]
    }
]);