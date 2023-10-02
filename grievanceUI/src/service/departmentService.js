import api from "./axios";

export const allDepartment = async (params) => {
   
        const url = '/department/all';
        const res = await api.get(url, params);
        return res;

}

export const saveDepartment = async (requestBody, userId, password, username) => {
        const url = "/department/admin/save/" + userId;
        const headers = {
            "password":password,
            "username":username,
          };
        const res = await api.post(url, requestBody, { headers });
        return res;
}

export const deleteDepartment = async ( departmentId, password, username) =>{
        const url = "/department/admin/delete/" + departmentId;
        const headers = {
            "password":password,
            "username":username,
          };
        const res = await api.delete(url, { headers });
        return res;
}

