import api from "../assets/axios";

export const allTicketStatus = async () => {
    const res = await api.get('ticketStatus/all');
        return res;
  } 