package task17;

public class Main {
    public static void main(String[] args) {
        CursorGradeAdapter gradeProvider = new CursorGradeAdapter(new LegacyDataCursor());
        System.out.println("Grade: " + gradeProvider.fetchCurrentGrade());
    }
}
