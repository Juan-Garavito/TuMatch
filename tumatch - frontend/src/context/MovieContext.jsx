import { useState } from "react"
import { createContext } from "react"

export const MovieContext = createContext()

export function MovieContextProvider({children}){
    const [movies, setMovies] = useState([])
    
    return(
        <MovieContext.Provider value={{movies, setMovies}}>
            {children}      
        </MovieContext.Provider>
    )
}