package studentInfo.project.grade;

public class MajorEvaluation implements GradeEvaluation {
    @Override
    public String getGrade(int point) {
        String grade; //등급 저장
        if (95 <= point && point <= 100) {
            grade = "S";
        } else if (90 <= point) {
            grade = "A";
        } else if (80 <= point) {
            grade = "B";
        } else if (70 <= point) {
            grade = "C";
        } else if (60 <= point) {
            grade = "D";
        } else {
            grade = "F";
        }
        return grade;
    }
}
