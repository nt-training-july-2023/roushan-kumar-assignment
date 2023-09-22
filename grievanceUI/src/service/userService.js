import api from "./axios";

export const saveUser = async (user)=>{
        const url = '/user/save';
        const result = await api.post(url, user);
        return result;
}

export const allUsersService = async (params)=>{
        const url = '/user/all';
        const result = await api.get(url, params);
        return result;
}