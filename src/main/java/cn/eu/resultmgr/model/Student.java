package cn.eu.resultmgr.model;

import cn.eu.framwork.bean.ValueObj;

public class Student extends ValueObj {
    private static final long serialVersionUID = -6046846135153005471L;
    private String studentID;
    private String studentNO;
    private String studentName;

    public Student(String studentID, String studentNO, String studentName) {
        this.studentID = studentID;
        this.studentNO = studentNO;
        this.studentName = studentName;
    }

    private Student(StudentBuilder studentBuilder){
        this.studentID=studentBuilder.studentID;
        this.studentNO=studentBuilder.studentNO;
        this.studentName=studentBuilder.studentName;
    }
    public String getStudentID() {
        return studentID;
    }

    public String getStudentNO() {
        return studentNO;
    }

    public String getStudentName() {
        return studentName;
    }

    public static  class StudentBuilder{

        private String studentID;
        private String studentNO;
        private String studentName;

        public StudentBuilder() {
        }

        public StudentBuilder setStudentID(String studentID) {
            this.studentID = studentID;
            return this;
        }

        public StudentBuilder setStudentNO(String studentNO) {
            this.studentNO = studentNO;
            return this;
        }

        public StudentBuilder setStudentName(String studentName) {
            this.studentName = studentName;
            return this;
        }



        public Student build(){
            return new Student(this);
        }

        public boolean equals(Student obj) {
            return  this.studentID.equals(obj.studentID)?true:false;
        }
    }
}
