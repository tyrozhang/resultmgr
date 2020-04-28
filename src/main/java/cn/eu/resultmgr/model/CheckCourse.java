package cn.eu.resultmgr.model;

import cn.eu.framwork.bean.ValueObj;
import cn.eu.resultmgr.contants.StudyRequire;

/**
 *
 */
public class CheckCourse extends ValueObj {
    private static final long serialVersionUID = 3580652548659070430L;

    public CheckCourse(String courseID, String courseNO, String courseName, StudyRequire studyRequire) {
        this.courseID = courseID;
        this.courseNO = courseNO;
        this.courseName = courseName;
        this.studyRequire = studyRequire;
    }

    private String courseID;
    private String courseNO;
    private String courseName;
    private StudyRequire studyRequire;


    public String getCourseID() {
        return courseID;
    }

    public String getCourseNO() {
        return courseNO;
    }

    public String getCourseName() {
        return courseName;
    }

    public StudyRequire getStudyRequire() {
        return studyRequire;
    }
}

