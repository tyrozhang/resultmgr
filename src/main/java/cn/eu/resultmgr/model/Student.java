package cn.eu.resultmgr.model;

public class Student {


    private String studentID;
    private String studentNO;
    private String studentName;
    private String grade;
    private String speciality;
    private String ofClass;
    private String team;

    public Student(String studentID, String studentNO, String studentName, String grade, String speciality, String ofClass, String team) {
        this.studentID = studentID;
        this.studentNO = studentNO;
        this.studentName = studentName;
        this.grade = grade;
        this.speciality = speciality;
        this.ofClass = ofClass;
        this.team = team;
    }

    private Student(StudentBuilder studentBuilder){
        this.studentID=studentBuilder.studentID;
        this.studentNO=studentBuilder.studentNO;
        this.grade=studentBuilder.grade;
        this.ofClass=studentBuilder.ofClass;
        this.speciality=studentBuilder.speciality;
        this.studentName=studentBuilder.studentName;
        this.team=studentBuilder.team;
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
        private String grade;
        private String speciality;
        private String ofClass;
        private String team;

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

        public StudentBuilder setGrade(String grade) {
            this.grade = grade;
            return this;
        }

        public StudentBuilder setSpeciality(String speciality) {
            this.speciality = speciality;
            return this;
        }

        public StudentBuilder setOfClass(String ofClass) {
            this.ofClass = ofClass;
            return this;
        }

        public StudentBuilder setTeam(String team) {
            this.team = team;
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
