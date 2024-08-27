package com.tarker.booking_api.core.application.usecases.user.createUser;

import com.tarker.booking_api.core.application.mappers.UserMapper;
import com.tarker.booking_api.core.application.repositories.IUserRepository;
import com.tarker.booking_api.core.dtos.CreateModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateUserUseCase implements ICreateUserUseCase{

    private static final Logger log = LoggerFactory.getLogger(CreateUserUseCase.class);
    private final IUserRepository userRepository;
    private final UserMapper userMapper;

    public CreateUserUseCase(IUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    @Override
    public CreateUserModel execute(CreateUserModel createUserModel) {
        try {
            log.info("Creando usuario: {}", createUserModel);
            userRepository.saveUser(userMapper.createUserToEntity(createUserModel));
            return createUserModel;

        }catch (DataIntegrityViolationException ex) {
            log.error("Error al crear. Usuario: {}, message: {}", createUserModel, ex.getMessage());
            throw new CreateModelException("Error al crear un usuario, " + ex.getMessage());
        }
    }
}