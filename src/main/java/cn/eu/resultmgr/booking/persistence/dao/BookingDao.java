package cn.eu.resultmgr.booking.persistence.dao;

import cn.eu.resultmgr.booking.persistence.po.BookingPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

public interface BookingDao extends BaseMapper<BookingPO> {
    @Select("select count(bookingid) from  booking where  bookingid = #{bookingID}")
    int getBookingID(String bookingID);
}
