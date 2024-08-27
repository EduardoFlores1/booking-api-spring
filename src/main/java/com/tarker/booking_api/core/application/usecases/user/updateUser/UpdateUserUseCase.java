package com.tarker.booking_api.core.application.usecases.user.updateUser;

import com.tarker.booking_api.core.application.repositories.IUserRepository;
import com.tarker.booking_api.core.domain.entities.UserEntity;
import com.tarker.booking_api.core.dtos.ModelNotFoundException;
import com.tarker.booking_api.core.dtos.UpdateModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class UpdateUserUseCase implements IUpdateUserUseCase{
    private static final Logger log = LoggerFactory.getLogger(UpdateUserUseCase.class);
    private final IUserRepository userRepository;

    public UpdateUserUseCase(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UpdateUserModel execute(Long userId, UpdateUserModel updateUserModel) {
        try {
            log.info("Actualizando usuario. id: {}, usuario: {}", userId, updateUserModel);
            UserEntity userEntity = userRepository.getUserById(userId).orElseThrow();

            userEntity.setFirstName(updateUserModel.getFirstName());
            userEntity.setLastName(updateUserModel.getLastName());
            userEntity.setPassword(updateUserModel.getPassword());
            userRepository.saveUser(userEntity);
            return updateUserModel;

        } catch (NoSuchElementException ex) {
            log.error("Error al actualizar, usuario con id: {} no encontrado", userId);
            throw new ModelNotFoundException("Error al actualizar, usuario con id: " + userId + " no encontrado");
        } catch (DataIntegrityViolationException ex) {
            log.error("Error al actualizar usuario. id: {}, user: {}, message: {}", userId, updateUserModel, ex.getMessage());
            throw new UpdateModelException("Error al actualizar usuario, " + ex.getMessage());
        }
    }
}
