package cn.eu.resultmgr.booking.domain;

import cn.eu.common.bean.BeanCopyUtil;
import cn.eu.resultmgr.booking.domain.examBehavior.ExamBehaviorRecord;
import cn.eu.resultmgr.booking.persistence.po.BookingPO;
import cn.eu.resultmgr.contants.ScoreType;
import cn.eu.resultmgr.contants.StudyRequire;
import cn.eu.resultmgr.model.CheckCourse;
import cn.eu.resultmgr.model.CheckTerm;
import cn.eu.resultmgr.model.Score;
import cn.eu.resultmgr.booking.domain.checkPlan.CheckPlan;
import cn.eu.resultmgr.booking.domain.checkPlan.CheckPlanItem;
import cn.eu.resultmgr.booking.domain.checkResult.CheckSubItemResult;
import cn.eu.resultmgr.booking.domain.checkSubItem.CheckSubItem;
import cn.eu.resultmgr.booking.domain.checkSubItem.CheckSubItemFactory;
import cn.eu.resultmgr.model.Student;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Set;

public class NormalExaminationBooking extends Booking {
    @Override
    public Set<CheckPlanItem> getCheckPlanItems() {
        return BeanCopyUtil.clone(this.checkPlan.getCheckPlanItem());
    }

    //考核计划
    private CheckPlan checkPlan=new CheckPlan();

    public NormalExaminationBooking(CheckCourse checkCourse, CheckTerm checkTerm, ScoreType scoreType) {
        super(checkCourse, checkTerm, scoreType);
    }

    @Override
    public boolean checkSubItemIsValid(CheckSubItem checkSubItem) {
        return this.checkPlan.include(checkSubItem);
    }

    @Override
    public boolean checkItemScoreIsValid(CheckSubItemResult checkSubItemResult) {
        return this.getScoreType()==checkSubItemResult.getScore().getScoreType()?true:false;
    }

    @Override
    public void changeResultTypeFllow(ScoreType scoreType) {
        this.checkPlan.clear();
        //如果改为非百分值，只允许录入考试成绩
        if(scoreType != ScoreType.HUNDRED_MARK_SYSTEM)
            this.checkPlan.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.EXAM));

        //所有已登记成绩
        super.checkSubItemResultStorehouse.clearCheckSubItemResult();
    }

    @Override
    public Score countFinalResultNext(String studentID) {
        Set<CheckSubItemResult> checkSubItemResults=getCheckSubItemResult(studentID);

        if(checkSubItemResults==null || checkSubItemResults.isEmpty())
            return Score.emptyScore();

        //二分制直接返回考试成绩
        if(this.getScoreType()==ScoreType.TWO_POINTS_SYSTEM) {
            return this.getCheckSubItemResult(studentID, CheckSubItemFactory.EXAM).getScore();
        }

        ////百分制返回加权算总分
        Float finalScoreValue=0F;
        for (CheckSubItemResult item:checkSubItemResults) {
            Float subItemWeight=this.checkPlan.getCheckPlanItem(item.getCheckItem()).getWeight();
            finalScoreValue =finalScoreValue + item.getScore().getValue()*subItemWeight;
        }
        return new Score(finalScoreValue);
    }

    //添加考核计划项
    public void addCheckPlanItem(CheckPlanItem checkPlanItem){
        this.checkPlan.addCheckPlanItem(checkPlanItem);
    }
    /**
     * 登记免考
     */
    public void markAvoidExam(String studentID){
        this.examBehaviorRecord.markAvoidExam(studentID);
    }

    @Override
    public  BookingPO genatatePO(){
        BookingPO bookingPO=new BookingPO();
        bookingPO.setBookingID(this.getEntityID());
        bookingPO.setType("0");
        bookingPO.setCourseID(this.getCheckCourse().getCourseID());
        bookingPO.setCourseNO(this.getCheckCourse().getCourseNO());
        bookingPO.setCourseName(this.getCheckCourse().getCourseName());
        bookingPO.setStudyRequire(this.getCheckCourse().getStudyRequire().toString());
        bookingPO.setTermName(this.getCheckTerm().getTermName());
        bookingPO.setScoreType(this.getScoreType().toString());
        bookingPO.setStudents(JSON.toJSONString(this.getStudents()));
        bookingPO.setCheckPlanItems(JSON.toJSONString(this.getCheckPlanItems()));

        bookingPO.setSubItemResults(JSON.toJSONString(this.getCheckSubItemResult(), SerializerFeature.DisableCircularReferenceDetect));
        bookingPO.setExamBehaviorRecord(this.examBehaviorRecord.toJsonString());
        return bookingPO;
    }

    public static NormalExaminationBooking genarateDO(BookingPO bookingPO){
        NormalExaminationBooking nebing=new NormalExaminationBooking(
                new CheckCourse(bookingPO.getCourseID(),bookingPO.getCourseNO(),bookingPO.getCourseName(), StudyRequire.fromString(bookingPO.getStudyRequire())),
                new CheckTerm(bookingPO.getTermName()),
                ScoreType.fromString(bookingPO.getScoreType())
        );

        nebing.bookingID = bookingPO.getBookingID();

        nebing.studentRoll.addStudents(JSON.parseArray(bookingPO.getStudents(), Student.class));

 /*       //无法使用fastjson对象时，手工解决
        List<CheckSubItemResult> kk= JSON.parseArray(bookingPO.getSubItemResults(),CheckSubItemResult.class);
        JSONArray jsonObjects=JSON.parseArray(bookingPO.getSubItemResults());
        Iterator iterator=jsonObjects.iterator();
        while (iterator.hasNext()){
            JSONObject  jsonObject=(JSONObject)iterator.next();
            CheckSubItemResult checkSubItemResult=new CheckSubItemResult(
                    jsonObject.get("studentID").toString(),
                    JSON.parseObject(jsonObject.getJSONObject("checkItem").toJSONString(),CheckSubItem.class),
                    JSON.parseObject(jsonObject.getJSONObject("score").toJSONString(),Score.class));
        }*/

        nebing.checkSubItemResultStorehouse.recordResult(JSON.parseArray(bookingPO.getSubItemResults(),CheckSubItemResult.class));

        nebing.checkPlan.addCheckPlanItem(JSON.parseArray(bookingPO.getCheckPlanItems(),CheckPlanItem.class));

        nebing.examBehaviorRecord = ExamBehaviorRecord.genatateFromJsonStr(bookingPO.getExamBehaviorRecord());

        return nebing;
    }
}