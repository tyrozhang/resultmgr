package cn.eu.resultmgr.booking.persistence.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

@TableName("booking")//指定表名
public class BookingPO extends Model<BookingPO> implements Serializable {
    private static final long serialVersionUID = -5314864172818456783L;

    public BookingPO() {
    }
    //ID
    @TableId
    private String bookingID;
    //0 为NormalExaminationBooking；1 为MakeUpExaminationBooking
    private String type;
    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //课程属性
    private String courseID;
    private String courseNO;
    private String courseName;
    private String studyRequire;

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseNO() {
        return courseNO;
    }

    public void setCourseNO(String courseNO) {
        this.courseNO = courseNO;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudyRequire() {
        return studyRequire;
    }

    public void setStudyRequire(String studyRequire) {
        this.studyRequire = studyRequire;
    }

    //学期
    private String termName;

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    private String scoreType;

    public String getScoreType() {
        return scoreType;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType;
    }

    //学员--json
    private String students;

    public String getStudents() {
        return students;
    }

    public void setStudents(String students) {
        this.students = students;
    }

    //分项成绩 --json
    private String subItemResults;

    public String getSubItemResults() {
        return subItemResults;
    }

    public void setSubItemResults(String subItemResults) {
        this.subItemResults = subItemResults;
    }

    //考核计划 --json
    private String checkPlanItems;

    public String getCheckPlanItems() {
        return checkPlanItems;
    }

    public void setCheckPlanItems(String checkPlanItems) {
        this.checkPlanItems = checkPlanItems;
    }

    //考试行为 --json
    private String examBehaviorRecord;

    public String getExamBehaviorRecord() {
        return examBehaviorRecord;
    }

    public void setExamBehaviorRecord(String examBehaviorRecord) {
        this.examBehaviorRecord = examBehaviorRecord;
    }


}
