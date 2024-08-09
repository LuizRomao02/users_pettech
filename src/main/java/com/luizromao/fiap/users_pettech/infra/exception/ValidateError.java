package com.luizromao.fiap.users_pettech.infra.exception;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class ValidateError extends StandardError {

  private List<ValidateMessage> messages = new ArrayList<>();

  public void addMessage(String label, String message) {
    this.messages.add(new ValidateMessage(label, message));
  }
}
