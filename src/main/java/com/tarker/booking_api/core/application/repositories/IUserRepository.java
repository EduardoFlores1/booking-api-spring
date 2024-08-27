package com.tarker.booking_api.core.application.repositories;

import com.tarker.booking_api.core.domain.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<UserEntity> getAllUsers();
    Optional<UserEntity> getUserById(Long userId);
    UserEntity saveUser(UserEntity user);
    void deleteUserById(Long userId);
}
