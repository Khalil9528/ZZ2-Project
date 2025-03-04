import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import "../pages/Home.css";

export default function Home() {
  const [discussions, setDiscussions] = useState([]);
  const navigate = useNavigate();

  // Charger les discussions depuis le localStorage au montage du composant
  useEffect(() => {
    const savedDiscussions = JSON.parse(localStorage.getItem("discussions")) || [];
    setDiscussions(savedDiscussions);
  }, []);

  // Créer une nouvelle discussion et rediriger immédiatement vers la page de chat
  const createNewDiscussion = () => {
    const title = prompt("Entrez un titre pour la discussion :") || "Nouvelle discussion";
    
    const newDiscussion = {
      id: Date.now(),
      title,
      messages: [],
    };

    const updatedDiscussions = [newDiscussion, ...discussions];

    setDiscussions(updatedDiscussions);
    localStorage.setItem("discussions", JSON.stringify(updatedDiscussions));

    // Rediriger vers la discussion immédiatement après sa création
    navigate(`/chat/${newDiscussion.id}`);
  };

  return (
    <div className="home-container">
      <h1>📜 Discussions</h1>

      {/* Liste des discussions */}
      <ul>
        {discussions.map((chat) => (
          <li key={chat.id} onClick={() => navigate(`/chat/${chat.id}`)} className="chat-item">
            {chat.title}
          </li>
        ))}
      </ul>

      {/* Bouton pour créer une discussion */}
      <button onClick={createNewDiscussion} className="new-discussion-btn">
        ➕ Nouvelle Discussion
      </button>
    </div>
  );
}
