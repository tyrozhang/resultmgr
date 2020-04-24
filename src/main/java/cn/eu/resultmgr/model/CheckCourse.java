package cn.eu.resultmgr.model;

import cn.eu.framwork.bean.ValueObj;
import cn.eu.resultmgr.contants.StudyRequire;

import java.io.Serializable;

/**
 *
 */
public class CheckCourse extends ValueObj {
    private static final long serialVersionUID = 3580652548659070430L;

    public CheckCourse(String courseID, String courseNO, StudyRequire studyRequire) {
        this.courseID = courseID;
        this.courseNO = courseNO;
        this.studyRequire = studyRequire;
    }

    private String courseID;
    private String courseNO;
    private StudyRequire studyRequire;


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

    public StudyRequire getStudyRequire() {
        return studyRequire;
    }

    public void setStudyRequire(StudyRequire studyRequire) {
        this.studyRequire = studyRequire;
    }
}
