package com.tarker.booking_api.infraestructure.repositories.user;

import com.tarker.booking_api.core.application.repositories.IUserRepository;
import com.tarker.booking_api.core.domain.entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryJpa implements IUserRepository {

    private final IUserRepositoryJpa _userRepositoryJpa;

    public UserRepositoryJpa(IUserRepositoryJpa userRepositoryJpa) {
        _userRepositoryJpa = userRepositoryJpa;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return _userRepositoryJpa.findAll();
    }

    @Override
    public Optional<UserEntity> getUserById(Long userId) {
        return _userRepositoryJpa.findById(userId);
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        return _userRepositoryJpa.save(user);
    }

    @Override
    public void deleteUserById(Long userId) {
        _userRepositoryJpa.deleteById(userId);
    }
}
