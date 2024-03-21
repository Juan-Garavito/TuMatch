import { MovieCard } from "./MovieCard"

export function ListMovie({title, movies, onDragOver, onDrop, onDrag}){   
    
    return(
        <ul className="min-h-80 w-2/4" droppable="true"
        onDragOver={onDragOver} 
        onDrop={onDrop}>
          <h2 className="text-center">{title}</h2>
          {movies && movies.map((movie)=>(
            <li key={movie.idMovie} className="flex justify-center">
                <MovieCard 
                  title={movie.title}
                  release_date={movie.release_date}
                  cover={import.meta.env.VITE_URL_COVER  + movie.backdrop_path}
                  overview={movie.overview}
                  onDrag={(e)=>onDrag(e,movie)}  
                />
            </li>     
          ))}
        </ul>
    )
}