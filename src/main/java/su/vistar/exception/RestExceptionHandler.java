package su.vistar.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import su.vistar.logging.service.LogService;

import java.sql.SQLException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private LogService logger;

    public RestExceptionHandler(LogService logger) {
        this.logger = logger;
        logger.setClass(this.getClass());
    }

    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError apiError = new ApiError(status, "Method arguments not valid", ex);
        apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
        logger.error(apiError.toString());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ApiError> handleAllExceptions(Exception ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown exception", ex);
        logger.error(apiError.toString());
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<ApiError> conflict(DataIntegrityViolationException ex) {
        ApiError apiError = new ApiError(HttpStatus.CONFLICT, "Data integrity violation", ex);
        logger.error(apiError.toString());
        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({SQLException.class, DataAccessException.class})
    protected ResponseEntity<ApiError> databaseError() {
        ApiError apiError = new ApiError(HttpStatus.CONFLICT, "Data integrity violation", null);
        logger.error(apiError.toString());
        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<ApiError> noContent() {
        ApiError apiError = new ApiError(HttpStatus.NO_CONTENT, "No content", null);
        logger.error(apiError.toString());
        return new ResponseEntity<>(apiError, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(AuthenticationException.class)
    protected ResponseEntity<ApiError> authenticationException(AuthenticationException ex) {
        ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED, "Unauthorized", null);
        logger.error(apiError.toString());
        return new ResponseEntity<>(apiError, HttpStatus.UNAUTHORIZED);
    }
}
