package cn.eu.resultmgr;

import cn.eu.resultmgr.contants.ScoreType;
import cn.eu.resultmgr.contants.StudyRequire;
import cn.eu.resultmgr.model.CheckCourse;
import cn.eu.resultmgr.model.CheckTerm;
import cn.eu.resultmgr.model.Student;
import cn.eu.resultmgr.booking.domain.MakeUpExaminationBooking;
import cn.eu.resultmgr.booking.domain.NormalExaminationBooking;

public class util {
    public static NormalExaminationBooking initNormalExaminationBooking(ScoreType scoreType) {
        CheckCourse checkCourse = new CheckCourse("c_id_123","C_NO_123", StudyRequire.MUST_STUDY);
        CheckTerm checkTerm = new CheckTerm("2019-2020-1");
        NormalExaminationBooking nb= new NormalExaminationBooking(checkCourse,checkTerm, scoreType);
        for(int i=1;i<10;i++){
            nb.addStudent(getStudent("stu"+i,"一班"));
        }
        for(int j=11;j<20;j++){
            nb.addStudent(getStudent("stu"+j,"二班"));
        }

        return nb;
    }

    public static MakeUpExaminationBooking initMakeUpExaminationBooking(ScoreType scoreType) {
        CheckCourse checkCourse = new CheckCourse("c_id_123","C_NO_123", StudyRequire.MUST_STUDY);
        CheckTerm checkTerm = new CheckTerm("2019-2020-1");
        MakeUpExaminationBooking makeUpExaminationBooking= new MakeUpExaminationBooking(checkCourse,checkTerm, scoreType);
        for(int i=1;i<10;i++){
            makeUpExaminationBooking.addStudent(getStudent("stu"+i,"一班"));
        }
        for(int j=11;j<20;j++){
            makeUpExaminationBooking.addStudent(getStudent("stu"+j,"二班"));
        }

        return makeUpExaminationBooking;
    }

    public static  Student getStudent() {
        return new Student("s_id_123", "s_no_123", "张三","2019","jsj","一班","一队");
    }

    public  static Student getStudent(String studentID,String ofClass) {
        return new Student.StudentBuilder().setStudentID(studentID).setOfClass(ofClass).build();
    }


}
