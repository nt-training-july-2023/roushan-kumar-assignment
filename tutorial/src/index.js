import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import Home from './page/Home';
import Registration from './Component/Registration';
import Employee from './Component/Employee';


const router  = createBrowserRouter([
  {
    path:"/",
    element:<App/>,
    children: [
      {
        path: "/home",
        element: <Home/>,
      },
      {
        path:"/registration",
        element:<Registration/>
      },
      {
        path:"/employee",
        element:<Employee/>
      },
    ]
  },
  
]);


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    
    <RouterProvider router={router} />
  
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
