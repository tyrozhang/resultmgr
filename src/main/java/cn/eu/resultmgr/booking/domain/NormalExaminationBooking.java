package cn.eu.resultmgr.booking.domain;

import cn.eu.common.bean.BeanCopyUtil;
import cn.eu.resultmgr.booking.domain.examBehavior.ExamBehaviorRecord;
import cn.eu.resultmgr.booking.persistence.po.BookingPO;
import cn.eu.resultmgr.checkCourse.CheckCourseID;
import cn.eu.resultmgr.contants.ScoreType;
import cn.eu.resultmgr.model.CheckTerm;
import cn.eu.resultmgr.model.Score;
import cn.eu.resultmgr.booking.checkPlan.CheckPlanItem;
import cn.eu.resultmgr.checkResult.CheckSubItemResult;
import cn.eu.resultmgr.booking.checkPlan.checkSubItem.CheckSubItem;
import cn.eu.resultmgr.booking.checkPlan.checkSubItem.CheckSubItemFactory;
import cn.eu.resultmgr.model.Student;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashSet;
import java.util.Set;

public class NormalExaminationBooking extends Booking {
    @Override
    public Set<CheckPlanItem> getCheckPlanItems() {
        return BeanCopyUtil.clone(this.checkPlan);
    }

    //考核计划
    private Set<CheckPlanItem> checkPlan=new HashSet<CheckPlanItem>();

    public NormalExaminationBooking(CheckCourseID checkCourseID, CheckTerm checkTerm, ScoreType scoreType) {
        super(checkCourseID, checkTerm, scoreType);
    }

    @Override
    public boolean hasCheckSubItem(CheckSubItem checkSubItem) {
        CheckPlanItem checkPlanItem = getCheckSubItemFromCheckPlanItem(checkSubItem);
        return checkPlanItem==null?false:true;
    }

    @Override
    public boolean checkItemScoreIsValid(ScoreType scoreType) {
        return this.getScoreType()==scoreType?true:false;
    }




    private CheckPlanItem getCheckSubItemFromCheckPlanItem(CheckSubItem item) {
        return this.checkPlan.stream().filter(
                    checkItem->checkItem.getCheckSubItem().equals(item)).findAny().orElse(null);
    }

    //添加考核计划项
    public void addCheckPlanItem(CheckPlanItem checkPlanItem){
        this.checkPlan.add(checkPlanItem);
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
        bookingPO.setCourseID(this.getCheckCourseID().getID());
        bookingPO.setTermName(this.getCheckTerm().getTermName());
        bookingPO.setScoreType(this.getScoreType().toString());
        bookingPO.setStudents(JSON.toJSONString(this.getStudents()));
        bookingPO.setCheckPlanItems(JSON.toJSONString(this.getCheckPlanItems()));

        bookingPO.setExamBehaviorRecord(this.examBehaviorRecord.toJsonString());
        return bookingPO;
    }

    public static NormalExaminationBooking build(BookingPO bookingPO){
        NormalExaminationBooking nebing=new NormalExaminationBooking(
                new CheckCourseID(bookingPO.getCourseID()),
                new CheckTerm(bookingPO.getTermName()),
                ScoreType.fromString(bookingPO.getScoreType())
        );

        nebing.bookingID = bookingPO.getBookingID();

        nebing.studentRoll.addAll(JSON.parseArray(bookingPO.getStudents(), Student.class));

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

        nebing.checkPlan.addAll(JSON.parseArray(bookingPO.getCheckPlanItems(),CheckPlanItem.class));

        nebing.examBehaviorRecord = ExamBehaviorRecord.genatateFromJsonStr(bookingPO.getExamBehaviorRecord());

        return nebing;
    }
}