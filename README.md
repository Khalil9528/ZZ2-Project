🏆 ClassGen - Générateur de classes Java assisté par LLM
ClassGen est une application web permettant de générer dynamiquement des classes Java à partir de prompts en texte libre, en utilisant des LLMs (Large Language Models) comme Ollama ou OpenAI.
Cette application offre une interface moderne avec une gestion des discussions et une interaction en temps réel.

📌 Table des matières
🎯 Objectif du projet
⚙️ Architecture du projet
🛠️ Installation et configuration
🚀 Lancement du projet
📡 API et Modèles de Données
💡 Fonctionnalités
📷 Aperçu
📜 Licence
🎯 Objectif du projet
ClassGen vise à faciliter la génération de classes Java en fournissant un prompt textuel qui est ensuite analysé et traité par un LLM pour produire un code structuré.

🔹 Cas d'utilisation
Génération automatique de classes Java
Apprentissage et démonstration de la structure des classes Java
Test et exécution de code généré
⚙️ Architecture du projet
ClassGen est divisé en deux parties :

Backend : Spring Boot
Fournit des endpoints REST pour interagir avec le modèle LLM
Communication avec OpenAI API ou Ollama
Sauvegarde des discussions en mémoire (ou en base de données)
Frontend : React.js
Interface utilisateur moderne et responsive
Saisie et affichage des discussions
Affichage du code généré sous forme formatée
📁 Structure des fichiers
bash
Copier
Modifier
mon_projet/
│── backend/                  # Serveur Spring Boot
│   ├── src/main/java/com/classgen
│   │   ├── controller/        # Gestion des requêtes HTTP
│   │   ├── service/           # Logique métier (appel aux LLMs)
│   │   ├── model/             # Modèles de données
│   │   ├── config/            # Configuration de l'application
│   ├── pom.xml                # Dépendances Maven
│   ├── application.properties # Configuration Spring Boot
│
│── frontend/                  # Application React.js
│   ├── src/
│   │   ├── pages/             # Pages principales (ChatPage, Home...)
│   │   ├── components/        # Composants réutilisables
│   │   ├── App.js             # Routes et navigation
│   │   ├── styles/            # Feuilles de styles CSS
│   ├── package.json           # Dépendances React.js
│
│── README.md                  # Documentation
│── .gitignore                 # Fichiers à ignorer
│── Dockerfile                 # Déploiement (optionnel)
🛠️ Installation et configuration
1️⃣ Pré-requis
Node.js (>= 18.x)
npm ou yarn
JDK 17+ (Java)
Maven (pour gérer les dépendances du backend)
Spring Boot
Compte OpenAI (pour utiliser l’API GPT)
2️⃣ Cloner le projet
bash
Copier
Modifier
git clone https://github.com/ton-github/classgen.git
cd classgen
3️⃣ Installation du backend
bash
Copier
Modifier
cd backend
mvn clean install
4️⃣ Installation du frontend
bash
Copier
Modifier
cd frontend
npm install
5️⃣ Configuration de l'API OpenAI
Crée un fichier application.properties dans backend/src/main/resources/ et ajoute :

properties
Copier
Modifier
openai.api.key=sk-xxxxxx
openai.api.url=https://api.openai.com/v1/completions
🚀 Lancement du projet
Démarrer le backend (Spring Boot)
bash
Copier
Modifier
cd backend
mvn spring-boot:run
Le serveur écoute sur http://localhost:8080.

Démarrer le frontend (React)
bash
Copier
Modifier
cd frontend
npm start
L'application est disponible sur http://localhost:3000.

📡 API et Modèles de Données
📌 Endpoint pour générer du code Java
🔹 Requête
h
Copier
Modifier
POST /api/llm/generate
🔹 Body
json
Copier
Modifier
{
  "prompt": "Créer une classe Java nommée Person"
}
🔹 Réponse
json
Copier
Modifier
{
  "generatedCode": "public class Person { private String name; }"
}
💡 Fonctionnalités
✅ Génération automatique de classes Java via OpenAI ou Ollama
✅ Interface utilisateur moderne avec React.js
✅ Système de discussions enregistrées (localStorage)
✅ Affichage formaté du code généré (comme dans VS Code)
✅ Déploiement avec Docker (optionnel)

📷 Aperçu
🎨 Interface utilisateur
🖼️ ChatPage	🖼️ Code Généré
📜 Licence
Ce projet est sous licence MIT. Tu peux l'utiliser, le modifier et le redistribuer librement.
🚀 Amuse-toi bien avec ClassGen ! 😃
