package com.tarker.booking_api.core.application.repositories;

import com.tarker.booking_api.core.domain.entities.BookingEntity;

import java.util.List;
import java.util.Optional;

public interface IBookingRepository {
    List<BookingEntity> getAllBookings();
    Optional<BookingEntity> getBookingById(Long id);
    BookingEntity saveBooking(BookingEntity booking);
    void deleteBookingById(Long bookingId);
}
