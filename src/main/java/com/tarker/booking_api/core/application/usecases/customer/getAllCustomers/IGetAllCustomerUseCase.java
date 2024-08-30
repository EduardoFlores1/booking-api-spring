package com.tarker.booking_api.core.application.usecases.customer.getAllCustomers;

import java.util.List;

public interface IGetAllCustomerUseCase {
    List<GetAllCustomerModel> execute();
}
