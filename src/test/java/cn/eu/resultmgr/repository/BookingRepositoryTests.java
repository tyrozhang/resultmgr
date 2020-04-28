package cn.eu.resultmgr.repository;

import cn.eu.resultmgr.booking.domain.checkPlan.CheckPlanItem;
import cn.eu.resultmgr.booking.domain.checkResult.CheckSubItemResult;
import cn.eu.resultmgr.booking.domain.checkSubItem.CheckSubItemFactory;
import cn.eu.resultmgr.contants.ScoreType;
import cn.eu.resultmgr.booking.domain.Booking;
import cn.eu.resultmgr.booking.domain.NormalExaminationBooking;
import cn.eu.resultmgr.booking.repository.BookingRepository;
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

    @Test
    @DisplayName("成绩登记表仓库--接口测试")
    void SaveBookingToRepositoryTest(){
        NormalExaminationBooking p_Booking = util.initNormalExaminationBooking(ScoreType.HUNDRED_MARK_SYSTEM);

        p_Booking.addStudent(util.getStudent());

        p_Booking.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.USUAL,0.3F));
        p_Booking.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.EXAM,0.7F));

        p_Booking.recordResult(new CheckSubItemResult("s_id_123",CheckSubItemFactory.USUAL,new Score(70F)));
        p_Booking.recordResult(new CheckSubItemResult("s_id_123",CheckSubItemFactory.EXAM,new Score(80F)));

        bookingRepository.save(p_Booking);
        Booking bookingfromDB=bookingRepository.getBooking(p_Booking.getEntityID());

        Assertions.assertEquals(77F,bookingfromDB.countFinalResult("s_id_123").getValue());
    }
}
