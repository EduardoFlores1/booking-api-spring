package com.tarker.booking_api.core.domain.models;

public class AddressModel {
    private Long addressId;
    private String street;
    private String province;
    private String region;

    public AddressModel() {}

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "AddressModel{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", province='" + province + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
