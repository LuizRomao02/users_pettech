package com.luizromao.fiap.users_pettech.util;

import com.luizromao.fiap.users_pettech.dto.UserDTO;
import com.luizromao.fiap.users_pettech.entities.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConverterToDTO {

  private final ModelMapper modelMapper;

  public UserDTO toDto(final User model) {
    return modelMapper.map(model, UserDTO.class);
  }
}
