package cn.eu.resultmgr;

import cn.eu.resultmgr.service.RecordResultService;
import cn.eu.resultmgr.checkCourse.CheckCourseID;
import cn.eu.resultmgr.contants.ScoreType;
import cn.eu.resultmgr.contants.TwoPointSystemResult;
import cn.eu.resultmgr.booking.checkPlan.CheckPlanItem;
import cn.eu.resultmgr.booking.domain.NormalExaminationBooking;
import cn.eu.resultmgr.checkResult.CheckSubItemResult;
import cn.eu.resultmgr.booking.checkPlan.checkSubItem.CheckSubItemFactory;
import cn.eu.resultmgr.model.CheckTerm;
import cn.eu.resultmgr.model.Score;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class ChangeBookingTest {
    @Resource
    RecordResultService recordResultService;


/*    @Test
    @DisplayName("改变考核分项权重")
    void changeCheckSubItemWeightTest(){
        CheckCourse checkCourse = new CheckCourse("c_id_123","C_NO_123", StudyRequire.MUST_STUDY, ScoreType.HUNDRED_MARK_SYSTEM,"t_id_123;t_id_234");
        CheckTerm checkTerm = new CheckTerm("2019-2020-1");
        PositiveExaminationBooking p_Booking = new PositiveExaminationBooking(checkCourse,checkTerm);

        p_Booking.addStudent(new Student("s_id_123","s_no_123","张三"));

        CheckPlanItem checkPlanItem = new CheckPlanItem(new UsualCheckSubItem(),0.3F);
        p_Booking.addCheckPlanItem(checkPlanItem);
        Score score = new Score(80F);
        p_Booking.recordResult("s_id_123",new UsualCheckSubItem(),score);

        //修改不同分制，清除相关分项分数，改变分制
        p_Booking.changeCheckPlanItemWeight(new UsualCheckSubItem(),0.5F);
        Assertions.assertEquals(null,p_Booking.getCheckSubItemResult("s_id_123",new UsualCheckSubItem()));
    }*/
    private NormalExaminationBooking initBooking(ScoreType scoreType) {
        CheckTerm checkTerm = new CheckTerm("2019-2020-1");
        return new NormalExaminationBooking(new CheckCourseID("c_id_123"),checkTerm, scoreType);
    }
}
