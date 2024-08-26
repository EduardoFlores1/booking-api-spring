package com.tarker.booking_api.infraestructure.repositories.booking;

import com.tarker.booking_api.core.domain.entities.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepositoryJPA extends JpaRepository<BookingEntity, Long> {
}
