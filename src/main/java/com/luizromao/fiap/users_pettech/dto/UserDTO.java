package com.luizromao.fiap.users_pettech.dto;

import java.time.LocalDate;

public record UserDTO(String name, String email, String cpf, LocalDate birthDate) {}
