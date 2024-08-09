package com.luizromao.fiap.users_pettech.service;

import com.luizromao.fiap.users_pettech.dto.UserDTO;
import com.luizromao.fiap.users_pettech.dto.UserForm;
import com.luizromao.fiap.users_pettech.entities.User;
import com.luizromao.fiap.users_pettech.infra.exception.ControllerNotFoundException;
import com.luizromao.fiap.users_pettech.repository.UserRepository;
import com.luizromao.fiap.users_pettech.util.ConverterToDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

  private final UserRepository userRepository;
  private final ConverterToDTO converterToDTO;

  private User save(User user) {
    return userRepository.save(user);
  }

  @Transactional(readOnly = true)
  public Page<UserDTO> findAll(Pageable pageable) {
    return userRepository.findAll(pageable).map(converterToDTO::toDto);
  }

  @Transactional(readOnly = true)
  public UserDTO findById(Long id) {
    return userRepository
        .findById(id)
        .map(converterToDTO::toDto)
        .orElseThrow(() -> new ControllerNotFoundException("User not found"));
  }

  public UserDTO create(UserDTO userDTO) {
    User user =
        User.builder()
            .name(userDTO.name())
            .cpf(userDTO.cpf())
            .email(userDTO.email())
            .birthDate(userDTO.birthDate())
            .build();

    return converterToDTO.toDto(save(user));
  }

  public UserDTO update(Long id, UserForm userDTO) {
    User user =
        userRepository
            .findById(id)
            .orElseThrow(() -> new ControllerNotFoundException("User not found"));

    user.setName(userDTO.name());
    user.setCpf(userDTO.cpf());
    user.setEmail(userDTO.email());

    return converterToDTO.toDto(save(user));
  }

  public void delete(Long id) {
    userRepository.deleteById(id);
  }
}
