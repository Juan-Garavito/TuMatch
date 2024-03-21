import { useState } from "react"
import { ListMovie } from "./ListMovie"


export function BoardMovie({movies, onDrop}) {

    const [movieDrag, setMovieDrag] = useState(null)

    function onDrag(e, item) {
        e.preventDefault()
        setMovieDrag(item)
    }

    function onDragOver(e) {
        e.preventDefault()
    }

    console.log(movies)

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