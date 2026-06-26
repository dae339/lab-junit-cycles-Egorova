import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StudentGradeTest {

    private StudentGrade student;
    private static int totalGradesAdded;

    @BeforeAll
    static void initAll() {
        totalGradesAdded = 0;
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Общее количество добавленных оценок: " + StudentGrade.getTotalGradesAdded());
    }

    @BeforeEach
    void setUp() {
        student = new StudentGrade("Иванов");
        totalGradesAdded = StudentGrade.getTotalGradesAdded();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Текущее количество добавленных оценок: " + StudentGrade.getTotalGradesAdded());
    }

    // Задание 1
    @Test
    void testAverageGradeWithOneGrade() {
        student.addGrade(5);
        assertEquals(5.0, student.getAverageGrade(), 0.001);
        assertEquals(1, student.getGradesCount());
    }

    // Задание 2
    @Test
    void testAddValidGrade() {
        int initialCount = student.getGradesCount();
        int initialTotal = StudentGrade.getTotalGradesAdded();

        student.addGrade(4);

        assertEquals(initialCount + 1, student.getGradesCount());
        assertEquals(4.0, student.getAverageGrade(), 0.001);
        assertEquals(initialTotal + 1, StudentGrade.getTotalGradesAdded());
    }

    @Test
    void testAddInvalidGrade() {
        int initialCount = student.getGradesCount();
        int initialTotal = StudentGrade.getTotalGradesAdded();

        student.addGrade(6);

        assertEquals(initialCount, student.getGradesCount());
        assertEquals(0.0, student.getAverageGrade());
        assertEquals(initialTotal, StudentGrade.getTotalGradesAdded());
    }

    // Задание 3
    @Test
    void testMultipleGradesAddition() {
        int initialTotal = StudentGrade.getTotalGradesAdded();

        student.addGrade(5);
        student.addGrade(4);
        student.addGrade(3);

        assertEquals(3, student.getGradesCount());
        assertEquals((5+4+3)/3.0, student.getAverageGrade(), 0.001);
        assertEquals(initialTotal + 3, StudentGrade.getTotalGradesAdded());
    }

    @Test
    void testMixedGradesAddition() {
        int initialTotal = StudentGrade.getTotalGradesAdded();
        int validGrades = 0;

        student.addGrade(5);
        validGrades++;
        student.addGrade(6);
        student.addGrade(4);
        validGrades++;
        student.addGrade(7);
        student.addGrade(3);
        validGrades++;

        assertEquals(validGrades, student.getGradesCount());
        assertEquals((5+4+3)/3.0, student.getAverageGrade(), 0.001);
        assertEquals(initialTotal + validGrades, StudentGrade.getTotalGradesAdded());
    }
}