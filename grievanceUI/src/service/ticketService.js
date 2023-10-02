import api from "./axios";

export const saveTicket = async (ticket)=> {
    const url = "/ticket/save" ;
    const result = await api.post(url,ticket);
    return result;
}

