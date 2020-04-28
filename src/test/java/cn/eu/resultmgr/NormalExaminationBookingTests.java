package cn.eu.resultmgr;

import cn.eu.resultmgr.contants.ScoreType;
import cn.eu.resultmgr.contants.TwoPointSystemResult;
import cn.eu.resultmgr.booking.domain.Booking;
import cn.eu.resultmgr.booking.domain.checkPlan.CheckPlanItem;
import cn.eu.resultmgr.booking.domain.NormalExaminationBooking;
import cn.eu.resultmgr.booking.domain.checkResult.CheckSubItemResult;
import cn.eu.resultmgr.booking.domain.checkSubItem.CheckSubItemFactory;
import cn.eu.resultmgr.booking.domain.exception.CheckPlanNotIncludeTheCheckItemException;
import cn.eu.resultmgr.booking.domain.exception.ScoreTypeInvalidException;
import cn.eu.resultmgr.booking.domain.exception.WithoutTheStudentException;
import cn.eu.resultmgr.model.Score;
import cn.eu.resultmgr.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class NormalExaminationBookingTests {

    @Mock
    Student students;

    @Test
    @DisplayName("登记成绩时没有相应学员名单时抛出异常")
    void throwWithoutTheStudentExceptionTest(){
        Booking booking = util.initNormalExaminationBooking(ScoreType.HUNDRED_MARK_SYSTEM);
        Score score = new Score(78F);

        Throwable exception = Assertions.assertThrows(WithoutTheStudentException.class,()->{
            //1：执行此语句会抛出一个ArithmeticException异常，被assertThrows方法捕获
            booking.recordResult(new CheckSubItemResult("s_id_123",CheckSubItemFactory.USUAL,new Score(80F)));
        });
        Assertions.assertEquals(null,exception.getMessage());
        //Mockito 用法测试
        Mockito.when(students.getStudentID()).thenReturn("s_id_123");
        Assertions.assertEquals("s_id_123",students.getStudentID());
    }

    @Test
    @DisplayName("登记成绩时考核方案中没有要登记的分项时时抛出异常")
    void throwCheckPlanNotIncludeTheCheckItemExceptionTest(){
        NormalExaminationBooking p_Booking = util.initNormalExaminationBooking(ScoreType.HUNDRED_MARK_SYSTEM);
        p_Booking.addStudent(util.getStudent());
        Score score = new Score(78F);

        p_Booking.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.EXAM,0.3F));

        Assertions.assertThrows(CheckPlanNotIncludeTheCheckItemException.class,()->{
            //1：执行此语句会抛出一个ArithmeticException异常，被assertThrows方法捕获
            p_Booking.recordResult(new CheckSubItemResult("s_id_123",CheckSubItemFactory.USUAL,new Score(80F)));
        });
    }



    @Test
    @DisplayName("登记成绩时分数类型不符时抛出异常")
    void throwScoreTypeIsInvalidExceptionTest(){
        NormalExaminationBooking p_Booking = util.initNormalExaminationBooking(ScoreType.HUNDRED_MARK_SYSTEM);

        p_Booking.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.USUAL,0.3F));

        p_Booking.addStudent(util.getStudent());

        Assertions.assertThrows(ScoreTypeInvalidException.class,()->{
            //1：执行此语句会抛出一个ArithmeticException异常，被assertThrows方法捕获
            p_Booking.recordResult(new CheckSubItemResult("s_id_123",CheckSubItemFactory.USUAL,new Score(TwoPointSystemResult.PASS)));
        });
    }

    @Test
    @DisplayName("登记百分制成绩")
    void recordHundredMarkSystemResultTest(){
        NormalExaminationBooking p_Booking = util.initNormalExaminationBooking(ScoreType.HUNDRED_MARK_SYSTEM);

        p_Booking.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.USUAL,0.3F));

        p_Booking.addStudent(util.getStudent());

        p_Booking.recordResult(new CheckSubItemResult("s_id_123",CheckSubItemFactory.USUAL,new Score(80F)));

        Assertions.assertEquals(80F,p_Booking.getCheckSubItemResult("s_id_123",CheckSubItemFactory.USUAL).getScore().getValue());
    }

    @Test
    @DisplayName("登记两分制成绩")
    void recordTwoPointsSystemResultTest(){
        NormalExaminationBooking p_Booking = util.initNormalExaminationBooking(ScoreType.TWO_POINTS_SYSTEM);

        p_Booking.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.EXAM));

        p_Booking.addStudent(util.getStudent());

        p_Booking.recordResult(new CheckSubItemResult("s_id_123",CheckSubItemFactory.EXAM,new Score(TwoPointSystemResult.PASS)));

        Assertions.assertEquals(TwoPointSystemResult.PASS.getValue(),p_Booking.getCheckSubItemResult("s_id_123",CheckSubItemFactory.EXAM).getScore().getValue());
    }



    @Test
    @DisplayName("计算百分制总成绩")
    void countFinalResultForHunredSystemTest(){
        NormalExaminationBooking p_Booking = util.initNormalExaminationBooking(ScoreType.HUNDRED_MARK_SYSTEM);

        p_Booking.addStudent(util.getStudent());

        p_Booking.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.USUAL,0.3F));
        p_Booking.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.EXAM,0.7F));

        p_Booking.recordResult(new CheckSubItemResult("s_id_123",CheckSubItemFactory.USUAL,new Score(70F)));
        p_Booking.recordResult(new CheckSubItemResult("s_id_123",CheckSubItemFactory.EXAM,new Score(80F)));

        //计算总成绩
        Score finalScore = p_Booking.countFinalResultNext("s_id_123");
        Assertions.assertEquals(77F,finalScore.getValue());
    }

    @Test
    @DisplayName("两分制考试作弊及此时总分计算")
    void twoPointSystemMarkCheatedTest(){
        NormalExaminationBooking p_Booking = util.initNormalExaminationBooking(ScoreType.TWO_POINTS_SYSTEM);

        p_Booking.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.EXAM));

        p_Booking.addStudent(util.getStudent());
        p_Booking.markCheated("s_id_123");

        Assertions.assertEquals(TwoPointSystemResult.NOTPASS.getValue(),p_Booking.countFinalResult("s_id_123").getValue());
    }

    @Test
    @DisplayName("百分制考试作弊及此时总分计算")
    void hundredSystemMarkCheatedTest(){
        NormalExaminationBooking p_Booking = util.initNormalExaminationBooking(ScoreType.HUNDRED_MARK_SYSTEM);

        p_Booking.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.EXAM));

        p_Booking.addStudent(util.getStudent());
        p_Booking.markCheated("s_id_123");

        Assertions.assertEquals(0F,p_Booking.countFinalResult("s_id_123").getValue());
    }

    @Test
    @DisplayName("没有成绩时计算总评成绩")
    void whenNothingResultCountFinalScoreTest(){
        NormalExaminationBooking p_Booking = util.initNormalExaminationBooking(ScoreType.TWO_POINTS_SYSTEM);

        p_Booking.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.EXAM));

        p_Booking.addStudent(util.getStudent());

        //计算总成绩
        Score finalScore = p_Booking.countFinalResultNext("s_id_123");
        Assertions.assertEquals(Score.emptyScore().getValue(),finalScore.getValue());
    }
}
