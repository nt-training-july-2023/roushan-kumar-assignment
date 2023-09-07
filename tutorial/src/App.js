import './App.css';
import { Outlet } from 'react-router-dom';
import Sidebar from './Component/Sidebar';
function App() {
  return (
    <div className="App">
       <Sidebar >
          <Outlet />
       </Sidebar>
       
    </div>
  );
}

export default App;
