package studentInfo.project.school;

import studentInfo.project.school.Student;
import studentInfo.project.utils.Define;

import java.util.ArrayList;

public class Subject {
    protected String subjectName;
    protected int subjectId;
    protected int gradeType;
    protected ArrayList<Student>studentList = new ArrayList<>(); //과목을 수강신청한 학생 리스트

    public Subject(String subjectName, int subjectId){
        this.subjectName = subjectName;
        this.subjectId = subjectId;
        this.gradeType = Define.AB_TYPE; //학점 평가 정책: 기본으로 일반과목 산출 방식 사용
    }

    //수강신청
    public void register(Student student){
        studentList.add(student);
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getGradeType() {
        return gradeType;
    }

    public void setGradeType(int gradeType) {
        this.gradeType = gradeType;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
}
