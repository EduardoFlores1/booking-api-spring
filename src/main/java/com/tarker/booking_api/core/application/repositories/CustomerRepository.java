package com.tarker.booking_api.core.application.repositories;

import com.tarker.booking_api.core.domain.entities.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    List<CustomerEntity> getAllCustomers();
    Optional<CustomerEntity> getCustomerById(Long id);
    CustomerEntity saveCustomer(CustomerEntity customer);
    void deleteCustomerById(Long id);
}
