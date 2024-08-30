package com.tarker.booking_api.core.application.usecases.customer.getCustomer;

import com.tarker.booking_api.core.domain.models.AddressModel;
import com.tarker.booking_api.core.domain.models.BookingModel;

import java.util.List;

public class GetCustomerByIdModel {
    private Long customerId;
    private String fullName;
    private String documentNumber;
    private AddressModel address;
    private List<BookingModel> bookings;

    public GetCustomerByIdModel() {}

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }

    public List<BookingModel> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingModel> bookings) {
        this.bookings = bookings;
    }
}
