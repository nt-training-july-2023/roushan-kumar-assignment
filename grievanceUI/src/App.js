import React from 'react'

function App() {

    if (sessionStorage.getItem('userType') === 'Admin' && sessionStorage.getItem("isFisrt") == 0 ) {

        // navigate("/admin/ticket");
        window.location.href = "http://localhost:3000/admin/ticket";


    } else if (sessionStorage.getItem('userType') === 'Member' && sessionStorage.getItem("isFisrt") == 0 ) {

        // navigate("/member/ticket");
        window.location.href = "http://localhost:3000/member/ticket";

    } else {
        window.location.href = "http://localhost:3000/login";
    }

    return (
        <></>
    )
}

export default App