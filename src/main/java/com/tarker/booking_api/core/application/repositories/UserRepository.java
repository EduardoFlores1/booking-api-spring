package com.tarker.booking_api.core.application.repositories;

import com.tarker.booking_api.core.domain.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<UserEntity> getAllUsers();
    Optional<UserEntity> getUserById(Long id);
    UserEntity saveUser(UserEntity user);
    void deleteUserById(Long id);
}
