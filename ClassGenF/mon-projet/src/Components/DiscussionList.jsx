import { useNavigate } from "react-router-dom";

export default function DiscussionList({ discussions }) {
  const navigate = useNavigate();

  return (
    <ul className="space-y-2">
      {discussions.map((chat) => (
        <li
          key={chat.id}
          className="p-4 bg-gray-800 rounded cursor-pointer hover:bg-gray-700"
          onClick={() => navigate(`/chat/${chat.id}`)}
        >
          {chat.title}
        </li>
      ))}
    </ul>
  );
}
