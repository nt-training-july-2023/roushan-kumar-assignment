import api from "../assets/axios";

export const allDepartment = async () => {
   
        const url = '/department/all';
        const res = await api.get(url);
        return res;

}

export const saveDepartment = async (requestBody, userId, password, username) => {
        const url = "/department/save/" + userId;
        const headers = {
            "password":password,
            "username":username,
          };
        const res = await api.post(url, requestBody, { headers });
        return res;
}

