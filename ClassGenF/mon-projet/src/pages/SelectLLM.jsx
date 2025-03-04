import { useState } from "react";
import "../pages/SelectLLM.css";


export default function SelectLLM() {
  const [selectedLLM, setSelectedLLM] = useState("Ollama");

  return (
    <div className="llm-container">
      <h2>🔍 Sélection du modèle LLM</h2>
      
      <select value={selectedLLM} onChange={(e) => setSelectedLLM(e.target.value)}>
        <option value="ollama">Ollama</option>
      </select>

      <p>Modèle sélectionné : <strong>{selectedLLM}</strong></p>
    </div>
  );
}
