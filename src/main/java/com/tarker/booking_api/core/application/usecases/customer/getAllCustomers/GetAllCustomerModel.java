package com.tarker.booking_api.core.application.usecases.customer.getAllCustomers;

import com.tarker.booking_api.core.domain.models.AddressModel;

public class GetAllCustomerModel {
    private Long customerId;
    private String fullName;
    private String documentNumber;
    private AddressModel address;

    public GetAllCustomerModel() {}

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
}
