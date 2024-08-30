package com.tarker.booking_api.core.domain.models;
public class BookingModel {
    private Long bookingId;
    private String code;
    private String type;
    private String createdAt;

    public BookingModel() {}

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "BookingModel{" +
                "bookingId=" + bookingId +
                ", code='" + code + '\'' +
                ", type='" + type + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
