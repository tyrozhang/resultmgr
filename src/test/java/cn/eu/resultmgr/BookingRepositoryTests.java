package cn.eu.resultmgr;

import cn.eu.resultmgr.contants.ScoreType;
import cn.eu.resultmgr.contants.StudyRequire;
import cn.eu.resultmgr.booking.domain.Booking;
import cn.eu.resultmgr.booking.domain.NormalExaminationBooking;
import cn.eu.resultmgr.model.CheckCourse;
import cn.eu.resultmgr.model.CheckTerm;
import cn.eu.resultmgr.booking.repository.BookingRepository;
import cn.eu.resultmgr.booking.repository.impl.BookingRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class BookingRepositoryTests {
    @Test
    @DisplayName("成绩登记表仓库--接口测试")
    void SaveBookingToRepositoryTest(){
        CheckCourse checkCourse=new CheckCourse("A12345","0809675", StudyRequire.MUST_STUDY);
        CheckTerm checkTerm=new CheckTerm("2019-2020-1");
        Booking booking =new NormalExaminationBooking(checkCourse,checkTerm, ScoreType.HUNDRED_MARK_SYSTEM);

        BookingRepository<Booking> bookingRepository=new BookingRepositoryImpl();
        bookingRepository.Save(booking);

        Assertions.assertNotNull(bookingRepository.getBooking(booking.getEntityID()));
    }
}
