import React from 'react'
import ReactDOM from 'react-dom/client'
import { App } from './App'
import './index.css'
import { MovieContextProvider } from './context/MovieContext'
import { UserContextProvider } from './context/UserContext'

ReactDOM.createRoot(document.getElementById('root')).render(
    <UserContextProvider>
    <MovieContextProvider>
        <App />
    </MovieContextProvider>
    </UserContextProvider>
)
