package cn.eu.resultmgr.booking.domain.examBehavior;

import cn.eu.resultmgr.contants.ExamBehavior;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ExamBehaviorRecord {
    private Map<String,ExamBehavior> examBehaviorRecords=new HashMap<String,ExamBehavior>();

    public ExamBehaviorRecord() {
    }

    /**
     * 登记作弊
     */
    public void makeCheatedMark(String studentID){
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
        if(this.examBehaviorRecords.size()==0)
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

    /*
    从jsonObject对象产生，用于反持久化时使用，业务中不使用
     */
    public static ExamBehaviorRecord genatateFromJsonStr(String jsonString){
        if(jsonString==null  || jsonString.equals(""))
            return new ExamBehaviorRecord();

        //枚举反序列化方法
        Map<String, ExamBehavior> map= new HashMap<String, ExamBehavior>();
        JSONObject jsonMap = (JSONObject)JSONObject.parse(jsonString);
        for(String key :jsonMap.keySet()){
            ExamBehavior a=ExamBehavior.fromString(jsonMap.get(key).toString());
            map.put(key,a);
        }

        ExamBehaviorRecord examBehaviorRecord = new ExamBehaviorRecord();
        examBehaviorRecord.examBehaviorRecords=map;
        return examBehaviorRecord;
    }

    /*
    从jsonObject对象产生，用于反持久化时使用，业务中不使用
     */
    public  String toJsonString(){
        return  JSON.toJSONString(this.examBehaviorRecords);
    }
}
