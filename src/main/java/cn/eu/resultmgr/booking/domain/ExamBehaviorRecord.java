package cn.eu.resultmgr.booking.domain;

import cn.eu.resultmgr.contants.ExamBehavior;

import java.util.HashMap;
import java.util.Map;

public class ExamBehaviorRecord {
    private Map<String,ExamBehavior> examBehaviorRecords;

    public ExamBehaviorRecord() {
    }

    /**
     * 登记作弊
     */
    public void makeCheatedMark(String studentID){
        initExamBehaviorRecordWhenIsNull();
        this.examBehaviorRecords.put(studentID,ExamBehavior.CHEATED);
    }
    /**
     * 登记缺考
     */
    public void markAbsentExam(String studentID){
        this.examBehaviorRecords.put(studentID,ExamBehavior.ABSENT);
    }
    /**
     * 登记免考
     */
    public void markAvoidExam(String studentID){
        this.examBehaviorRecords.put(studentID,ExamBehavior.AVOIDEXAM);
    }

    /**
     * 登记缓考
     */
    public void makeDelayExamMark(String studentID){
        initExamBehaviorRecordWhenIsNull();
        this.examBehaviorRecords.put(studentID,ExamBehavior.DELAYEXAM);
    }


    //初始化集合
    private void initExamBehaviorRecordWhenIsNull(){
        if (this.examBehaviorRecords==null)
            this.examBehaviorRecords = new HashMap<String,ExamBehavior>();
    }

    /**
     * 某学生是否违纪
     */
    public boolean isCheatedOrAbsent(String studentID){
        if(this.examBehaviorRecords==null)
            return false;

        ExamBehavior examBehavior = this.examBehaviorRecords.get(studentID);
        if(examBehavior == null)
            return false;

        if(examBehavior==ExamBehavior.CHEATED)
            return true;

        if(examBehavior==ExamBehavior.ABSENT)
            return true;

        return false;
    }
}
