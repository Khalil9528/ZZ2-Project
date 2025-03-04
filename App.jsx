import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import ChatPage from "./pages/ChatPage";
import SelectLLM from "./pages/SelectLLM";
import React from "react";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/chat/:chatId" element={<ChatPage />} />
        <Route path="/select-llm" element={<SelectLLM />} />
      </Routes>
    </Router>
  );
}

export default App;
