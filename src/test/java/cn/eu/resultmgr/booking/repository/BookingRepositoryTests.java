package cn.eu.resultmgr.booking.repository;

import cn.eu.resultmgr.booking.checkPlan.CheckPlanItem;
import cn.eu.resultmgr.service.RecordResultService;
import cn.eu.resultmgr.checkResult.CheckSubItemResult;
import cn.eu.resultmgr.booking.checkPlan.checkSubItem.CheckSubItemFactory;
import cn.eu.resultmgr.contants.ScoreType;
import cn.eu.resultmgr.booking.domain.Booking;
import cn.eu.resultmgr.booking.domain.NormalExaminationBooking;
import cn.eu.resultmgr.model.Score;
import cn.eu.resultmgr.util;
import org.junit.jupiter.api.Assertions;
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
    @DisplayName("成绩登记表仓库--接口测试")
    void SaveBookingToRepositoryTest(){
        NormalExaminationBooking p_Booking = util.createNormalExaminationBooking(ScoreType.HUNDRED_MARK_SYSTEM);

        p_Booking.addStudent(util.getStudent());

        p_Booking.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.USUAL,0.3F));
        p_Booking.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.EXAM,0.7F));
        bookingRepository.save(p_Booking);

        Booking bookingfromDB=bookingRepository.getBooking(p_Booking.getEntityID());

        Assertions.assertTrue(bookingfromDB.hasCheckSubItem(CheckSubItemFactory.EXAM));
        Assertions.assertTrue(bookingfromDB.hasCheckSubItem(CheckSubItemFactory.EXAM));
        Assertions.assertFalse(bookingfromDB.hasCheckSubItem(CheckSubItemFactory.MakeUpExam));
    }
}
