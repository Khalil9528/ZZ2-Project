import { useState } from "react";

export default function ChatInput({ onSend }) {
  const [prompt, setPrompt] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!prompt.trim()) return;
    onSend(prompt);
    setPrompt("");
  };

  return (
    <form onSubmit={handleSubmit} className="flex mt-4">
      <input
        type="text"
        className="flex-1 p-2 border rounded bg-gray-800 text-white"
        placeholder="Pose une question..."
        value={prompt}
        onChange={(e) => setPrompt(e.target.value)}
      />
      <button type="submit" className="ml-2 px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600">
        Envoyer
      </button>
    </form>
  );
}
