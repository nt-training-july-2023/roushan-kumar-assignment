
import { createBrowserRouter } from "react-router-dom"
import Home from "../pages/Home";
import Login from "../component/Login";
import App from "../../App"
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
        element: <Home />
    },
]);