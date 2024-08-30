package com.tarker.booking_api.core.application.usecases.customer.getCustomer;

public interface IGetCustomerByIdUseCase {
    GetCustomerByIdModel execute(Long customerId);
}
