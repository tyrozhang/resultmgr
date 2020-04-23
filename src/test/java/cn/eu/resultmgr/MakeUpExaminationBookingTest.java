package cn.eu.resultmgr;

import cn.eu.resultmgr.contants.ScoreType;
import cn.eu.resultmgr.contants.TwoPointSystemResult;
import cn.eu.resultmgr.model.Score;
import cn.eu.resultmgr.booking.domain.MakeUpExaminationBooking;
import cn.eu.resultmgr.booking.domain.checkResult.CheckSubItemResult;
import cn.eu.resultmgr.booking.domain.checkSubItem.CheckSubItemFactory;
import cn.eu.resultmgr.booking.domain.exception.CheckPlanNotIncludeTheCheckItemException;
import cn.eu.resultmgr.booking.domain.exception.ScoreTypeInvalidException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MakeUpExaminationBookingTest {
    @Test
    @DisplayName("登记非补考成绩分项时时抛出异常")
    void throwCheckPlanNotIncludeTheCheckItemExceptionTest(){
        MakeUpExaminationBooking p_Booking = util.initMakeUpExaminationBooking(ScoreType.HUNDRED_MARK_SYSTEM);
        p_Booking.addStudent(util.getStudent());
        Score score = new Score(78F);

        Assertions.assertThrows(CheckPlanNotIncludeTheCheckItemException.class,()->{
            //1：执行此语句会抛出一个ArithmeticException异常，被assertThrows方法捕获
            p_Booking.recordResult(new CheckSubItemResult("s_id_123",CheckSubItemFactory.USUAL,new Score(80F)));
        });
    }



    @Test
    @DisplayName("登记成绩时分数类型不符时抛出异常")
    void throwScoreTypeIsInvalidExceptionTest(){
        MakeUpExaminationBooking p_Booking = util.initMakeUpExaminationBooking(ScoreType.HUNDRED_MARK_SYSTEM);

        p_Booking.addStudent(util.getStudent());

        Assertions.assertThrows(ScoreTypeInvalidException.class,()->{
            //1：执行此语句会抛出一个ArithmeticException异常，被assertThrows方法捕获
            p_Booking.recordResult(new CheckSubItemResult("s_id_123",CheckSubItemFactory.MakeUpExam,new Score(TwoPointSystemResult.PASS)));
        });
    }

    @Test
    @DisplayName("计算两分制补考总成绩")
    void recordTwoPointsSystemResultTest(){
        MakeUpExaminationBooking p_Booking = util.initMakeUpExaminationBooking(ScoreType.TWO_POINTS_SYSTEM);

        p_Booking.addStudent(util.getStudent());

        //计算补考及格总成绩
        p_Booking.addStudent(util.getStudent("s_id_123","一班"));
        p_Booking.recordResult(new CheckSubItemResult("s_id_123",CheckSubItemFactory.MakeUpExam,new Score(TwoPointSystemResult.PASS)));
        Assertions.assertEquals(TwoPointSystemResult.MARKUP_PASS.getValue(),p_Booking.CountFinalResult("s_id_123").getValue());

        //计算补考不及格总成绩
        p_Booking.addStudent(util.getStudent("s_id_456","一班"));
        p_Booking.recordResult(new CheckSubItemResult("s_id_456",CheckSubItemFactory.MakeUpExam,new Score(TwoPointSystemResult.NOTPASS)));
        Assertions.assertEquals(TwoPointSystemResult.MARKUP_NOTPASS.getValue(),p_Booking.CountFinalResult("s_id_456").getValue());
    }



    @Test
    @DisplayName("计算百分制补考总成绩")
    void countFinalResultForHunredSystemTest(){
        MakeUpExaminationBooking p_Booking = util.initMakeUpExaminationBooking(ScoreType.HUNDRED_MARK_SYSTEM);

        //计算补考及格总成绩
        p_Booking.addStudent(util.getStudent("s_id_123","一班"));
        p_Booking.recordResult(new CheckSubItemResult("s_id_123",CheckSubItemFactory.MakeUpExam,new Score(70F)));
        Assertions.assertEquals(60F,p_Booking.CountFinalResult("s_id_123").getValue());

        //计算补考不及格总成绩
        p_Booking.addStudent(util.getStudent("s_id_456","一班"));
        p_Booking.recordResult(new CheckSubItemResult("s_id_456",CheckSubItemFactory.MakeUpExam,new Score(50.5F)));
        Assertions.assertEquals(50.5F,p_Booking.CountFinalResult("s_id_456").getValue());
    }

    @Test
    @DisplayName("两分制补考作弊及此时总分计算")
    void twoPointSystemMarkCheatedTest(){
        MakeUpExaminationBooking p_Booking = util.initMakeUpExaminationBooking(ScoreType.TWO_POINTS_SYSTEM);

        p_Booking.addStudent(util.getStudent());
        p_Booking.markCheated("s_id_123");

        Assertions.assertEquals(TwoPointSystemResult.NOTPASS.getValue(),p_Booking.CountFinalResult("s_id_123").getValue());
    }

    @Test
    @DisplayName("百分制补考作弊及此时总分计算")
    void hundredSystemMarkCheatedTest(){
        MakeUpExaminationBooking p_Booking = util.initMakeUpExaminationBooking(ScoreType.HUNDRED_MARK_SYSTEM);

        p_Booking.addStudent(util.getStudent());
        p_Booking.markCheated("s_id_123");

        Assertions.assertEquals(0F,p_Booking.CountFinalResult("s_id_123").getValue());
    }
}
