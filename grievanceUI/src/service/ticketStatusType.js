import api from "./axios";

export const allTicketStatus = async () => {
    const res = await api.get('ticket-status/all');
        return res;
  } 