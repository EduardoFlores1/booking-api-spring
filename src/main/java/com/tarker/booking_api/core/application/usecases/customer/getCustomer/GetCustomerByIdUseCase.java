package com.tarker.booking_api.core.application.usecases.customer.getCustomer;

import com.tarker.booking_api.core.application.mappers.CustomerMapper;
import com.tarker.booking_api.core.application.repositories.ICustomerRepository;
import com.tarker.booking_api.core.domain.entities.CustomerEntity;
import com.tarker.booking_api.core.exceptions.models.ModelNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class GetCustomerByIdUseCase implements IGetCustomerByIdUseCase{

    private static final Logger log = LoggerFactory.getLogger(GetCustomerByIdUseCase.class);
    private final ICustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public GetCustomerByIdUseCase(ICustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public GetCustomerByIdModel execute(Long customerId) {
        try {
            CustomerEntity customerFounded = customerRepository.getCustomerById(customerId).orElseThrow();
            return customerMapper.toGetCustomerByIdModel(customerFounded);
        } catch (NoSuchElementException ex) {
            log.error("Error al buscar, customer con id: {} no encontrado", customerId);
            throw new ModelNotFoundException("Error al buscar customer, id: " + customerId + " no encontrado");
        }
    }
}
