export function MovieCard({title, release_date, cover, overview, calificacion, onDrag, onClick}){
    calificacion = ["1" , "4"]

    return(
        <section onDrag={onDrag} onClick={onClick} draggable
            className="text-ellipsis overflow-hidden w-2/4 p-2.5 m-2.5 border-[1px] border-pink-400">
                <h2 draggable="false">{title}</h2>
                <p draggable="false">({release_date})</p>
                <img draggable="false" src={cover}/>
                <p draggable="false">{overview}</p>
                {calificacion &&
                <>
                    <div
                        className="flex justify-between items-center hover:bg-pink-400 cursor-pointer hover:scale-[1.1] transition-all ">
                        <img className="w-[50px]" src="https://storage.googleapis.com/sticker-prod/HK2dzYZzHjC4J6Pa8g1l/cover.thumb256.png" alt="" />
                        <input className="w-6 text-center" type="text" defaultValue={calificacion[1]}/>
                        <input className="w-6 text-center" type="text"  defaultValue={calificacion[0]} readOnly/>
                        <img className="w-[50px]" src="https://osaka.nyc3.cdn.digitaloceanspaces.com/GG8_s1_webp_m_18/sticker-fan_2775004_m.webp" alt="" />
                    </div>
                </>
                }
        </section>
    )
}

