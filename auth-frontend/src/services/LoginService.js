import api from "./axiosConfig";

const login = async (userData) => {
  try {
    const response = await api.post("auth/login", userData);

    if (response.data.status === "sucesso") {
      return response.data;
    }
  } catch (error) {
    if(error.response && error.response.data){
        throw new Error(error.response.data.message);
    }
  }
};

export default login;
