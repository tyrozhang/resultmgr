package cn.eu.resultmgr.booking.repository.impl;

import cn.eu.resultmgr.booking.domain.Booking;
import cn.eu.resultmgr.booking.domain.NormalExaminationBooking;
import cn.eu.resultmgr.booking.persistence.dao.BookingDao;
import cn.eu.resultmgr.booking.persistence.po.BookingPO;
import cn.eu.resultmgr.booking.repository.BookingRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class BookingRepositoryImp implements BookingRepository {
    @Resource
    private BookingDao bookingDao;

    @Override
    public Booking getBooking(String bookingID) {
        BookingPO po=bookingDao.selectById(bookingID);
        if (po==null)
            return null;
        if (po.getType().equals("0"))
            return NormalExaminationBooking.build(po);

        return null;
    }

    @Override
    public void save(Booking booking) {
        String bookingID=booking.getEntityID();
        if(bookingDao.getBookingID(bookingID)>0) {
            bookingDao.updateById(booking.genatatePO());
            return;
        }
        bookingDao.insert(booking.genatatePO());

    }
}
