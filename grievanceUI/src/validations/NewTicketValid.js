function NewTicketValid(ticket) {
   console.log("validation on "+ticket.title);
  if (ticket.title.trim() === "") {
    return "Ticket title is required";
  }
  if (ticket.description.trim() === "") {
    return "Ticket description is required";
  }
  if (ticket.department.deptName === "0" || ticket.department.deptName === "" )
    return "Select department."
  if (ticket.ticketType.ticketName === "0" || ticket.ticketType.ticketName === "" )
    return "Select ticket type."

  return false;
}

export default NewTicketValid