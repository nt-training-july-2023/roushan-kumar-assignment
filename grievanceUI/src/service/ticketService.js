import { async } from "q";
import api from "./axios";

export  const saveTicket = async (ticket)=> {
    const url = "/ticket/save" ;
    const result = await api.post(url,ticket);
    return result;
}

export const tickets = async (params,UID) => {
        const url = "/ticket/all/" + UID;
        const res = await api.get(url, params)
        return res;
}

export const updateTicket = async (ticketId, comment, params) => {
    const url = "/ticket/updates/ticket-comments/" + ticketId;
    const result = await api.put(url, comment , params);
    return result
}

export const ticketById = async (ticketId) => {
    const url = "ticket/" + ticketId;
    const res = await api.get(url)
    return res;
}