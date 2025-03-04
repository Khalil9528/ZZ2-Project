# 🏆 ClassGen - Générateur de classes Java assisté par LLM

ClassGen est une **application web** qui permet de **générer dynamiquement des classes Java** à partir de simples **prompts en texte libre**. L'application utilise des **LLMs** (Large Language Models) comme **Ollama** ou **OpenAI**, et propose une **interface moderne** avec **React.js** et un **backend en Spring Boot**.

---

## 📌 **Table des matières**
- [🎯 Objectif du projet](#-objectif-du-projet)
- [⚙️ Architecture du projet](#-architecture-du-projet)
- [🛠️ Installation et configuration](#-installation-et-configuration)
- [🚀 Lancement du projet](#-lancement-du-projet)
- [📡 API et Modèles de Données](#-api-et-modèles-de-données)
- [💡 Fonctionnalités](#-fonctionnalités)
- [📜 Licence](#-licence)

---

## 🎯 **Objectif du projet**
ClassGen a pour but de simplifier la **génération de classes Java bien structurées**, en **analysant un prompt textuel** et en produisant un **code source propre et fonctionnel**. Il permet aux développeurs d'apprendre, d'expérimenter et de gagner du temps en **générant automatiquement du code**.

---

## ⚙️ **Architecture du projet**
ClassGen est divisé en **deux parties principales** :

1. **Backend (Spring Boot)** :
   - Fournit des **endpoints REST** pour interagir avec le modèle LLM
   - Communique avec **OpenAI API** ou **Ollama**
   - Gère les **discussions enregistrées** en mémoire ou en base de données

2. **Frontend (React.js)** :
   - Interface utilisateur **moderne et responsive**
   - Permet la **saisie et l'affichage** des discussions
   - Met en forme le **code généré avec un style inspiré de VS Code**

