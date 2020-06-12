package cn.eu.resultmgr.booking.domain;

import cn.eu.framwork.domain.IDomain;
import cn.eu.common.bean.BeanCopyUtil;
import cn.eu.resultmgr.booking.domain.examBehavior.ExamBehaviorRecord;
import cn.eu.resultmgr.service.RecordResultService;
import cn.eu.resultmgr.checkCourse.CheckCourseID;
import cn.eu.resultmgr.contants.ScoreType;
import cn.eu.resultmgr.contants.TwoPointSystemResult;
import cn.eu.resultmgr.booking.checkPlan.CheckPlanItem;
import cn.eu.resultmgr.checkResult.CheckSubItemResult;
import cn.eu.resultmgr.checkResult.CheckSubItemResultStorehouse;
import cn.eu.resultmgr.booking.checkPlan.checkSubItem.CheckSubItem;
import cn.eu.resultmgr.booking.domain.exception.WithoutTheStudentException;
import cn.eu.resultmgr.model.CheckTerm;
import cn.eu.resultmgr.model.Score;
import cn.eu.resultmgr.model.Student;


import javax.annotation.Resource;
import java.util.*;

public abstract class Booking implements IDomain<Booking> {
    //登记册ID
    protected String bookingID=UUID.randomUUID().toString();
    //考核课程
    protected CheckCourseID checkCourseID;
    //分制类型
    protected ScoreType scoreType;
    //考核学期
    protected CheckTerm checkTerm;
    //学生名单
    protected List<Student> studentRoll = new ArrayList<>();

    //考核行为登记
    protected ExamBehaviorRecord examBehaviorRecord=new ExamBehaviorRecord();

    public Booking(CheckCourseID checkCourseID, CheckTerm checkTerm, ScoreType scoreType) {
        super();
        this.checkCourseID = checkCourseID;
        this.checkTerm = checkTerm;
        this.scoreType = scoreType;
    }

    //获取考核学生名单
    public List<Student> getStudents(){
        return BeanCopyUtil.clone(studentRoll);
    }



    //更正分制
    public void changeScoreType(ScoreType scoreType){
        if (this.scoreType==scoreType)
            return;
        this.scoreType=scoreType;
    }


    public abstract Set<CheckPlanItem> getCheckPlanItems();

    ///检查分项是否在考核方案中
    public abstract boolean hasCheckSubItem(CheckSubItem checkSubItem);

    //检查登记的分数是否符合成绩分项分制
    public abstract boolean checkItemScoreIsValid(ScoreType scoreType);



    //后期需修改为返回克隆对象
    public CheckCourseID getCheckCourseID() {
        return this.checkCourseID.copy();
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



    /**
     * 增加学生
     */
    public void addStudent(Student student){
        this.studentRoll.add(student);
    }

    /**
     * 批量增加学生
     * @param students
     */
    public void addStudents(List<Student> students){
        for (Student student:students) {
            this.studentRoll.add(student);
        }
    }

    //判断某学生是否在学生名单中
    public Boolean isHasStudent(String studentID){
        for (Student stu:this.studentRoll) {
            if (stu.getStudentID().equals(studentID))
                return true;
        }
        return false;
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
/*    public  Score countFinalResult(String studentID){
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
            return Score.emptyScore();

        //如果缓考或免考，不返回成绩

        return countFinalResultNext(studentID);
    }*/
}
