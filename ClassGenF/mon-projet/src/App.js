// src/App.jsx
import React from "react";
import { BrowserRouter as Router, Routes, Route, NavLink } from "react-router-dom";
import Home from "./pages/Home";
import ChatPage from "./pages/ChatPage";
import SelectLLM from "./pages/SelectLLM";
import ChatPageVocal from "./pages/ChatPageVocal";
import "./App.css"; // Importer la feuille de style CSS

const App = () => {
    return (
        <Router>
            {/* Barre de navigation stylée */}
            <nav className="navbar">
                <h1 className="navbar-logo">ClassGen</h1>
                <div className="navbar-links">
                    <NavLink exact="true" to="/" className="nav-link" activeclassname="active">
                        Accueil
                    </NavLink>
                    <NavLink to="/chatvocal" className="nav-link" activeclassname="active">
                        Conversation vocale
                    </NavLink>
                    <NavLink to="/select-llm" className="nav-link" activeclassname="active">
                        Sélectionner un LLM
                    </NavLink>
                    <NavLink to="/chat" className="nav-link" activeclassname="active">
                        Chat
                    </NavLink>
                </div>
            </nav>

            {/* Définition des routes de l'application */}
            <div className="main-content">
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/chatvocal" element={<ChatPageVocal />} />
                    <Route path="/chat" element={<ChatPage />} />
                    <Route path="/select-llm" element={<SelectLLM />} />
                    <Route path="*" element={<h1>Page non trouvée</h1>} />
                </Routes>
            </div>
        </Router>
    );
};

export default App;
