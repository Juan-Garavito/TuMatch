import { useState } from "react"
import { ListMovie } from "./ListMovie"


export function BoardMovie({movies, setMovies}) {

    const [movieDrag, setMovieDrag] = useState(null)

    function onDrag(e, item) {
        e.preventDefault()
        setMovieDrag(item)
    }

    function onDragOver(e) {
        e.preventDefault()
    }

    function onDrop(typelist, movieDrag){

        if (typelist == "unseen" && movies.watched.some(movie => movie.idMovie == movieDrag.idMovie)) {
            const watched = movies.watched.filter(movie => movie.idMovie != movieDrag.idMovie)
            setMovies({ watched: watched, unseen: [...movies.unseen, movieDrag] })
            return
        }
        
        if (typelist == "watched" && movies.unseen.some(movie => movie.idMovie == movieDrag.idMovie)) {
            const unseen = movies.unseen.filter(movie => movie.idMovie != movieDrag.idMovie)
            setMovies({ watched: [...movies.watched, movieDrag], unseen: unseen })
            return
        }
    }


    return (
        <section className="flex justify-center w-full">
            {
                movies &&
                <>
                    <ListMovie
                        movies={movies.unseen}
                        title={"Movies you want to see"}
                        onDragOver={e => onDragOver(e)}
                        onDrop={() => onDrop("unseen", movieDrag)}
                        onDrag={onDrag}
                    />
                    <ListMovie
                        movies={movies.watched}
                        title={"Movies watched"}
                        onDragOver={e => onDragOver(e)}
                        onDrop={() => onDrop("watched", movieDrag)}
                        onDrag={onDrag}
                    />
                </>
            }
        </section>
    )
}