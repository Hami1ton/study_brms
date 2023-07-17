package org.example.drlgroupby;

public class StudentTestScore {

    private String studentName;

    private String studentClass;

    private int testScore;

    public StudentTestScore(String studentName, String studentClass, int testScore) {
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.testScore = testScore;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public int getTestScore() {
        return testScore;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public void setTestScore(int testScore) {
        this.testScore = testScore;
    }

    @Override
    public String toString() {
        return "studentName: " + studentName + ", "
                + "studentClass: " + studentClass + ", "
                + "testScore: " + testScore;
    }
}
