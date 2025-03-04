import { useParams } from "react-router-dom";
import { useState, useEffect } from "react";
import "../pages/ChatPage.css";


export default function ChatPage() {
  const { chatId } = useParams();
  const [messages, setMessages] = useState([]);
  const [input, setInput] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  // Charger les messages de la discussion depuis localStorage
  useEffect(() => {
    const savedDiscussions = JSON.parse(localStorage.getItem("discussions")) || [];
    const discussion = savedDiscussions.find(d => d.id === Number(chatId));
    if (discussion) setMessages(discussion.messages);
  }, [chatId]);

  // // Envoyer un message utilisateur
  // const sendMessage = () => {
  //   if (!input.trim()) return;

  //   const newMessages = [...messages, { sender: "user", text: input }];
  //   setMessages(newMessages);
  //   setInput("");

  //   // Simuler une réponse de l'IA
  //   setTimeout(() => {
  //     const botResponse = { sender: "bot", text: "🤖 Réponse générée..." };
  //     setMessages([...newMessages, botResponse]);
  //   }, 1000);
  // };

  // Générer une classe Java via le back-end
  const handleGenerate = async () => {
    if (!input.trim()) return;
    
    setLoading(true);
    setError("");

    try {
      const response = await fetch("http://localhost:8080/api/llm/generate", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ prompt: input }),
      });

      if (!response.ok) {
        throw new Error("Erreur lors de la connexion au serveur.");
      }

      const data = await response.text();
      const generatedMessage = { sender: "bot", text: `📝 Code généré :\n${data}` };

      // Ajouter la réponse générée au chat
      setMessages([...messages, { sender: "user", text: input }, generatedMessage]);
    } catch (err) {
      console.error("Erreur lors de la requête :", err);
      setError("Impossible de contacter le serveur.");
    }

    setLoading(false);
    setInput("");
  };

  return (
    <div className="chat-container">
      <h2>Discussion {chatId}</h2>

      {/* Zone d'affichage des messages */}
      <div className="chat-box">
        {messages.map((msg, index) => (
          <p key={index} className={msg.sender === "user" ? "user-msg" : "bot-msg"}>
            {msg.text}
          </p>
        ))}
      </div>

      {/* Zone de saisie du message */}
      <input
        type="text"
        value={input}
        onChange={(e) => setInput(e.target.value)}
        placeholder="Écris ton message..."
      />
      
      {/* Bouton envoyer un message */}
      {/* <button onClick={sendMessage} disabled={loading}>Envoyer</button> */}

      {/* Bouton pour générer une classe Java */}
      <button onClick={handleGenerate} disabled={loading}>
        {loading ? "Génération..." : "Générer une classe Java"}
      </button>

      {/* Affichage des erreurs */}
      {error && <p style={{ color: "red" }}>{error}</p>}
    </div>
  );
}
