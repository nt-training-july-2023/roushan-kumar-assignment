import api from "./axios";

export const allUsersType = async () =>{
        const url = '/role/all';
        const res = await api.get(url);
        return res;
}