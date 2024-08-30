package com.tarker.booking_api.core.application.mappers;

import com.tarker.booking_api.core.application.usecases.customer.createCustomer.CreateCustomerModel;
import com.tarker.booking_api.core.application.usecases.customer.getAllCustomers.GetAllCustomerModel;
import com.tarker.booking_api.core.application.usecases.customer.getCustomer.GetCustomerByIdModel;
import com.tarker.booking_api.core.domain.entities.AddressEntity;
import com.tarker.booking_api.core.domain.entities.BookingEntity;
import com.tarker.booking_api.core.domain.entities.CustomerEntity;
import com.tarker.booking_api.core.domain.models.AddressModel;
import com.tarker.booking_api.core.domain.models.BookingModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    AddressModel toAddressModel(AddressEntity addressEntity);
    BookingModel toBookingModel(BookingEntity bookingEntity);

    GetAllCustomerModel toGetAllCustomerModel(CustomerEntity customerEntity);
    GetCustomerByIdModel toGetCustomerByIdModel(CustomerEntity customerEntity);
    CustomerEntity fromCreateToEntity(CreateCustomerModel createCustomerModel);
}
