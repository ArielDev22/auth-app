export const validateEmail = (email) => {
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return emailRegex.test(email);
};

export const validateName = (name, setName, setNameError) => {
  setName(name);

  if (!name) {
    setNameError("O nome não pode estar em branco");
  } else {
    setNameError("");
  }
};

export const validatePassword = (password, setPassword, setPasswordError) => {
  setPassword(password);

  if (password.length < 6) {
    setPasswordError("A senha deve ter no mínimo 6 caracteres");
  } else {
    setPasswordError("");
  }
};

export const validatePasswordConfirmation = (
  password,
  confPassword,
  setConfPassword,
  setConfPasswordError
) => {
  setConfPassword(confPassword);

  if (confPassword !== password) {
    setConfPasswordError("As senhas não coincidem");
  } else {
    setConfPasswordError("");
  }
};

export const handleEmailChange = (email, setEmail, setEmailError) => {
  setEmail(email);

  if (email && !validateEmail(email)) {
    setEmailError("Formato de email inválido");
  } else {
    setEmailError("");
  }
};
