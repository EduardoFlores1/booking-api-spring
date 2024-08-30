package com.tarker.booking_api.infraestructure.repositories.customer;

import com.tarker.booking_api.core.application.repositories.ICustomerRepository;
import com.tarker.booking_api.core.domain.entities.CustomerEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryJpa implements ICustomerRepository {
    private final ICustomerRepositoryJpa customerRepositoryJpa;

    public CustomerRepositoryJpa(ICustomerRepositoryJpa customerRepositoryJpa) {
        this.customerRepositoryJpa = customerRepositoryJpa;
    }

    @Override
    public List<CustomerEntity> getAllCustomers() {
        return customerRepositoryJpa.findAll();
    }

    @Override
    public Optional<CustomerEntity> getCustomerById(Long customerId) {
        return customerRepositoryJpa.findById(customerId);
    }

    @Override
    public CustomerEntity saveCustomer(CustomerEntity customer) {
        return customerRepositoryJpa.save(customer);
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        customerRepositoryJpa.deleteById(customerId);
    }
}
