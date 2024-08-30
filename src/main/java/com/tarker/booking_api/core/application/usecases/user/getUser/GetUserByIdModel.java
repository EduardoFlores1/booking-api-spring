package com.tarker.booking_api.core.application.usecases.user.getUser;

import com.tarker.booking_api.core.domain.models.BookingModel;

import java.util.List;

public class GetUserByIdModel {
    private Long userId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private List<BookingModel> bookings;

    public GetUserByIdModel() {}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<BookingModel> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingModel> bookings) {
        this.bookings = bookings;
    }
}
