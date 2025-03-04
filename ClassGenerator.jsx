import { useState } from "react";
import Editor from "@monaco-editor/react";

export default function ClassGenerator() {
  const [prompt, setPrompt] = useState("");
  const [generatedClass, setGeneratedClass] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleGenerate = async () => {
    setLoading(true);
    setError("");
    setGeneratedClass("");

    try {
      const response = await fetch("http://localhost:8080/api/generateClass", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ prompt }),
      });

      if (!response.ok) {
        throw new Error("Erreur lors de la génération du code.");
      }

      const data = await response.text();
      setGeneratedClass(data);
    } catch (err) {
      setError(err.message);
    }

    setLoading(false);
  };

  return (
    <div className="max-w-2xl mx-auto p-6 bg-gray-100 shadow-lg rounded-lg">
      <h1 className="text-2xl font-bold mb-4">Générateur de Classe Java</h1>

      {/* Champ de saisie */}
      <textarea
        className="w-full p-2 border rounded-md"
        placeholder="Décris la classe que tu veux générer..."
        value={prompt}
        onChange={(e) => setPrompt(e.target.value)}
      ></textarea>

      {/* Bouton d'envoi */}
      <button
        className="mt-4 bg-blue-500 text-white px-4 py-2 rounded-md hover:bg-blue-600"
        onClick={handleGenerate}
        disabled={loading}
      >
        {loading ? "Génération..." : "Générer"}
      </button>

      {/* Affichage des erreurs */}
      {error && <p className="text-red-500 mt-4">{error}</p>}

      {/* Affichage du code généré avec Monaco Editor */}
      {generatedClass && (
        <div className="mt-4 border rounded-lg overflow-hidden">
          <Editor
            height="400px"
            defaultLanguage="java"
            value={generatedClass}
            theme="vs-dark"
            options={{
              readOnly: true,
              minimap: { enabled: false },
            }}
          />
        </div>
      )}
    </div>
  );
}
