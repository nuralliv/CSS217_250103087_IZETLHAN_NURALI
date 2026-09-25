package task17;

public class CursorGradeAdapter implements IGradeProvider {

    private final LegacyDataCursor legacyDataCursor;

    public CursorGradeAdapter(LegacyDataCursor legacyDataCursor) {
        this.legacyDataCursor = legacyDataCursor;
    }

    @Override
    public GradeRecord fetchCurrentGrade() {
        String courseCode = legacyDataCursor.getString("COURSE_NAME");
        int score = legacyDataCursor.getInt("STUDENT_SCORE");
        return new GradeRecord(courseCode, score);
    }
}
