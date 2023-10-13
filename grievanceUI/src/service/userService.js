import { async } from "q";
import api from "./axios";

export const saveUser = async (user , password , username)=>{
        const url = '/user/admin/save';

        const headers = {
                "password":password,
                "username":username,
              };

        const result = await api.post(url, user, { headers });
        return result;
}

export const allUsersService = async (params)=>{
        const url = '/user/all';
        const result = await api.get(url, params);
        return result;
}

export const deleteUser = async (userId, password ,username)=>{
        const url = '/user/admin/delete/'+userId;

        const headers = {
                "password":password,
                "username":username,
              };

        const result = await api.delete(url, {headers});
        return result;
}

export const updatePassword = async (changePasswordObj) => {
      const url = '/user/change-password';
      const res = await api.put(url,changePasswordObj)
      return res
}