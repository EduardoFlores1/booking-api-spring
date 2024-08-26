package com.tarker.booking_api.infraestructure.repositories.user;

import com.tarker.booking_api.core.application.repositories.UserRepository;
import com.tarker.booking_api.core.domain.entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryJPAImpl implements UserRepository {
    private final UserRepositoryJPA _userRepository;

    public UserRepositoryJPAImpl(UserRepositoryJPA userRepository) {
        this._userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers() {
        return _userRepository.findAll();
    }
    public Optional<UserEntity> getUserById(Long userId) {
        return _userRepository.findById(userId);
    }
    public UserEntity saveUser(UserEntity user) {
        return _userRepository.save(user);
    }
    public void deleteUserById(Long userId) {
        _userRepository.deleteById(userId);
    }
}
