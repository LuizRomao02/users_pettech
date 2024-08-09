package com.luizromao.fiap.users_pettech.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record UserForm(
    @NotBlank(message = "The name cannot be blank") String name,
    @Email(message = "email invalid") String email,
    @CPF(message = "cpf invalid") String cpf) {}
