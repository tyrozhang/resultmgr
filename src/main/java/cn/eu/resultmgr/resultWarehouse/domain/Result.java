package cn.eu.resultmgr.resultWarehouse.domain;

import cn.eu.framwork.domain.IDomain;
import cn.eu.resultmgr.contants.ExamBehavior;
import cn.eu.resultmgr.model.CheckCourse;
import cn.eu.resultmgr.model.CheckTerm;
import cn.eu.resultmgr.model.Score;
import cn.eu.resultmgr.model.Student;

import java.util.Date;

public class Result implements IDomain {
    //成绩ID
    private String resultID=String.valueOf(new Date().getTime());

    private CheckCourse checkCourse;
    private CheckTerm checkTerm;
    private Student student;
    private ExamBehavior examBehavior;
    private Score finalScore;
    //正考成绩
    private Score markupScore;
    //补考成绩
    private String bookingID;
    @Override
    public String getEntityID() {
        return resultID;
    }

    public Result(CheckCourse checkCourse, CheckTerm checkTerm, Student student, ExamBehavior examBehavior, Score finalScore) {
        this.checkCourse = checkCourse;
        this.checkTerm = checkTerm;
        this.student = student;
        this.examBehavior = examBehavior;
        this.finalScore = finalScore;
    }

    public Result(CheckCourse checkCourse, CheckTerm checkTerm, Student student, ExamBehavior examBehavior, Score finalScore, String bookingID) {
        this(checkCourse,checkTerm,student,examBehavior,finalScore);
        this.bookingID=bookingID;
    }

    /**
     * 登记补考成绩
     * @param markupScore @see Score
     */
    public void recordMarkupScore(Score markupScore){

    }

    @Override
    public Object genatatePO() {
        return null;
    }
}
