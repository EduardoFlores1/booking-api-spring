package com.tarker.booking_api.core.application.usecases.customer.createCustomer;

import com.tarker.booking_api.core.domain.models.AddressModel;

public class CreateCustomerModel {
    private String fullName;
    private String documentNumber;
    private AddressModel address;

    public CreateCustomerModel() {}

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

    @Override
    public String toString() {
        return "CreateCustomerModel{" +
                "fullName='" + fullName + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", address=" + address +
                '}';
    }
}
