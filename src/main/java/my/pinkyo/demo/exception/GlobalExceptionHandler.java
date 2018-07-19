package my.pinkyo.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ValidationException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleExceptin(Exception ex) {
        return HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleValidationException(ValidationException ve) {
        return HttpStatus.BAD_REQUEST.getReasonPhrase();
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(BadRequestException bre) {
        return HttpStatus.NOT_FOUND.getReasonPhrase();
    }
}
