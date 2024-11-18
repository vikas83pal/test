import '../App.css'
import React from 'react';
import { useState } from 'react'
import { useNavigate } from 'react-router-dom';

const login = () => {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [role, setRole] = useState('USER');
    const [message, setMessage] = useState('');
    const [isSucess, setIsSucess] = useState(false);
    // eslint-disable-next-line react-hooks/rules-of-hooks
    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault();
        const payload = { username, password, role };

        try {
            // Send the request to the backend
            const res = await fetch("http://localhost:8080/register", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(payload),
            });

            if (res.ok) {
                const data = await res.text(); // Or `await res.json()` if the backend sends JSON
                console.log(data);
                
                setUsername('');
                setPassword('');
                setRole('USER');

             
                    navigate("/");
                

               
            } else {
                const errorMessage = await res.text();
                setMessage(`Failed: ${errorMessage}`);
                setUsername('');
                setPassword('');
                setRole('USER');
                setIsSucess(false);
            }
        } catch (err) {
            setMessage("An error occurred: " + err.message);
        }
    };


    return (
        <>
            <form action="" onSubmit={handleLogin}>

                <div className="bg-violet-950 text-white h-[50vh] w-[20vw] m-auto mt-10 rounded-xl flex flex-col justify-center items-center space-y-2">
                    <input
                        type="text"
                        className="text-white bg-transparent border-b-2 border-white px-2 py-1 w-[10vw]"
                        name="username"
                        id="username"
                        placeholder="Username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                    />
                    <input
                        type="text"
                        className="text-white bg-transparent border-b-2 border-white px-2 py-1 w-[10vw]"
                        name="username"
                        id="username"
                        placeholder="Password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                    
                    <button
                        type="submit"
                        className="bg-green-500 rounded-lg p-2 cursor-pointer"
                    >
                        Login
                    </button>
                    {message &&
                        <p className={isSucess ? 'text-green-500' : 'text-red-500'}>{message}</p>}


                </div>

            </form>

        </>
    )
}

export default login