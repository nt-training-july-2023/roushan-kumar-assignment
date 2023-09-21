import api from "../assets/axios";

export const saveUser = async (user)=>{
        const url = '/user/save';
        const result = await api.post(url, user);
        return result;
}