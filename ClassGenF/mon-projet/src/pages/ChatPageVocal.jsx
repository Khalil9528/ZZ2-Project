// src/pages/ChatPage.jsx
import React, { useState } from "react";
import SpeechToText from "../Components/SpeechToText";
import "../pages/ChatPageVocal.css";


const ChatPageVocal = () => {
    const [response, setResponse] = useState("");

    // Fonction appelée lorsque le texte vocal est généré
    const handleTextGenerated = async (text) => {
        try {
            // Envoi du texte au backend via une requête POST
            const res = await fetch("http://localhost:8080/api/llm/generate", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ text }),
            });
            const data = await res.text(); // Récupération de la réponse du backend
            setResponse(data); // Mise à jour de l'état avec la réponse du backend
        } catch (error) {
            console.error("Erreur lors de l'envoi au backend :", error);
        }
    };

    return (
        <div className="p-8">
            <h1 className="text-2xl mb-4">Page de Chat - Reconnaissance Vocale</h1>
            <SpeechToText onTextGenerated={handleTextGenerated} />
            {response && <p>Réponse du serveur : {response}</p>}
        </div>
    );
};

export default ChatPageVocal;
