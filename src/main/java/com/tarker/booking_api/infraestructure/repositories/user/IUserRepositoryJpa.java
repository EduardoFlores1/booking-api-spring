package com.tarker.booking_api.infraestructure.repositories.user;

import com.tarker.booking_api.core.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepositoryJpa extends JpaRepository<UserEntity, Long> {
}
