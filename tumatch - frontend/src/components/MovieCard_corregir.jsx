import { useState, useRef } from "react"

export function MovieCard({movie, selectMovie}){
    const [click, setClick] = useState(false)
    const [translateCard, setTranslateCard] = useState(null)
    const card = useRef(null)
    const contentCard = useRef(null)
    const check = useRef(null)
    const xmark = useRef(null)
    
  
  
    function mouseMove(e){
    
      if(click){
        contentCard.current.style.transition = "all ease"
        xmark.current.style.transition = "all 0.5s ease 0s"
        check.current.style.transition = "all 0.5s ease 0s"
        card.current.style.transition = "all 1s ease 0s"
        // card.current.style.transform = "translate(0%)"

        console.log(card.current.style.transform)
        setTranslateCard(card.current.style.transform.split("(")[1].split("%")[0])

        if(e.pageX > (window.screen.width/2)){
          // card.current.style.rotate = `${50}deg`;    
          card.current.style.transform =  `translate(${80}%)`
          
        }else{
          card.current.style.transform =  `translate(${-80}%)`
          //card.current.style.rotate = `${-50}deg`;     
        }

        if(translateCard > 75){
          contentCard.current.style.boxShadow = " inset -124px 0px 179px -68px #55ff00" 
          check.current.style.width = "12%"
          check.current.style.border = "10px solid  #55ff00"
          check.current.style.borderRadius = "50%"
          // check.current.style.display = "block"
          xmark.current.style.width = "0%"
          xmark.current.style.border = "none"
          // xmark.current.style.display = "none"
        }
        
        if(translateCard < -75){
          contentCard.current.style.boxShadow = " inset 124px 0px 179px -68px rgba(255,0,0,1)"
          xmark.current.style.width = "12%"
          xmark.current.style.border = "10px solid  red"
          xmark.current.style.borderRadius = "50%"
          // xmark.current.style.display = "block"
          check.current.style.width = "0%"
          // check.current.style.display = "none"
          check.current.style.border = "none"
        }

      }
    }

    function mouseDown(e){
        setClick(true)
    }

    function mouseUp(e){

      if(translateCard > 75){
        selectMovie({
          pelicula: movie,
          statePelicula: "ACCEPTED",
          user: {
            idUser: 2,
            String: "Juan Camilo"
          }
        })
      }

      if(translateCard < -75){
        selectMovie({
          pelicula: movie,
          statePelicula: "REJECTED",
          user: {
            idUser: 2,
            String: "Juan Camilo"
          }
        })
      }

      card.current.style.transform =  `translate(${0}%)`
      contentCard.current.style.boxShadow = "none" 
      xmark.current.style.width = "0%"
      check.current.style.width = "0%"
      check.current.style.border = "none"
      xmark.current.style.border = "none"
      // check.current.style.display = "none"

      // xmark.current.style.display = "none"
      // card.current.style.rotate = `0deg`; 
      setClick(false)
    }


    return(
      <div onMouseUp={mouseUp} ref={contentCard} onMouseMove={mouseMove} className="w-[100vw] h-[100vh] overflow-hidden flex justify-center items-center">
          <img src="../check-solid.svg" ref={check} className="w-0 absolute left-3/4 z-10  p-10 " draggable="false"/>
          <div  ref={card}  onMouseDown={mouseDown} onMouseUp={mouseUp} className="p-2.5 w-[500px] border-[1px] border-sky-500 translate-x-0">
              <div className="cardMovie-title">{movie.title}</div>
              <img draggable="false" src={`https://image.tmdb.org/t/p/w500/${movie.backdrop_path}`}/>
              <p>{movie.overview}</p>
              <p>{movie.release_date}</p>
          </div>
          <img src="../xmark-solid.svg" ref={xmark} className="w-0 absolute right-3/4 z-10  p-10 " draggable="false"/>
      </div>
    )
}