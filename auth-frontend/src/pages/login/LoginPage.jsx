import { useState } from "react";
import login from "../../services/LoginService";
import { useNavigate } from "react-router-dom";

function loginPage() {
  // navigate
  const navigate = useNavigate();

  // STATES
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  // ERROR STATES
  const [invalidCrendetials, setInvalidCrendetialsError] = useState("");

  const submitData = async (e) => {
    e.preventDefault();

    setInvalidCrendetialsError("");

    const userData = { email, password };

    try {
      const response = await login(userData);

      localStorage.setItem('token', response.data.token);
      localStorage.setItem('userName', response.data.name);

      alert(response.message);

      navigate("/home");
    } catch (error) {
      console.error("Erro de login:", error);

      setInvalidCrendetialsError(error.message);
    }
  };

  return (
    <div className="auth">
      <div className="auth-head">
        <h1 className="auth-title">Login</h1>
        <h4 className="auth-subtitle">
          Não tem uma conta? <a href="/auth/register">Registre-se!</a>
        </h4>
      </div>

      <div className="auth-form">
        <div className="auth-input-fields">
          <label htmlFor="email">Email</label>
          <input
            type="email"
            id="email"
            name="email"
            placeholder="Seu email"
            autoComplete="off"
            required
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>

        <div className="auth-input-fields">
          <label htmlFor="password">Password</label>
          <input
            type="password"
            id="password"
            name="password"
            placeholder="Sua senha"
            autoComplete="off"
            required
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </div>

        {invalidCrendetials && (
            <div className="error-message">
                <p>{invalidCrendetials}</p>
            </div>
        )}

        <div className="action-button">
          <button type="submit" onClick={submitData}>
            Login
          </button>
        </div>
      </div>
    </div>
  );
}

export default loginPage;
