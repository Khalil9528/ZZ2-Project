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

### **1️⃣ Backend (Spring Boot)**
- Fournit des **endpoints REST** pour interagir avec le modèle LLM
- Communique avec **OpenAI API** ou **Ollama**
- Gère les **discussions enregistrées** en mémoire ou en base de données

### **2️⃣ Frontend (React.js)**
- Interface utilisateur **moderne et responsive**
- Permet la **saisie et l'affichage** des discussions
- Met en forme le **code généré avec un style inspiré de VS Code**

📂 mon_projet/
├── backend/          # Serveur Spring Boot
│   ├── controller/   # Gestion des requêtes
│   ├── service/      # Logique métier
│   ├── model/        # Modèles de données
│   ├── config/       # Configuration
│   ├── pom.xml       # Dépendances Maven
│   ├── application.properties # Configuration API OpenAI
│
├── frontend/         # Interface React.js
│   ├── src/pages/    # Pages principales (ChatPage, Home, etc.)
│   ├── src/components/ # Composants réutilisables
│   ├── src/styles/   # Feuilles de styles CSS
│   ├── package.json  # Dépendances React.js
│
├── README.md         # Documentation
└── .gitignore        # Fichiers ignorés
🛠️ Installation et configuration
1️⃣ Prérequis
Avant d’installer et de lancer le projet, assure-toi d’avoir :

Node.js (>= 18.x)
npm ou yarn
JDK 17+ (Java)
Maven (pour gérer les dépendances backend)
Clé API OpenAI (optionnel, mais recommandé)
2️⃣ Installation
📌 Cloner le projet
bash
Copier
Modifier
git clone https://github.com/ton-github/classgen.git
cd classgen
📌 Installation du backend (Spring Boot)
bash
Copier
Modifier
cd backend
mvn clean install
📌 Installation du frontend (React.js)
bash
Copier
Modifier
cd frontend
npm install
📌 Configuration de l'API OpenAI
Ajoute ta clé API OpenAI dans backend/src/main/resources/application.properties :

properties
Copier
Modifier
openai.api.key=sk-XXXXXXXXXXXXXXXXXXXXXXXX
openai.api.url=https://api.openai.com/v1/completions
🚀 Lancement du projet
Démarrer le backend (Spring Boot)
bash
Copier
Modifier
cd backend
mvn spring-boot:run
📌 Le serveur est disponible sur http://localhost:8080

Démarrer le frontend (React)
bash
Copier
Modifier
cd frontend
npm start
📌 L'interface est accessible sur http://localhost:3000

📡 API et Modèles de Données
🔹 Endpoint pour générer du code Java
http
Copier
Modifier
POST /api/llm/generate
📌 Body de la requête
json
Copier
Modifier
{
  "prompt": "Créer une classe Java nommée Person"
}
📌 Réponse
json
Copier
Modifier
{
  "generatedCode": "public class Person { private String name; }"
}
💡 Fonctionnalités
✅ Génération automatique de classes Java
✅ Intégration avec OpenAI et Ollama
✅ Interface utilisateur moderne avec React.js
✅ Affichage formaté du code généré (comme dans VS Code)
✅ Gestion des discussions enregistrées (localStorage)
✅ Déploiement avec Docker (optionnel)

📜 Licence
Ce projet est sous licence MIT. 🚀
N'hésite pas à contribuer et améliorer ClassGen pour le rendre encore plus performant ! 🎉
