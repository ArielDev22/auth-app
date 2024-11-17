import api from "./axiosConfig";

const registerUser = async (userData) => {
  try {
    const response = await api.post("auth/register", userData);

    if (response.data.status === "sucesso") {
      return response.data;
    }
  } catch (error) {
    throw new Error("Erro ao registrar o usuário: ", error.message);
  }
};

export default registerUser;
