package cn.eu.framwork.domain;

import cn.eu.resultmgr.booking.domain.Booking;
import cn.eu.resultmgr.booking.persistence.po.BookingPO;

public interface  IDomain<T> {
    //获取领域对象ID
    String getEntityID();

    public <T> T genatatePO();
}
