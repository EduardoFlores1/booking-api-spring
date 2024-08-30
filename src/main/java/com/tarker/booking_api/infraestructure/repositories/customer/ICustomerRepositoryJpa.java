package com.tarker.booking_api.infraestructure.repositories.customer;

import com.tarker.booking_api.core.domain.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepositoryJpa extends JpaRepository<CustomerEntity, Long> {
}
