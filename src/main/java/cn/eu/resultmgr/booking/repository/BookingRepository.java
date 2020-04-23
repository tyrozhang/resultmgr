package cn.eu.resultmgr.booking.repository;

import cn.eu.framwork.repository.IRepository;

public interface BookingRepository<Booking> extends IRepository<Booking> {
    public void Save(Booking booking);
    public Booking getBooking(String bookingID);
}
