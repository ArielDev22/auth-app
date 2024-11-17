import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import "./HomeStyle.css";

function home() {
  const navigate = useNavigate();
  const [userName, setUserName] = useState("");

  useEffect(() => {
    const token = localStorage.getItem('token');
    if (token) {
      const storedName = localStorage.getItem('userName');

      setUserName(storedName);
    } else {
      navigate("/auth/login");
    }
  }, [navigate]);

  return (
    <div>
      {userName && (
        <h1 className="home-message">Bem-vindo(a) {userName}!</h1>
      )}
    </div>
  );
}

export default home;
