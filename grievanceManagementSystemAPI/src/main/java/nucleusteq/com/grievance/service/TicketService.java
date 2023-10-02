package nucleusteq.com.grievance.service;

import java.util.List;

import nucleusteq.com.grievance.dto.AllTicketsDto;
import nucleusteq.com.grievance.dto.ResponseDto;
import nucleusteq.com.grievance.dto.TicketDto;
import nucleusteq.com.grievance.entity.Comments;

public interface TicketService {

  /**
   * Saves a ticket with the provided TicketDto.
   *
   * @param ticketDto The TicketDto representing the ticket to be saved.
   * @return A ResponseDto indicating the result of the save operation.
   */
  ResponseDto save(TicketDto ticketDto);

  /**
   * Updates the comments and status of a ticket.
   *
   * @param comments The Comments object containing the new comments.
   * @param ticketId The ID of the ticket to be updated.
   * @param statusId The ID of the new status for the ticket.
   * @return A ResponseDto indicating the result of the update operation.
   */
  ResponseDto updateTicketComments(
      Comments comments,
      Integer  ticketId,
      Integer statusId);

  /**
   * Retrieves a specific ticket by its ticket ID.
   *
   * @param ticketId  The ID of the ticket to retrieve.
   * @return          The TicketDto representing the retrieved ticket.
   */
  TicketDto getByTicketId(Integer ticketId);

  /**
  * Retrieves a list of tickets based on specified conditions.
  *
  * @param userId      The ID of the user for whom tickets are to be retrieved.
  * @param departId    The ID of the department for filtering tickets.
  * @param createdByMe Boolean flag indicating whether
  * to filter by tickets created by the user.
  * @param offset
  * @param pageSize
  * @param status
  * @return A list of TicketDto objects that meet the specified conditions.
  */
  List<AllTicketsDto> getAllByCondition(Integer userId,
      Integer departId,
      Boolean createdByMe,
      Integer offset,
      Integer pageSize,
      String status);
}

