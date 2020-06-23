package cn.eu.resultmgr.booking;

import cn.eu.resultmgr.model.checkPlan.UsualScoreAndExamScoreWithWeighing;
import cn.eu.resultmgr.booking.domain.Booking;
import cn.eu.resultmgr.booking.domain.NormalExaminationBooking;
import cn.eu.resultmgr.service.RecordResultService;
import cn.eu.resultmgr.booking.persistence.po.BookingPO;
import cn.eu.resultmgr.contants.ScoreType;
import cn.eu.resultmgr.util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BoPoConvertTest {
    @Resource
    RecordResultService recordResultService;

    @Test
    @DisplayName("从PO产生domain对象测试")
    void createDoaminFromPOTest(){
        NormalExaminationBooking p_Booking = util.createNormalExaminationBooking(ScoreType.HUNDRED_MARK_SYSTEM);
        p_Booking.addStudent(util.getStudent());

        Booking generate_booking = getBooking(p_Booking);
        Assertions.assertTrue(generate_booking.getStudents().size()>1);
    }

    private Booking getBooking(NormalExaminationBooking p_Booking) {
        BookingPO bookingPO = p_Booking.genatatePO();
        return NormalExaminationBooking.build(bookingPO);
    }

    @Test
    @DisplayName("PO DO 互转性能测试")
    void Po2DoPerformanceTest(){
        List<NormalExaminationBooking> bookings=new ArrayList<>();
        for(int i=0;i<1000;i++) {
            NormalExaminationBooking p_Booking = util.createNormalExaminationBooking(ScoreType.HUNDRED_MARK_SYSTEM);
            p_Booking.addStudent(util.getStudent());

   /*         for (Student stu:p_Booking.getStudents()) {
                p_Booking.recordResult(new CheckSubItemResult(stu.getStudentID(), CheckSubItemFactory.USUAL,new Score(90F)));
                p_Booking.recordResult(new CheckSubItemResult(stu.getStudentID(), CheckSubItemFactory.EXAM,new Score(80F)));
            }*/


            bookings.add(p_Booking);
        }

        long startTime=System.currentTimeMillis();
        System.out.println("转换po。。。。。。。。。。。。。");

        List<BookingPO> bookingpos=new ArrayList<>();
        for (NormalExaminationBooking normalExaminationBooking:bookings) {
            bookingpos.add(normalExaminationBooking.genatatePO());
        }

        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime - startTime)+"ms");

        long startTime1=System.currentTimeMillis();
        System.out.println("转换do。。。。。。。。。。。。。");

        for (BookingPO item:bookingpos) {
            Booking normalExaminationBooking=NormalExaminationBooking.build(item);
        }

        long endTime1=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime1 - startTime1)+"ms");

        System.out.println(bookingpos.size());
        Assertions.assertNotNull(bookingpos);
    }
}

