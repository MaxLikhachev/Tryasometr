package su.vistar.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import su.vistar.logging.service.LogService;

import java.sql.SQLException;
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    private LogService logger;

    public CustomExceptionHandler(LogService logger) {
        this.logger = logger;
    }

    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError apiError = new ApiError(status, "Method arguments not valid", ex);
        apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
        logger.error(apiError.toString(),this.getClass().toString());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity handleAllExceptions(Exception ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Internal exception", ex);
        logger.error(apiError.toString(),this.getClass().toString());
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity conflict(DataIntegrityViolationException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.CONFLICT, "Data integrity violation", ex);
        
        logger.error(apiError.toString(),this.getClass().toString());
        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(SQLException.class)
    protected ResponseEntity databaseError(SQLException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.CONFLICT, "Database error", ex);
        
        logger.error(apiError.toString(),this.getClass().toString());
        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DataAccessException.class)
    protected ResponseEntity dataAccessError(DataAccessException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.CONFLICT, "Data access error", ex);
        //
        logger.error(apiError.toString(),this.getClass().toString());
        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity noContent(NullPointerException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.NO_CONTENT, "No content", ex);
        //
        logger.error(apiError.toString(),this.getClass().toString());
        return new ResponseEntity<>(apiError, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(AuthenticationException.class)
    protected ResponseEntity authenticationException(AuthenticationException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED, "Unauthorized", ex);
        //
        logger.error(apiError.toString(),this.getClass().toString());
        return new ResponseEntity<>(apiError, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(BadCredentialsException.class)
    protected ResponseEntity authenticationException(BadCredentialsException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Invalid credentials", ex);
        
        logger.error(apiError.toString(),this.getClass().toString());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DisabledException.class)
    protected ResponseEntity authenticationException(DisabledException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.FORBIDDEN, "User disabled", ex);
        
        logger.error(apiError.toString(),this.getClass().toString());
        return new ResponseEntity<>(apiError, HttpStatus.FORBIDDEN);
    }
}
