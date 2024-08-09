package com.luizromao.fiap.users_pettech.infra.exception;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {

  private Instant timeStamp;
  private Integer status;
  private String error;
  private String message;
  private String path;
}
