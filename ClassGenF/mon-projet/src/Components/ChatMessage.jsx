export default function ChatMessage({ message, isUser }) {
    return (
      <div className={`flex ${isUser ? "justify-end" : "justify-start"} my-2`}>
        <div className={`p-3 rounded-lg ${isUser ? "bg-blue-500 text-white" : "bg-gray-700 text-white"}`}>
          <p>{message}</p>
        </div>
      </div>
    );
  }
  