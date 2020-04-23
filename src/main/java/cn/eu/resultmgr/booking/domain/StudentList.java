package cn.eu.resultmgr.booking.domain;

import cn.eu.resultmgr.model.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentList {
    ArrayList<Student> students=new ArrayList<Student>();
    public StudentList() {
    }

    public List<Student> getStudents(){
        return students.stream().collect(Collectors.toList());
    }

    public Student getStudent(String studentID){
        for(Iterator iter=this.students.iterator();iter.hasNext();){
            Student stu=(Student) iter.next();
            if(stu.getStudentID().equals(studentID))
                return stu;
        }
        return null;
    }

    public void addStudent(Student student){
        if(!this.students.contains(student)){
            this.students.add(student);
        }
    }
}
