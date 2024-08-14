package com.luizromao.fiap.users_pettech.service.validation;

import com.luizromao.fiap.users_pettech.dto.UserDTO;
import com.luizromao.fiap.users_pettech.entities.User;
import com.luizromao.fiap.users_pettech.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CreateUserValidator implements ConstraintValidator<CreateUserValid, UserDTO> {

  @Autowired private UserRepository userRepository;

  @Override
  public void initialize(CreateUserValid constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(UserDTO userDTO, ConstraintValidatorContext constraintValidatorContext) {
      Optional<User> user = userRepository.findByEmail(userDTO.email());
      return user.isEmpty();
  }
}
