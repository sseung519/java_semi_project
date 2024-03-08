package studentInfo.project.school;

public class Score {
    protected int studentId;
    protected Subject subject;
    protected int point;

    public Score(int studentId, Subject subject, int point){
        this.studentId = studentId;
        this.subject = subject;
        this.point = point;
    }

    //객체의 주소가 아닌 객체의 정보를 출력해주는 기능
    @Override
    public String toString() {
        return "학번: " + this.studentId + ", " + subject.getSubjectName() + ": " + point;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
