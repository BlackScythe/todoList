package io.finalprj.todolist.exception;

import io.finalprj.todolist.service.TodoService;
import org.apache.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = Logger.getLogger(TodoService.class);
    private static String code = "code";
    private static String message = "message";
    private static String exception = "exception";

    @ExceptionHandler(value = EmptyResultDataAccessException.class)
    protected ResponseEntity<Object> emptyResultDataAccessException(RuntimeException ex, WebRequest request) {
        log.error("No item found!");
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put(message, "No item found!");
        responseBody.put(code, "404");
        responseBody.put(exception, ex.getMessage());
        return handleExceptionInternal(ex, responseBody,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    protected ResponseEntity<Object> dataIntegrityViolationException(RuntimeException ex, WebRequest request) {
        log.error("1 or more values are missing or the incorrect type.");
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put(message, "1 or more values are missing or are the incorrect type.");
        responseBody.put(code, "406");
        responseBody.put(exception, ex.getMessage());
        return handleExceptionInternal(ex, responseBody,
                new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, request);
    }

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> exception(RuntimeException ex, WebRequest request) {
        log.error("1 or more values are missing or the incorrect type.");
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put(message, "Not sure what went wrong here.");
        responseBody.put(code, "499");
        responseBody.put(exception, ex.getMessage());
        return handleExceptionInternal(ex, responseBody,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
