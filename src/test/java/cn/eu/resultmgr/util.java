package cn.eu.resultmgr;

import cn.eu.resultmgr.checkCourse.CheckCourseID;
import cn.eu.resultmgr.contants.ScoreType;
import cn.eu.resultmgr.model.CheckTerm;
import cn.eu.resultmgr.model.Student;
import cn.eu.resultmgr.booking.domain.NormalExaminationBooking;

public class util {
    public static NormalExaminationBooking createNormalExaminationBooking(ScoreType scoreType) {
       CheckTerm checkTerm = new CheckTerm("2019-2020-1");
        NormalExaminationBooking nb= new NormalExaminationBooking(new CheckCourseID("c_id_123"),checkTerm, scoreType);
        for(int i=1;i<40;i++){
            nb.addStudent(getStudent("stu"+i,"一班"));
        }
        for(int j=11;j<20;j++){
            nb.addStudent(getStudent("stu"+j,"二班"));
        }

        return nb;
    }

/*    public static MakeUpExaminationBooking createMakeUpExaminationBooking(ScoreType scoreType) {
        CheckTerm checkTerm = new CheckTerm("2019-2020-1");
        MakeUpExaminationBooking makeUpExaminationBooking= new MakeUpExaminationBooking(new CheckCourseID("c_id_123"),checkTerm, scoreType);
        for(int i=1;i<10;i++){
            makeUpExaminationBooking.addStudent(getStudent("stu"+i,"一班"));
        }
        for(int j=11;j<20;j++){
            makeUpExaminationBooking.addStudent(getStudent("stu"+j,"二班"));
        }

        return makeUpExaminationBooking;
    }*/

    public static  Student getStudent() {
        return new Student("s_id_123", "s_no_123", "张三");
    }

    public  static Student getStudent(String studentID,String ofClass) {
        return new Student.StudentBuilder().setStudentID(studentID).build();
    }


}
