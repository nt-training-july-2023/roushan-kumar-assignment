
import { createBrowserRouter } from "react-router-dom"
import Home from "../pages/Home";
import Login from "../pages/Login";
import App from "../App.js"
import Admin from "../pages/admin/Admin";
import NewUser from "../pages/admin/NewUser";
import NewTicket from "../pages/admin/NewTicket";
import ErrorPage from "../pages/ErrorPage";
import Department from "../pages/admin/Department";
import Member from "../pages/member/Member";
import SessionExpire from "../pages/SessionExpire";
import Ticket from "../pages/admin/Ticket";
import TicketUpdateView from "../pages/TicketUpdateView";
import ChangePassword from "../component/ChangePassword";
import Users from "../pages/admin/Users";
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
        path: "/*",
        element:  <ErrorPage />
    },
    {
        path: "/session-expired",
        element:  <SessionExpire />
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
                path: "/admin/users",
                element: <Users/>,
            },
            {
                path: "newticket",
                element: <NewTicket/>,
            },
            {
                path: "ticket",
                element: <Ticket/>,
            },
            {
                path: "Department",
                element: <Department/>,
            },
            {
                path: "ticket-update-view",
                element:  <TicketUpdateView />
            },
        ]
    },

    {
        path:"/member",
        element:<Member/>,
        children:[
            {
                path: "home",
                element: <Home/>,
            },
            {
                path: "/member/riseticket",
                element: <NewTicket/>,
            },
            {
                path: "ticket",
                element: <Ticket/>,
            },
        ]
    },
    {
        path:"/user/changepassword",
        element:<ChangePassword/>,
    }
]);