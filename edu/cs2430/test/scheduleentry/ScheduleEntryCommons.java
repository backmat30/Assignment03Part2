package edu.cs2430.test.scheduleentry;

import edu.cs2430.assignment3.Course;
import edu.cs2430.assignment3.ScheduleEntry;
import edu.cs2430.assignment3.Semester;
import edu.cs2430.test.course.CourseCommons;

import java.lang.reflect.Field;
import java.util.UUID;

public class ScheduleEntryCommons
{
    // Should move to somewhere common
    private static final String DEFAULT_INDENT = "     ";

    private static final String UUID_FIELD_NAME = "uuid";
    private static final String SEMESTER_FIELD_NAME = "semester";
    private static final String YEAR_FIELD_NAME = "year";
    private static final String COURSE_FIELD_NAME = "course";

    private final Field UUID_FIELD;
    private final Field SEMESTER_FIELD;
    private final Field YEAR_FIELD;
    private final Field COURSE_FIELD;

    public ScheduleEntryCommons()
    {
        // Test setup
        try
        {
            UUID_FIELD = ScheduleEntry.class.getDeclaredField(UUID_FIELD_NAME);
            UUID_FIELD.setAccessible(true);

            SEMESTER_FIELD = ScheduleEntry.class.getDeclaredField(SEMESTER_FIELD_NAME);
            SEMESTER_FIELD.setAccessible(true);

            YEAR_FIELD = ScheduleEntry.class.getDeclaredField(YEAR_FIELD_NAME);
            YEAR_FIELD.setAccessible(true);

            COURSE_FIELD = ScheduleEntry.class.getDeclaredField(COURSE_FIELD_NAME);
            COURSE_FIELD.setAccessible(true);
        }
        catch (NoSuchFieldException e)
        {
            // I suppose we just rethrow it, since the program should crash if this happens
            throw new RuntimeException(e);
        }
    }

    public Field getUuidField()
    {
        return UUID_FIELD;
    }

    public Field getSemesterField()
    {
        return SEMESTER_FIELD;
    }

    public Field getYearField()
    {
        return YEAR_FIELD;
    }

    public Field getCourseField()
    {
        return COURSE_FIELD;
    }

    public String generateStateString(ScheduleEntry currentObject) throws IllegalAccessException
    {
        return generateStateString(currentObject, "");
    }

    public String generateStateString(ScheduleEntry currentObject, String indent) throws IllegalAccessException
    {
        StringBuilder sb = new StringBuilder();

        if(currentObject == null)
        {
            sb.append(indent);
            sb.append("null");
            return sb.toString();
        }

        CourseCommons courseCommons = new CourseCommons();

        UUID currentUuid = (UUID) UUID_FIELD.get(currentObject);
        Semester currentSemester = (Semester) SEMESTER_FIELD.get(currentObject);
        int currentYear = (int) YEAR_FIELD.get(currentObject);
        Course currentCourse = (Course) COURSE_FIELD.get(currentObject);

        sb.append(indent);
        sb.append(UUID_FIELD_NAME);
        sb.append(":  ");
        // Since UUIDs will always be unique, I can only test for null vs non-null
        if(currentUuid == null)
        {
            sb.append("null");
        }
        else
        {
            sb.append("non-null uuid");
        }
        sb.append("\n");

        sb.append(indent);
        sb.append(SEMESTER_FIELD_NAME);
        sb.append(":  ");
        sb.append(currentSemester);
        sb.append("\n");

        sb.append(indent);
        sb.append(YEAR_FIELD_NAME);
        sb.append(":  ");
        sb.append(currentYear);
        sb.append("\n");

        sb.append(indent);
        sb.append(COURSE_FIELD_NAME);
        sb.append(":");
        sb.append("\n");
        sb.append(indent);
        sb.append("[");
        sb.append("\n");
        sb.append(courseCommons.generateStateString(currentCourse, indent+DEFAULT_INDENT));
        sb.append("\n");
        sb.append(indent);
        sb.append("]");

        return sb.toString();
    }
}
