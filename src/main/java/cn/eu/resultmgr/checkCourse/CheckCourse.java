package cn.eu.resultmgr.checkCourse;

import cn.eu.framwork.bean.ValueObj;
import cn.eu.resultmgr.contants.StudyRequire;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 *
 */
@Table("result_checkcourse")
public class CheckCourse extends ValueObj {
    private static final long serialVersionUID = 3580652548659070430L;

    public CheckCourse(CheckCourseID courseID, String courseNO, String courseName, StudyRequire studyRequire) {
        this.courseID = courseID;
        this.courseNO = courseNO;
        this.courseName = courseName;
        this.studyRequire = studyRequire;
    }
    @Id
    private CheckCourseID courseID;
    private String courseNO;
    private String courseName;
    private StudyRequire studyRequire;


    public CheckCourseID getCourseID() {
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

