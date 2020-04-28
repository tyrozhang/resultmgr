package cn.eu.resultmgr.repository;

import cn.eu.resultmgr.booking.domain.Booking;
import cn.eu.resultmgr.booking.domain.NormalExaminationBooking;
import cn.eu.resultmgr.booking.domain.checkPlan.CheckPlanItem;
import cn.eu.resultmgr.booking.domain.checkResult.CheckSubItemResult;
import cn.eu.resultmgr.booking.domain.checkSubItem.CheckSubItemFactory;
import cn.eu.resultmgr.booking.persistence.po.BookingPO;
import cn.eu.resultmgr.contants.ScoreType;
import cn.eu.resultmgr.contants.TwoPointSystemResult;
import cn.eu.resultmgr.model.Score;
import cn.eu.resultmgr.model.Student;
import cn.eu.resultmgr.util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BoPoConvertTest {
    @Test
    @DisplayName("从PO产生domain对象测试")
    void createDoaminFromPOTest(){
        NormalExaminationBooking p_Booking = util.initNormalExaminationBooking(ScoreType.HUNDRED_MARK_SYSTEM);
        p_Booking.addStudent(util.getStudent());

        p_Booking.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.USUAL,0.3F));
        p_Booking.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.EXAM,0.7F));

        p_Booking.recordResult(new CheckSubItemResult("s_id_123",CheckSubItemFactory.USUAL,new Score(70F)));
        p_Booking.recordResult(new CheckSubItemResult("s_id_123",CheckSubItemFactory.EXAM,new Score(80F)));


        Booking get_from_repository_booking = getBooking(p_Booking);

        //计算总成绩
        Score finalScore = get_from_repository_booking.countFinalResultNext("s_id_123");
        Assertions.assertEquals(77F,finalScore.getValue());
    }
    @Test
    @DisplayName("登记两分制成绩")
    void recordTwoPointsSystemResultTest(){
        NormalExaminationBooking p_Booking = util.initNormalExaminationBooking(ScoreType.TWO_POINTS_SYSTEM);

        p_Booking.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.EXAM));

        p_Booking.addStudent(util.getStudent());
        p_Booking.recordResult(new CheckSubItemResult("s_id_123", CheckSubItemFactory.EXAM,new Score(TwoPointSystemResult.PASS)));

        Booking get_from_repository_booking = getBooking(p_Booking);

        //计算总成绩
        Score finalScore = get_from_repository_booking.countFinalResultNext("s_id_123");
        Assertions.assertEquals(TwoPointSystemResult.PASS.getValue(),finalScore.getValue());
    }



    @Test
    @DisplayName("从po获得domian对象后改变考核分项分制测试")
    void changeScoreTypeTest(){
        NormalExaminationBooking p_Booking = util.initNormalExaminationBooking(ScoreType.HUNDRED_MARK_SYSTEM);
        p_Booking.addStudent(util.getStudent());


        p_Booking.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.USUAL,0.3F));
        p_Booking.recordResult(new CheckSubItemResult("s_id_123", CheckSubItemFactory.USUAL,new Score(80F)));

        Booking get_from_repository_booking = getBooking(p_Booking);

        Assertions.assertEquals(80F,get_from_repository_booking.getCheckSubItemResult("s_id_123",CheckSubItemFactory.USUAL).getScore().getValue());

        //修改后清除成绩
        get_from_repository_booking.changeScoreType(ScoreType.TWO_POINTS_SYSTEM);
        Assertions.assertEquals(0,get_from_repository_booking.getCheckSubItemResult("s_id_123").size());

        //继续录成绩
        get_from_repository_booking.recordResult(new CheckSubItemResult("s_id_123", CheckSubItemFactory.EXAM,new Score(TwoPointSystemResult.PASS)));
        Assertions.assertEquals(-1F,get_from_repository_booking.getCheckSubItemResult("s_id_123",CheckSubItemFactory.EXAM).getScore().getValue());
    }

    @Test
    @DisplayName("反序列化后--两分制考试作弊及此时总分计算")
    void twoPointSystemMarkCheatedTest(){
        NormalExaminationBooking p_Booking = util.initNormalExaminationBooking(ScoreType.TWO_POINTS_SYSTEM);

        p_Booking.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.EXAM));

        p_Booking.addStudent(util.getStudent());
        p_Booking.markCheated("s_id_123");

        Booking get_from_repository_booking = getBooking(p_Booking);

        Assertions.assertEquals(TwoPointSystemResult.NOTPASS.getValue(),get_from_repository_booking.countFinalResult("s_id_123").getValue());
    }

    private Booking getBooking(NormalExaminationBooking p_Booking) {
        BookingPO bookingPO = p_Booking.genatatePO();
        p_Booking = null;
        return NormalExaminationBooking.genarateDO(bookingPO);
    }

    @Test
    @DisplayName("反序列化后--百分制考试作弊及此时总分计算")
    void hundredSystemMarkCheatedTest(){
        NormalExaminationBooking p_Booking = util.initNormalExaminationBooking(ScoreType.HUNDRED_MARK_SYSTEM);

        p_Booking.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.USUAL,0.3F));
        p_Booking.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.EXAM,0.7F));
        p_Booking.addStudent(util.getStudent());

        p_Booking.recordResult(new CheckSubItemResult("s_id_123", CheckSubItemFactory.USUAL,new Score(90F)));
        p_Booking.recordResult(new CheckSubItemResult("s_id_123", CheckSubItemFactory.EXAM,new Score(80F)));


        p_Booking.markCheated("s_id_123");

        Booking get_from_repository_booking = getBooking(p_Booking);

        Assertions.assertEquals(0F,get_from_repository_booking.countFinalResult("s_id_123").getValue());
    }

    @Test
    @DisplayName("PO DO 互转性能测试")
    void Po2DoPerformanceTest(){
        List<NormalExaminationBooking> bookings=new ArrayList<>();
        for(int i=0;i<1000;i++) {
            NormalExaminationBooking p_Booking = util.initNormalExaminationBooking(ScoreType.HUNDRED_MARK_SYSTEM);
            p_Booking.addStudent(util.getStudent());

            p_Booking.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.USUAL,0.3F));
            p_Booking.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.EXAM,0.7F));

            for (Student stu:p_Booking.getStudents()) {
                p_Booking.recordResult(new CheckSubItemResult(stu.getStudentID(), CheckSubItemFactory.USUAL,new Score(90F)));
                p_Booking.recordResult(new CheckSubItemResult(stu.getStudentID(), CheckSubItemFactory.EXAM,new Score(80F)));
            }


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
            Booking normalExaminationBooking=NormalExaminationBooking.genarateDO(item);
        }

        long endTime1=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime1 - startTime1)+"ms");

        System.out.println(bookingpos.size());
        Assertions.assertNotNull(bookingpos);
    }
}

