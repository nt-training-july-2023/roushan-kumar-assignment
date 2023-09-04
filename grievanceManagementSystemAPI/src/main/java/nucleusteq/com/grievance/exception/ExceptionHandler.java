package nucleusteq.com.grievance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    public String userNotFoundException2(UserNotFoundException ex) {
        return ex.getMessage();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(InternalServerError.class)
    public String internalServerError(InternalServerError ex) {
        return ex.getMessage();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(BadRequestError.class)
    public String internalServerError(BadRequestError ex) {
        return ex.getMessage();
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//  	@ExceptionHandler(MethodArgumentNotValidException.class)
//  	public Map<String, String> handleInvalidException(MethodArgumentNotValidException ex) {
//  		Map<String, String> errMap = new HashMap<>();
//  		ex.getBindingResult().getFieldErrors()
//  				.forEach(error -> errMap.put(error.getField(), error.getDefaultMessage()));
//  		return errMap;
//  	}
}

