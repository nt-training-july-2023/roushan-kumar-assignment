function NewTicketValid(ticket) {
  if (ticket.title.trim() === "") {
    return "Ticket Title is required";
  }
  if (ticket.description.trim() === "") {
    return "Ticket Description is required";
  }
  if (ticket.department.deptId === "0" || ticket.department.deptId === "" )
    return "Select Department."
  if (ticket.ticketType.ticketName === "0" || ticket.ticketType.ticketName === "" )
    return "Select Ticket Type."

  return false;
}

export default NewTicketValid