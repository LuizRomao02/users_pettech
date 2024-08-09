package com.luizromao.fiap.users_pettech.infra.exception;

public class ControllerNotFoundException extends RuntimeException {

  public ControllerNotFoundException(final String message) {
    super(message);
  }
}
