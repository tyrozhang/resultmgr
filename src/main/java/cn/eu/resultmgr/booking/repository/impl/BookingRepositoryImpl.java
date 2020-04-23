package cn.eu.resultmgr.booking.repository.impl;

import cn.eu.resultmgr.booking.domain.Booking;
import cn.eu.resultmgr.booking.repository.BookingRepository;


import java.util.HashMap;
import java.util.Map;

public class BookingRepositoryImpl implements BookingRepository<Booking> {

    private Map<String,Booking> temp_repository=new HashMap<String,Booking>();

    @Override
    public void Save(Booking booking) {
        this.temp_repository.put(booking.getEntityID(),booking);
    }

    @Override
    public Booking getBooking(String bookingID) {
        return this.temp_repository.get(bookingID);
    }
}
