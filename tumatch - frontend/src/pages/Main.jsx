import { useContext } from "react";
import { BoardMovie } from "../components/BoardMovie"
import { useEffect } from "react";
import { SearchMovie} from "../components/SearchMovie"
import { MovieContext } from "../context/MovieContext";

export function Main() {

    const {movies, setMovies} = useContext(MovieContext);


    useEffect(() => {
        fetch(import.meta.env.VITE_URL_API_MOVIE + "/find.movie.all")
            .then(res => res.json())
            .then(res => {
                const watched = res.filter(movie => movie.watched)
                const unseen = res.filter(movie => !movie.watched)
                setMovies({ watched: watched, unseen: unseen })
            })

    }, [])


    return (
        <>
            {
                <>
                    <SearchMovie />
                    <BoardMovie movies={movies} setMovies={setMovies} />
                </>
            }
        </>
    )
}