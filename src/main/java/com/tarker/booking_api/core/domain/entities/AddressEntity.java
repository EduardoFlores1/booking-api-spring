package com.tarker.booking_api.core.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "street", length = 50, nullable = false)
    private String street;

    @Column(name = "province", length = 50, nullable = false)
    private String province;

    @Column(name = "region", length = 50, nullable = false)
    private String region;

    @OneToOne(mappedBy = "address")
    private CustomerEntity customer;

    // constructor

    public AddressEntity() {}

    //getters and setters

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

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    // toString

    @Override
    public String toString() {
        return "AddressEntity{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", province='" + province + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
