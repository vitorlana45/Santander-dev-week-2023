package me.dio.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;


@RestControllerAdvice
public class GlobalExceptionHandler {

  private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBusinessException (IllegalArgumentException businessExceptionMsg) {
        return new ResponseEntity<>(businessExceptionMsg.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY); // retornando 422 ao invés de 500
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFoundException (NoSuchElementException notFoundException) {
        return new ResponseEntity<>("Resource ID not found.", HttpStatus.NOT_FOUND); // retornando 404
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedException (Throwable unexpectedException) {
        var message = "Unexpected Server Error, see the logs.";
        logger.error("", unexpectedException);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR); // retornando 404
    }
}
