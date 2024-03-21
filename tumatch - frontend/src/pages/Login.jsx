import { useEffect, useRef, useState } from "react"
import { redirect, useNavigate } from "react-router-dom"

export function Login() {

    const [data, setData] = useState(null)
    const form = useRef(null)
    const render = useRef(true)
    const navigate = useNavigate()

    useEffect(()=>{
        if(!render.current){
            fetch(import.meta.env.VITE_URL_API_MOVIE + "/login.user",{
                method: "POST",
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            })
            .then(res=>res.json())
            .then(res=>{
                useNavigate
                if(res != null){
                    navigate("/boardMovies")
                }
            })
        }
        
    },[data])
    
    function onClick(e){
        e.preventDefault()
        render.current = false
        const dataForm = new FormData(form.current)
        setData(Object.fromEntries(dataForm))
        
    }


    return (
        <section className="absolute bg-pink-600 backdrop-blur-75 w-1/3 py-14 left-1/3 top-1/2 -translate-y-1/2  rounded-xl">
            <h2 className="text-center uppercase mb-2">Bienvenido a TuMatch</h2>
            <form ref={form} className="w-full m-auto my-2 flex flex-col items-center">
                <div className="flex w-full m-auto my-2 justify-center items-center">
                    <img src="./user-solid.svg" className="w-[4%] mx-2 " />
                    <input type="text" name="mail" placeholder="mail" className="rounded-xl p-2 basis-3/2" />
                </div>
                <div className="flex w-full m-auto my-2 justify-center">
                    <img src="./lock-solid.svg" className="w-[4%] mx-2" />
                    <input type="text" name="password" placeholder="password" className="rounded-xl p-2 basis-3/2" />
                </div>
                <input onClick={onClick} type="submit" value={"INGRESAR"} className="w-1/4 my-4 bg-white text-pink-600"/>
            </form>
        </section>
    )
}