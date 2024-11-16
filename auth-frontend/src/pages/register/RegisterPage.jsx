import "./RegisterPageStyle.css";

function RegisterPage() {
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
            <label htmlFor="email">Email*</label>
            <input 
            type="email"
            id="email"
            name="email"
            placeholder="nome@exemplo.com"
            autoComplete="off"
            required
            />
        </div>

        <div className="auth-input-fields">
            <label htmlFor="name">Nome*</label>
            <input 
            type="text"
            id="name"
            name="name"
            placeholder="Seu nome"
            autoComplete="off"
            required
            />
        </div>

        <div className="auth-input-fields">
            <label htmlFor="password">Senha*</label>
            <input 
            type="password"
            id="password"
            name="password"
            placeholder="Sua senha"
            autoComplete="off"
            required
            />
        </div>

        <div className="auth-input-fields">
            <label htmlFor="conf-password">Confirmar senha*</label>
            <input 
            type="password"
            id="conf-password"
            name="conf-password"
            placeholder="Digite sua senha novamente"
            autoComplete="off"
            required
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
