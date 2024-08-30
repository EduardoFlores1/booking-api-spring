package com.tarker.booking_api.core.application.usecases.customer.getAllCustomers;

import com.tarker.booking_api.core.application.mappers.CustomerMapper;
import com.tarker.booking_api.core.application.repositories.ICustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GetAllCustomerUseCase implements IGetAllCustomerUseCase{

    private final ICustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public GetAllCustomerUseCase(ICustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<GetAllCustomerModel> execute() {
        return customerRepository.getAllCustomers()
                .stream()
                .map(customerMapper::toGetAllCustomerModel)
                .toList();
    }
}
