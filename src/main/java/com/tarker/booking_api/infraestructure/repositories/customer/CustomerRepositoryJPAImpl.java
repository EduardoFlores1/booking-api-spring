package com.tarker.booking_api.infraestructure.repositories.customer;

import com.tarker.booking_api.core.application.repositories.CustomerRepository;
import com.tarker.booking_api.core.domain.entities.CustomerEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryJPAImpl implements CustomerRepository {
    private final CustomerRepositoryJPA _customerRepository;

    public CustomerRepositoryJPAImpl(CustomerRepositoryJPA customerRepository) {
        this._customerRepository = customerRepository;
    }

    public List<CustomerEntity> getAllCustomers() {
        return _customerRepository.findAll();
    }
    public Optional<CustomerEntity> getCustomerById(Long customerId) {
        return _customerRepository.findById(customerId);
    }
    public CustomerEntity saveCustomer(CustomerEntity customer) {
        return _customerRepository.save(customer);
    }
    public void deleteCustomerById(Long customerId) {
        _customerRepository.deleteById(customerId);
    }
}
