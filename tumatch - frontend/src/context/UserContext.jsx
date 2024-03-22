import { Children, createContext, useState } from "react";

export const UserContext = createContext()

export function UserContextProvider(){
    const [user, setUser] = useState()
    
    return(
        <UserContext.Provider value={{user, setUser}}>
            {Children}
        </UserContext.Provider>
    )
}