package com.tarker.booking_api.infraestructure.repositories.booking;

import com.tarker.booking_api.core.application.repositories.BookingRepository;
import com.tarker.booking_api.core.domain.entities.BookingEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookingRepositoryJPAImpl implements BookingRepository {
    private final BookingRepositoryJPA _bookingRepository;

    public BookingRepositoryJPAImpl(BookingRepositoryJPA bookingRepository) {
        this._bookingRepository = bookingRepository;
    }

    public List<BookingEntity> getAllBookings() {
        return _bookingRepository.findAll();
    }
    public Optional<BookingEntity> getBookingById(Long bookingId) {
        return _bookingRepository.findById(bookingId);
    }
    public BookingEntity saveBooking(BookingEntity booking) {
        return _bookingRepository.save(booking);
    }
    public void deleteBookingById(Long bookingId) {
        _bookingRepository.deleteById(bookingId);
    }
}
