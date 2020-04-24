package cn.eu.resultmgr.booking.domain;

import cn.eu.framwork.domain.IDomain;
import cn.eu.common.bean.BeanCopyUtil;
import cn.eu.resultmgr.contants.ScoreType;
import cn.eu.resultmgr.contants.TwoPointSystemResult;
import cn.eu.resultmgr.booking.domain.checkPlan.CheckPlanItem;
import cn.eu.resultmgr.booking.domain.checkResult.CheckSubItemResult;
import cn.eu.resultmgr.booking.domain.checkResult.CheckSubItemResultStorehouse;
import cn.eu.resultmgr.booking.domain.checkSubItem.CheckSubItem;
import cn.eu.resultmgr.booking.domain.exception.CheckPlanNotIncludeTheCheckItemException;
import cn.eu.resultmgr.booking.domain.exception.ScoreTypeInvalidException;
import cn.eu.resultmgr.booking.domain.exception.WithoutTheStudentException;
import cn.eu.resultmgr.model.CheckCourse;
import cn.eu.resultmgr.model.CheckTerm;
import cn.eu.resultmgr.model.Score;
import cn.eu.resultmgr.model.Student;


import java.util.*;

public abstract class Booking implements IDomain {


    //登记册ID
    private String bookingID=String.valueOf(new Date().getTime());
    //考核课程
    protected CheckCourse checkCourse;
    //分制类型
    protected ScoreType scoreType;
    //考核学期
    protected CheckTerm checkTerm;
    //学生名单
    protected StudentList studentList = new StudentList();
    //考核成绩库
    protected CheckSubItemResultStorehouse checkSubItemResultStorehouse;
    //考核行为登记
    protected ExamBehaviorRecord examBehaviorRecord=new ExamBehaviorRecord();

    public Booking(CheckCourse checkCourse, CheckTerm checkTerm, ScoreType scoreType) {
        super();
        this.checkCourse = checkCourse;
        this.checkTerm = checkTerm;
        this.scoreType = scoreType;
    }

    //获取考核学生名单
    public List<Student> getStudentsList(){
        return BeanCopyUtil.clone(this.studentList.getStudents());
    }

    /**
     * 获取指定学员某分项成绩
     * @return CheckSubItemResult
     */
    public CheckSubItemResult getCheckSubItemResult(String studentID, CheckSubItem checkSubItem){
        CheckSubItemResult checkSubItemResult = this.checkSubItemResultStorehouse.getCheckSubItemResult(studentID,checkSubItem);
        if(checkSubItemResult==null)
            return null;
        return checkSubItemResult.copy();
    }

    /**
     * 获取指定学员全部分项成绩
     * @return CheckSubItemResult
     */
    public Set<CheckSubItemResult> getCheckSubItemResult(String studentID){
        return BeanCopyUtil.clone(this.checkSubItemResultStorehouse.getCheckSubItemResult(studentID));
    }

    //更正分制
    public void changeScoreType(ScoreType scoreType){
        if (this.scoreType==scoreType)
            return;

        this.scoreType=scoreType;
        changeResultTypeFllow(scoreType);
    }

    //更正分制后续处理
    public abstract  void changeResultTypeFllow(ScoreType scoreType);

    public abstract Set<CheckPlanItem> getCheckPlanItems();

    ///检查分项是否在考核方案中
    public abstract boolean checkSubItemIsValid(CheckSubItem checkSubItem);

    //检查登记的分数是否符合成绩分项分制
    public abstract boolean checkItemScoreIsValid(CheckSubItemResult checkSubItemResult);

    //计算指定学员最终成绩
    public abstract Score CountFinalResultNext(String studentID);

    //后期需修改为返回克隆对象
    public CheckCourse getCheckCourse() {
        return this.checkCourse.copy();
    }

    public CheckTerm getCheckTerm() {
        return checkTerm.copy();
    }

    public ScoreType getScoreType() {
        return BeanCopyUtil.clone(scoreType);
    }

    @Override
    public String getEntityID() {
        return BeanCopyUtil.clone(bookingID);
    }

    //登记成绩
    public  void recordResult(CheckSubItemResult checkSubItemResult){
        //检查要登记成绩的学生是否在考核学员名单中
        if (!isHasStudent(checkSubItemResult.getStudentID())) {
            throw new WithoutTheStudentException();
        }

        //检查登记的成绩分项是否在考核方案中
        if (!checkSubItemIsValid(checkSubItemResult.getCheckItem())) {
            throw new CheckPlanNotIncludeTheCheckItemException();
        }

        //检查登记的分数是否符合成绩分项分制
        if (!checkItemScoreIsValid(checkSubItemResult)) {
            throw new ScoreTypeInvalidException();
        }


        if (this.checkSubItemResultStorehouse ==null)
            this.checkSubItemResultStorehouse =new CheckSubItemResultStorehouse();

        //登记成绩
        this.checkSubItemResultStorehouse.recordResult(checkSubItemResult);
    }

    /**
     * 增加学生
     */
    public void addStudent(Student student){
        this.studentList.addStudent(student);
    }

    /**
     * 批量增加学生
     * @param students
     */
    public void addStudents(List<Student> students){
        for (Student student:students) {
            this.studentList.addStudent(student);
        }
    }

    //判断某学生是否在学生名单中
    public Boolean isHasStudent(String studentID){
        return this.studentList.getStudent(studentID)==null?false:true;
    }

    /**
     * 删除某分项所有成绩
     */
    public void clearCheckSubItemResult(CheckSubItem checkSubItem){
        this.checkSubItemResultStorehouse.clearCheckSubItemResult(checkSubItem);
    }

    /**
     * 登记作弊
     */
    public void markCheated(String studentID){
        this.examBehaviorRecord.makeCheatedMark(studentID);
    }

    /**
     * 登记缺考
     */
    public void markAbsentExam(String studentID){
        this.examBehaviorRecord.markAbsentExam(studentID);
    }
    /**
     * 登记缓考
     */
    public void markDelayExam(String studentID){
        this.examBehaviorRecord.makeDelayExamMark(studentID);
    }

    /**
     * 计算总评成绩
     * @param studentID
     * @return 分数，包含两种类型分数：百分值，二分制 详见 @see Score
     */
    public  Score CountFinalResult(String studentID){
        //检查要计算总评成绩的学生是否在考核学员名单中
        if (!isHasStudent(studentID)) {
            throw new WithoutTheStudentException();
        }

        //作弊成绩认定
        if(this.examBehaviorRecord.isCheatedOrAbsent(studentID)){
            return  (this.getScoreType()==ScoreType.HUNDRED_MARK_SYSTEM)?new Score(0F):new Score(TwoPointSystemResult.NOTPASS);
        }

        //如何没有登记过任何分项成绩，返回空
        if (getCheckSubItemResult(studentID).isEmpty())
            return null;

        //如果缓考或免考，不返回成绩

        return CountFinalResultNext(studentID);
    }
}
