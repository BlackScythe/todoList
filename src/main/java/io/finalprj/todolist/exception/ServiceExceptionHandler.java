package io.finalprj.todolist.EXCEPTION;

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

    private final static  Logger log = Logger.getLogger(TodoService.class);
    private final static String CODE = "code";
    private final static String MESSAGE = "message";
    private final static String EXCEPTION = "exception";

    @ExceptionHandler(value = EmptyResultDataAccessException.class)
    protected ResponseEntity<Object> emptyResultDataAccessException(RuntimeException ex, WebRequest request) {
        log.error("No item found!");
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put(MESSAGE, "No item found!");
        responseBody.put(CODE, "404");
        responseBody.put(EXCEPTION, ex.getMessage());
        return handleExceptionInternal(ex, responseBody,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    protected ResponseEntity<Object> dataIntegrityViolationException(RuntimeException ex, WebRequest request) {
        log.error("1 or more values are missing or the incorrect type.");
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put(MESSAGE, "1 or more values are missing or are the incorrect type.");
        responseBody.put(CODE, "406");
        responseBody.put(EXCEPTION, ex.getMessage());
        return handleExceptionInternal(ex, responseBody,
                new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, request);
    }

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> EXCEPTION(RuntimeException ex, WebRequest request) {
        log.error("1 or more values are missing or the incorrect type.");
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put(MESSAGE, "Not sure what went wrong here.");
        responseBody.put(CODE, "499");
        responseBody.put(EXCEPTION, ex.getMessage());
        return handleExceptionInternal(ex, responseBody,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
