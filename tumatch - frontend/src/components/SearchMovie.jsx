import { useState, useEffect, useRef, useContext } from "react"
import { MovieCard } from "./MovieCard.jsx";
import { MovieContext } from "../context/MovieContext.jsx";

export function SearchMovie() {

    const inputSearch = useRef(null)
    const [searchMovies, setSearchMovies] = useState(null)
    const [search, setSearch] = useState(null)
    const { movies, setMovies } = useContext(MovieContext)

    useEffect(() => {
        if (search != "" && search != null) {
            fetch(import.meta.env.VITE_URL_API_MOVIE + /search/ + search)
                .then(res => res.json())
                .then(res => setSearchMovies(res))
        }
    }, [search])


    function selectMovie(movie) {
        inputSearch.current.value = ""
        setSearch("")

        const newMovie = {
            ...movie,
            idMovie: movie.id,
            idMovieCouple: 1,
            watched: false
        }

        delete newMovie.id


        fetch(import.meta.env.VITE_URL_API_MOVIE + "/save.movie", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(newMovie)
        })
            .then(res => res.json())
            .then(res => {
                setMovies({watched: movies.watched, unseen: [...movies.unseen, newMovie]})
            })
    }

    return (
        <>
            <form className="flex flex-col items-center my-3.5">
                <label className="text-pink-400 uppercase font-mono stroke-cyan-500">Search for the movie you want to add....</label>
                <input ref={inputSearch} className="text-sm rounded-lg block w-1/3 p-2.5 my-1 dark:bg-pink-400  dark:text-white uppercase"
                    type="text" onChange={(e) => (setSearch(e.target.value))} />
            </form>
            <div className="flex flex-wrap justify-center">
                {searchMovies && search != "" ? searchMovies.results.map((movie) => (
                    <MovieCard key={movie.id}
                        title={movie.title}
                        release_date={movie.release_date}
                        cover={import.meta.env.VITE_URL_COVER + movie.backdrop_path}
                        overview={movie.overview}
                        onClick={(e) => selectMovie(movie)}
                    />
                ))
                    :
                    <>
                    </>}
            </div>
        </>
    )
}