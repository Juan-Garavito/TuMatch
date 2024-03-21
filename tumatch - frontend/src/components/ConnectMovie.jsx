import { useRef,  useState } from "react";
import { MovieCard } from "./components/MovieCard";
import * as SockJS from 'sockjs-client';
import * as Stomp from 'stompjs';


const userPrueba = {
  idUser : 3
}

export function ConnectMovie() {
  const [movies, setMovies] = useState(null)
  const [indexMovie, setIndexMovie] = useState(0)
  const [stateMovie, setStateMovie] = useState("")


  const stompClientRef = useRef(null)

  function getMovies(payload) {
    setMovies(JSON.parse(payload.body))
  }

  function change(input){
    console.log(input)
    userPrueba.idUser = parseInt(input.target.value)
  }

  console.log(stateMovie)

  function getStateMovies(payload) {
    const data = JSON.parse(payload.body)
    
    if(data.userState === "CONTINUE"){
      setIndexMovie((beforeIndex) => beforeIndex + 1)
      setStateMovie(data.userState)
      
    }
    if(data.idUser === userPrueba.idUser && data.userState === "STOP"){
      setStateMovie(data.userState)
      console.log("ESPERA.....")
    }     
    
  }                                                                                     

  function onConnect(){
      console.log("conectado con web-socket")
      stompClientRef.current.subscribe("/peliculas/2", getMovies)
      stompClientRef.current.subscribe("/peliculas/eleccion/2", getStateMovies)

      fetch("http://localhost:8080/conectar/2")
        .then(res=>res.json())
        .then(res=>console.log(res))
  }

  function onError(){
    console.log("error conectando con web-socket")
 }
    
  function conectar(e){
    e.preventDefault()

    let socket = new SockJS("http://localhost:8080/ws-connect")
    stompClientRef.current = Stomp.over(socket)

    stompClientRef.current.connect({},onConnect, onError)

}

  function selectMovie(movie){

      fetch("http://localhost:8080/eleccion/2", {
        method: "POST",
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(movie)                                                                
      })

      
      
  }

  return(
    <>
      <button onClick={conectar}>Peliculas</button> 
      <input type="text" onChange={change}/>
      {stateMovie === "STOP" ? <p>Esperando a tu pareja....</p> : movies && <MovieCard movie={movies.results[indexMovie]} selectMovie={selectMovie}/>}
    </>
    ) 
    
}