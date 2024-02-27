package studentInfo.project.grade;

public class BasicEvaluation implements GradeEvaluation {
    @Override
    public String getGrade(int point) {
        String grade; //등급 저장 a,b등
        if (90 <= point && point <= 100) {
            grade = "A";
        } else if (80 <= point) {
            grade = "B";
        } else if (70 <= point) {
            grade = "C";
        } else if (55 <= point) {
            grade = "D";
        } else {
            grade = "F";
        }
        return grade;
    }
}
