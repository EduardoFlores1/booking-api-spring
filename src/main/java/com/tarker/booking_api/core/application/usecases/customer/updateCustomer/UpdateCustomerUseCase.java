package com.tarker.booking_api.core.application.usecases.customer.updateCustomer;

import com.tarker.booking_api.core.application.mappers.AddressMapper;
import com.tarker.booking_api.core.application.repositories.ICustomerRepository;
import com.tarker.booking_api.core.domain.entities.CustomerEntity;
import com.tarker.booking_api.core.exceptions.models.ModelNotFoundException;
import com.tarker.booking_api.core.exceptions.models.UpdateModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class UpdateCustomerUseCase implements IUpdateCustomerUseCase{
    private static final Logger log = LoggerFactory.getLogger(UpdateCustomerUseCase.class);
    private final ICustomerRepository customerRepository;
    private final AddressMapper addressMapper;

    public UpdateCustomerUseCase(ICustomerRepository customerRepository, AddressMapper addressMapper) {
        this.customerRepository = customerRepository;
        this.addressMapper = addressMapper;
    }

    @Transactional
    @Override
    public UpdateCustomerModel execute(Long customerId, UpdateCustomerModel updateCustomerModel) {
        try {
            log.info("Actualizando customer. id: {}, customer: {}", customerId, updateCustomerModel);
            CustomerEntity customerEntity = customerRepository.getCustomerById(customerId).orElseThrow();

            customerEntity.setFullName(updateCustomerModel.getFullName());
            customerEntity.setDocumentNumber(updateCustomerModel.getDocumentNumber());
            customerEntity.setAddress(addressMapper.toEntity(updateCustomerModel.getAddress()));
            customerRepository.saveCustomer(customerEntity);
            return updateCustomerModel;

        } catch (NoSuchElementException e) {
            log.error("Error al actualizar, customer con id: {} no encontrado", customerId, e);
            throw new ModelNotFoundException("Error al actualizar, customer con id: " + customerId + " no encontrado");

        } catch (DataIntegrityViolationException e) {
            log.error("Error al actualizar customer. id: {}, customer: {}, message: {}", customerId, updateCustomerModel, e.getMessage());
            throw new UpdateModelException("Error al actualizar customer, " + e.getMessage());
        }
    }
}
