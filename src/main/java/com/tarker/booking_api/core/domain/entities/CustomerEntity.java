package com.tarker.booking_api.core.domain.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customers")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "full_name", length = 100, nullable = false)
    private String fullName;

    @Column(name = "document_number", length = 8, unique = true, nullable = false)
    private String documentNumber;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
    private AddressEntity address;

    @OneToMany(mappedBy = "customer")
    private List<BookingEntity> bookings;

    // constructores

    public CustomerEntity() {}

    public CustomerEntity(String fullName, String documentNumber, AddressEntity address) {
        this.fullName = fullName;
        this.documentNumber = documentNumber;
        this.address = address;
    }

    // getters and setters

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

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public List<BookingEntity> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingEntity> bookings) {
        this.bookings = bookings;
    }

    // toString

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "customerId=" + customerId +
                ", fullName='" + fullName + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                '}';
    }
}
