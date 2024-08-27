package com.tarker.booking_api.core.application.usecases.user.deleteUser;

import com.tarker.booking_api.core.application.repositories.IUserRepository;
import com.tarker.booking_api.core.domain.entities.UserEntity;
import com.tarker.booking_api.core.dtos.DeleteModelException;
import com.tarker.booking_api.core.dtos.ModelNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class DeleteUserByIdUseCase implements IDeleteUserByIdUseCase{

    private static final Logger log = LoggerFactory.getLogger(DeleteUserByIdUseCase.class);
    private final IUserRepository userRepository;

    public DeleteUserByIdUseCase(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void execute(Long userId) {
        try {
            log.info("Eliminando usuario, id: {}", userId);
            UserEntity userEntity = userRepository.getUserById(userId).orElseThrow();
            userRepository.deleteUserById(userId);
        } catch (NoSuchElementException ex) {
            log.error("Error al eliminar, usuario con id: {} no encontrado", userId);
            throw new ModelNotFoundException("Error al eliminar, usuario con id: " + userId + " no encontrado");
        } catch (Exception ex) {
            log.error("Error al eliminar usuario, id: {}", userId);
            throw new DeleteModelException("Error al eliminar usuario, id: " + userId);
        }
    }
}
