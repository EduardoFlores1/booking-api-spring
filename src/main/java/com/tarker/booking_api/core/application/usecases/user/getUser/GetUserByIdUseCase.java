package com.tarker.booking_api.core.application.usecases.user.getUser;

import com.tarker.booking_api.core.application.mappers.UserMapper;
import com.tarker.booking_api.core.application.repositories.IUserRepository;
import com.tarker.booking_api.core.domain.entities.UserEntity;
import com.tarker.booking_api.core.dtos.ModelNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GetUserByIdUseCase implements IGetUserByIdUseCase {
    private static final Logger log = LoggerFactory.getLogger(GetUserByIdUseCase.class);
    private final IUserRepository userRepository;
    private final UserMapper userMapper;


    public GetUserByIdUseCase(IUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public GetUserByIdModel execute(Long userId) {
        try {
            UserEntity userFounded = userRepository.getUserById(userId).orElseThrow();
            return userMapper.entityToGetUser(userFounded);
        }   catch (NoSuchElementException ex) {
            log.error("Error al buscar, usuario con id: {} no encontrado", userId);
            throw new ModelNotFoundException("Error al buscar usuario, id: " + userId + " no encontrado");
        }
    }
}
