package cn.eu.resultmgr.booking.repository;

import cn.eu.framwork.repository.IRepository;
import cn.eu.resultmgr.booking.domain.Booking;

public interface BookingRepository extends IRepository<Booking>{
    public Booking getBooking(String bookingID);
}
