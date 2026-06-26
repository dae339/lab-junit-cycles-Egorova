import java.util.ArrayList;

public class StudentGrade {
    private String studentName;
    private ArrayList<Integer> grades;
    private static int totalGradesAdded = 0;

    public StudentGrade(String name) {
        this.studentName = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        if (grade >= 2 && grade <= 5) {
            grades.add(grade);
            totalGradesAdded++;
        }
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int g : grades) sum += g;
        return (double) sum / grades.size();
    }

    public int getGradesCount() {
        return grades.size();
    }

    public static int getTotalGradesAdded() {
        return totalGradesAdded;
    }
}