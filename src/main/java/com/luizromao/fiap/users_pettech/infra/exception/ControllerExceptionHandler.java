package com.luizromao.fiap.users_pettech.infra.exception;

import jakarta.servlet.http.HttpServletRequest;
import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ControllerExceptionHandler {

  private final StandardError error = new StandardError();

  @ExceptionHandler(ControllerNotFoundException.class)
  public ResponseEntity<StandardError> entityNotFoundException(
      ControllerNotFoundException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.NOT_FOUND;
    error.setTimeStamp(Instant.now());
    error.setStatus(status.value());
    error.setError("Entity not found");
    error.setMessage(e.getMessage());
    error.setPath(request.getRequestURI());

    return ResponseEntity.status(status).body(this.error);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<StandardError> validationException(
      MethodArgumentNotValidException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    ValidateError validateError = new ValidateError();

    validateError.setTimeStamp(Instant.now());
    validateError.setStatus(status.value());
    validateError.setError("Error validation");
    validateError.setMessage(e.getMessage());
    validateError.setPath(request.getRequestURI());

    for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
      validateError.addMessage(fieldError.getField(), fieldError.getDefaultMessage());
    }

    return ResponseEntity.status(status).body(validateError);
  }
}
