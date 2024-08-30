package com.tarker.booking_api.core.application.usecases.customer.updateCustomer;

public interface IUpdateCustomerUseCase {
    UpdateCustomerModel execute(Long customerId, UpdateCustomerModel updateCustomerModel);
}
