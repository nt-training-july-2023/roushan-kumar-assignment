import api from "../assets/axios";

export const allTicketType = async () => {
        const url = '/ticketType/all';
        const res = await api.get(url);
        return res;
}