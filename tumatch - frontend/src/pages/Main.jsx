import { useState } from "react";
import { BoardMovie } from "../components/BoardMovie"
import { useEffect } from "react";
import { SearchMovie} from "../components/SearchMovie"

export function Main() {

    const [movies, setMovies] = useState(null);


    useEffect(() => {
        fetch(import.meta.env.VITE_URL_API_MOVIE + "/find.movie.all")
            .then(res => res.json())
            .then(res => {
                const watched = res.filter(movie => movie.watched)
                const unseen = res.filter(movie => !movie.watched)
                setMovies({ watched: watched, unseen: unseen })
            })

    }, [])


    function onDrop(list, movieDrag){

        console.log("Drag: " + JSON.stringify(movieDrag))
        if (list == "unseen" && movies.watched.some(movie => movie.idMovie == movieDrag.idMovie)) {
            const watched = movies.watched.filter(movie => movie.idMovie != movieDrag.idMovie)
            setMovies({ watched: watched, unseen: [...movies.unseen, movieDrag] })
            return
        }
        
        if (list == "watched" && movies.unseen.some(movie => movie.idMovie == movieDrag.idMovie)) {
            const unseen = movies.unseen.filter(movie => movie.idMovie != movieDrag.idMovie)
            console.log(unseen)
            setMovies({ watched: [...movies.watched, movieDrag], unseen: unseen })
            return
        }
    }

    function stateSearch(movie) {
        const newMovie = {
            ...movie,
            idMovieMovie: movie.idMovie,
            idMovieCouple: 1,
            watched: false
        }

        delete newMovie.idMovie

        console.log(newMovie)
        fetch(import.meta.env.VITE_URL_API_MOVIE + "/save.movie", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(newMovie)
        })
            .then(res => res.json())
            .then(res => console.log(res))
    }

    return (
        <>
            {
                <>
                    <SearchMovie stateSearch={stateSearch} />
                    <BoardMovie movies={movies} onDrop={onDrop} />
                </>
            }
        </>
    )
}