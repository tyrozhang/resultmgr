package cn.eu.resultmgr.persistence;

import cn.eu.resultmgr.booking.domain.Booking;
import cn.eu.resultmgr.booking.domain.NormalExaminationBooking;
import cn.eu.resultmgr.booking.persistence.dao.BookingDao;
import cn.eu.resultmgr.booking.persistence.po.BookingPO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class persistenceTest {
    @Resource
    private BookingDao bookingDao;
    @Test
    @DisplayName("持久化领域对象测试")
    void persistenceBookingTest(){
        long startTime1=System.currentTimeMillis();
        System.out.println("转换do。。。。。。。。。。。。");
        List<BookingPO> bookingbos=bookingDao.selectList(null);

        List<Booking> bos=new ArrayList<>();

        for (BookingPO bp:bookingbos) {
            bos.add(NormalExaminationBooking.genarateDO(bp));
        }
        long endTime1=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime1 - startTime1)+"ms");

        Assertions.assertNotNull(bookingbos);
        Assertions.assertNotNull(bos);
    }
}
