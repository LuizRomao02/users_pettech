package com.luizromao.fiap.users_pettech.dto;

import com.luizromao.fiap.users_pettech.service.validation.CreateUserValid;
import java.time.LocalDate;

@CreateUserValid(message = "Already registered user")
public record UserDTO(String name,  String email, String cpf, LocalDate birthDate) {}
