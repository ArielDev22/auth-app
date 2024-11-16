import { useState } from "react";
import "./RegisterPageStyle.css";
import {
  handleEmailChange,
  validateName,
  validatePassword,
  validatePasswordConfirmation,
} from "../../utils/FormDataValidator";

function RegisterPage() {
  // STATES
  const [email, setEmail] = useState("");
  const [name, setName] = useState("");
  const [password, setPassword] = useState("");
  const [confPassword, setConfPassword] = useState("");

  // ERROR STATES
  const [emailError, setEmailError] = useState("");
  const [nameError, setNameError] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const [confPasswordError, setConfPasswordError] = useState("");

  return (
    <div className="auth">
      <div className="auth-head">
        <h1 className="auth-title">Criar conta</h1>
        <h4 className="auth-subtitle">
          Já tem uma conta? <a href="/login">Faça seu login aqui!</a>
        </h4>
      </div>

      <div className="auth-form">
        <div className="auth-input-fields">
          <label htmlFor="email" className={emailError ? "errorLabel" : ""}>
            {emailError || "Email*"}
          </label>
          <input
            type="email"
            id="email"
            name="email"
            placeholder="nome@exemplo.com"
            autoComplete="off"
            required
            value={email}
            onChange={(e) =>
              handleEmailChange(e.target.value, setEmail, setEmailError)
            }
          />
        </div>

        <div className="auth-input-fields">
          <label htmlFor="name" className={nameError ? "errorLabel" : ""}>
            {nameError || "Nome*"}
          </label>
          <input
            type="text"
            id="name"
            name="name"
            placeholder="Seu nome"
            autoComplete="off"
            required
            value={name}
            onChange={(e) =>
              validateName(e.target.value, setName, setNameError)
            }
          />
        </div>

        <div className="auth-input-fields">
          <label
            htmlFor="password"
            className={passwordError ? "errorLabel" : ""}
          >
            {passwordError || "Senha*"}
          </label>
          <input
            type="password"
            id="password"
            name="password"
            placeholder="Sua senha"
            autoComplete="off"
            required
            value={password}
            onChange={(e) =>
              validatePassword(e.target.value, setPassword, setPasswordError)
            }
          />
        </div>

        <div className="auth-input-fields">
          <label
            htmlFor="conf-password"
            className={confPasswordError ? "errorLabel" : ""}
          >
            {confPasswordError || "Confirmar senha*"}
          </label>
          <input
            type="password"
            id="conf-password"
            name="conf-password"
            placeholder="Digite sua senha novamente"
            autoComplete="off"
            required
            value={confPassword}
            onChange={(e) =>
              validatePasswordConfirmation(
                password,
                e.target.value,
                setConfPassword,
                setConfPasswordError
              )
            }
          />
        </div>

        <div className="action-button">
          <button type="submit">Criar conta</button>
        </div>
      </div>
    </div>
  );
}

export default RegisterPage;
