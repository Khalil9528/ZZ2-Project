import { useState, useEffect } from "react";

export default function LLMSelector({ onSelect }) {
  const [selectedLLM, setSelectedLLM] = useState("Llama 3");

  useEffect(() => {
    const savedLLM = localStorage.getItem("defaultLLM") || "Llama 3.2";
    setSelectedLLM(savedLLM);
  }, []);

  const handleSelect = (llm) => {
    setSelectedLLM(llm);
    localStorage.setItem("defaultLLM", llm);
    onSelect(llm);
  };

  return (
    <div className="p-4 bg-gray-800 rounded">
      <h2 className="text-xl font-bold mb-2">Choisir un LLM</h2>
      <div className="space-y-2">
        {["Llama 3"].map((llm) => (
          <button
            key={llm}
            className={`block w-full px-4 py-2 rounded ${
              selectedLLM === llm ? "bg-blue-500" : "bg-gray-700 hover:bg-gray-600"
            }`}
            onClick={() => handleSelect(llm)}
          >
            {llm}
          </button>
        ))}
      </div>
    </div>
  );
}
