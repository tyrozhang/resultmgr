package cn.eu.resultmgr.booking.repository;

import cn.eu.resultmgr.model.checkPlan.UsualScoreAndExamScoreWithWeighing;
import cn.eu.resultmgr.service.RecordResultService;
import cn.eu.resultmgr.model.checkSubItem.CheckItemFactory;
import cn.eu.resultmgr.contants.ScoreType;
import cn.eu.resultmgr.booking.domain.Booking;
import cn.eu.resultmgr.booking.domain.NormalExaminationBooking;
import cn.eu.resultmgr.util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
public class BookingRepositoryTests {
    @Resource
    BookingRepository bookingRepository;
    @Resource
    RecordResultService recordResultService;


    @Test
    @Disabled
    @DisplayName("成绩登记表仓库--接口测试")
    void SaveBookingToRepositoryTest(){
        NormalExaminationBooking p_Booking = util.createNormalExaminationBooking(ScoreType.HUNDRED_MARK_SYSTEM);

        p_Booking.addStudent(util.getStudent());
        bookingRepository.save(p_Booking);

        Booking bookingfromDB=bookingRepository.getBooking(p_Booking.getEntityID());

        Assertions.assertTrue(bookingfromDB.getStudents().size()>0);
    }
}
