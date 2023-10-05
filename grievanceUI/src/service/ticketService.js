import api from "./axios";

export  const saveTicket = async (ticket)=> {
    const url = "/ticket/save" ;
    const result = await api.post(url,ticket);
    return result;
}

export const tickets = async (params,UID) => {
        const url = "/ticket/all/new/" + UID;
        const res = await api.get(url, params)
        return res;
}

