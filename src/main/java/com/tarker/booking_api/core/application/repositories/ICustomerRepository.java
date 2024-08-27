package com.tarker.booking_api.core.application.repositories;

import com.tarker.booking_api.core.domain.entities.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {
    List<CustomerEntity> getAllCustomers();
    Optional<CustomerEntity> getCustomerById(Long customerId);
    CustomerEntity saveCustomer(CustomerEntity customer);
    void deleteCustomerById(Long customerId);
}
