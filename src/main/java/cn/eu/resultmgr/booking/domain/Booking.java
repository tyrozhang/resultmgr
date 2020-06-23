package cn.eu.resultmgr.booking.domain;

import cn.eu.framwork.domain.IDomain;
import cn.eu.common.bean.BeanCopyUtil;
import cn.eu.resultmgr.model.checkPlan.CheckPlan;
import cn.eu.resultmgr.booking.domain.examBehavior.ExamBehaviorRecord;
import cn.eu.resultmgr.checkCourse.CheckCourseID;
import cn.eu.resultmgr.contants.ScoreType;

import cn.eu.resultmgr.model.checkSubItem.CheckSubItem;
import cn.eu.resultmgr.model.CheckTerm;
import cn.eu.resultmgr.model.Student;

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

    //是否违纪
    public boolean isCheatedOrAbsent(String studentID){
        if(!this.isHasStudent(studentID))
            return false;
        if (this.examBehaviorRecord.isCheatedOrAbsent(studentID))
            return true;
        return false;
    }


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
}
