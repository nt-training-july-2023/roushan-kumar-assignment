import api from "./axios";

export const allTicketType = async () => {
        const url = '/ticket-type/all';
        const res = await api.get(url);
        return res;
}