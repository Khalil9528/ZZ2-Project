// src/components/SpeechToText.jsx
import React, { useState } from "react";

// Définition du composant SpeechToText
const SpeechToText = ({ onTextGenerated }) => {
    // Déclaration des états locaux avec useState
    const [isListening, setIsListening] = useState(false); // Gère l'état d'écoute
    const [transcript, setTranscript] = useState(""); // Stocke le texte converti depuis la voix

    // Fonction pour démarrer la reconnaissance vocale
    const startListening = () => {
        // Création d'une instance de l'API Web Speech Recognition
        const recognition = new (window.SpeechRecognition || window.webkitSpeechRecognition)();
        recognition.lang = "fr-FR"; // Définit la langue en français
        recognition.interimResults = false; // Ne renvoie que le résultat final
        recognition.maxAlternatives = 1; // Limite à une seule interprétation

        // Mise à jour de l'état lors du démarrage de l'écoute
        recognition.onstart = () => setIsListening(true);

        // Mise à jour de l'état lorsque l'écoute s'arrête
        recognition.onend = () => setIsListening(false);

        // Gestion des résultats de la reconnaissance vocale
        recognition.onresult = (event) => {
            const speechResult = event.results[0][0].transcript; // Récupère le texte détecté
            setTranscript(speechResult); // Met à jour le texte affiché
            onTextGenerated(speechResult); // Envoie le texte au parent (backend)
        };

        recognition.start(); // Lance la reconnaissance vocale
    };

    return (
        <div className="p-4">
            <button
                className="px-4 py-2 bg-blue-500 text-white rounded"
                onClick={startListening}
                disabled={isListening}
            >
                {isListening ? "Écoute en cours..." : "Parler"}
            </button>
            {transcript && <p>Texte détecté : {transcript}</p>}
        </div>
    );
};

export default SpeechToText;


/*

useState :

isListening : Gère l'état d'écoute (vrai/faux).
transcript : Contient le texte reconnu par la voix.
startListening :

Instancie SpeechRecognition ou webkitSpeechRecognition pour compatibilité avec tous les navigateurs.
Configure la langue en français (fr-FR).
Évite les résultats intérimaires (interimResults = false).
Limite les alternatives à 1 (maxAlternatives = 1).
Événements :

onstart et onend : Mettent à jour l'état isListening.
onresult : Récupère le texte prononcé et appelle la fonction onTextGenerated pour transmettre ce texte au composant parent ou au backend.
Interface utilisateur :

Un bouton déclenche l'écoute. Si l'écoute est active, le bouton affiche "Écoute en cours...".
Si un texte est détecté, il est affiché sous le bouton.

*/