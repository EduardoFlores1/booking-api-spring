package com.tarker.booking_api.core.application.usecases.customer.deleteCustomer;

import com.tarker.booking_api.core.application.repositories.ICustomerRepository;
import com.tarker.booking_api.core.exceptions.models.DeleteModelException;
import com.tarker.booking_api.core.exceptions.models.ModelNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class DeleteCustomerByIdUseCase implements IDeleteCustomerByIdUseCase{
    private static final Logger log = LoggerFactory.getLogger(DeleteCustomerByIdUseCase.class);
    private final ICustomerRepository customerRepository;

    public DeleteCustomerByIdUseCase(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    @Override
    public void execute(Long customerId) {
        try {
            log.info("Eliminando customer, id: {}", customerId);
            customerRepository.getCustomerById(customerId).orElseThrow();
            customerRepository.deleteCustomerById(customerId);

        } catch (NoSuchElementException e) {
            log.error("Error al eliminar, customer con con id: {} no encontrado", customerId);
            throw new ModelNotFoundException("Error al elimiar, customer con id: " + customerId + " no encontrado");

        } catch (Exception e) {
            log.error("Error al eliminar customer, id: {}", customerId);
            throw new DeleteModelException("Error al eliminar customer, id: " + customerId + " no encontrado");
        }
    }
}
