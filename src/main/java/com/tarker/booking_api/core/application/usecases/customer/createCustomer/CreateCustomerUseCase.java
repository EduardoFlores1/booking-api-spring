package com.tarker.booking_api.core.application.usecases.customer.createCustomer;

import com.tarker.booking_api.core.application.mappers.CustomerMapper;
import com.tarker.booking_api.core.application.repositories.ICustomerRepository;
import com.tarker.booking_api.core.exceptions.models.CreateModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateCustomerUseCase implements ICreateCustomerUseCase{

    private static final Logger log = LoggerFactory.getLogger(CreateCustomerUseCase.class);
    private final ICustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CreateCustomerUseCase(ICustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Transactional
    @Override
    public CreateCustomerModel execute(CreateCustomerModel createCustomerModel) {
        try {
            log.info("Creando customer: {}", createCustomerModel);
            customerRepository.saveCustomer(customerMapper.fromCreateToEntity(createCustomerModel));
            return createCustomerModel;

        } catch (DataIntegrityViolationException e) {
            log.error("Error al crear. Customer: {}, message: {}", createCustomerModel, e.getMessage());
            throw new CreateModelException("Error al crear un customer, " + e.getMessage());
        }
    }
}
