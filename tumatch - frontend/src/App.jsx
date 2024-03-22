import { Main } from "./pages/Main"
import { Login } from "./pages/Login"
import { BrowserRouter, Route, Routes } from "react-router-dom"

export function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<Login />} path="/"></Route>
        <Route element={<Main />} path="/boardMovies"></Route>
      </Routes>
    </BrowserRouter>

  )
}

