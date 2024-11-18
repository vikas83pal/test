import './App.css';
import NavBar from './components/navBar';
import Register from './components/register';
// import Footer from './components/footer';
import Login from './components/login';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      {/* Navigation bar */}
      <NavBar />

      {/* Define Routes */}
      <Routes>
        <Route path="/" element={<h1 className='text-center m-12'>Welcome to Shopping Mall</h1>} />
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />
      </Routes>

      {/* Footer */}
      {/* <Footer /> */}
    </BrowserRouter>
  );
}

export default App;
