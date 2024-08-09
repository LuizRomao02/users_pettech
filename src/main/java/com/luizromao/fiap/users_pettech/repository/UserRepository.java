package com.luizromao.fiap.users_pettech.repository;

import com.luizromao.fiap.users_pettech.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
