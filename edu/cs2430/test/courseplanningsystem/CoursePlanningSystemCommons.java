package edu.cs2430.test.courseplanningsystem;

import edu.cs2430.assignment3.*;
import edu.cs2430.test.course.CourseCommons;
import edu.cs2430.test.schedule.ScheduleCommons;
import edu.cs2430.test.student.StudentCommons;

import java.lang.reflect.Field;

public class CoursePlanningSystemCommons
{
    // Should move to somewhere common
    private static final String DEFAULT_INDENT = "     ";

    private static final String COURSES_FIELD_NAME = "courses";
    private static final String SCHEDULES_FIELD_NAME = "schedules";
    private static final String STUDENTS_FIELD_NAME = "students";
    private static final String COURSE_INDEX_FIELD_NAME = "courseIndex";
    private static final String SCHEDULE_INDEX_FIELD_NAME = "scheduleIndex";
    private static final String STUDENT_INDEX_FIELD_NAME = "studentIndex";
    private static final String ARRAY_MAX_FIELD_NAME = "ARRAY_MAX";

    private final Field COURSES_FIELD;
    private final Field SCHEDULES_FIELD;
    private final Field STUDENTS_FIELD;
    private final Field COURSE_INDEX_FIELD;
    private final Field SCHEDULE_INDEX_FIELD;
    private final Field STUDENT_INDEX_FIELD;
    private final Field ARRAY_MAX_FIELD;

    public CoursePlanningSystemCommons()
    {
        // Test setup
        try
        {
            COURSES_FIELD = CoursePlanningSystem.class.getDeclaredField(COURSES_FIELD_NAME);
            COURSES_FIELD.setAccessible(true);

            SCHEDULES_FIELD = CoursePlanningSystem.class.getDeclaredField(SCHEDULES_FIELD_NAME);
            SCHEDULES_FIELD.setAccessible(true);

            STUDENTS_FIELD = CoursePlanningSystem.class.getDeclaredField(STUDENTS_FIELD_NAME);
            STUDENTS_FIELD.setAccessible(true);

            COURSE_INDEX_FIELD = CoursePlanningSystem.class.getDeclaredField(COURSE_INDEX_FIELD_NAME);
            COURSE_INDEX_FIELD.setAccessible(true);

            SCHEDULE_INDEX_FIELD = CoursePlanningSystem.class.getDeclaredField(SCHEDULE_INDEX_FIELD_NAME);
            SCHEDULE_INDEX_FIELD.setAccessible(true);

            STUDENT_INDEX_FIELD = CoursePlanningSystem.class.getDeclaredField(STUDENT_INDEX_FIELD_NAME);
            STUDENT_INDEX_FIELD.setAccessible(true);

            ARRAY_MAX_FIELD = CoursePlanningSystem.class.getDeclaredField(ARRAY_MAX_FIELD_NAME);
            ARRAY_MAX_FIELD.setAccessible(true);
        }
        catch (NoSuchFieldException e)
        {
            // I suppose we just rethrow it, since the program should crash if this happens
            throw new RuntimeException(e);
        }
    }

    public Field getCoursesField()
    {
        return COURSES_FIELD;
    }

    public Field getSchedulesField()
    {
        return SCHEDULES_FIELD;
    }

    public Field getStudentsField()
    {
        return STUDENTS_FIELD;
    }

    public Field getCourseIndexField()
    {
        return COURSE_INDEX_FIELD;
    }

    public Field getScheduleIndexField()
    {
        return SCHEDULE_INDEX_FIELD;
    }

    public Field getStudentIndexField()
    {
        return STUDENT_INDEX_FIELD;
    }

    public Field getArrayMaxField()
    {
        return ARRAY_MAX_FIELD;
    }

    public String generateStateString(CoursePlanningSystem currentObject) throws IllegalAccessException
    {
        return generateStateString(currentObject, "");
    }

    public String generateStateString(CoursePlanningSystem currentObject, String indent) throws IllegalAccessException
    {
        StringBuilder sb = new StringBuilder();

        if(currentObject == null)
        {
            sb.append(indent);
            sb.append("null");
            return sb.toString();
        }


        CourseCommons courseCommons = new CourseCommons();
        ScheduleCommons scheduleCommons = new ScheduleCommons();
        StudentCommons studentCommons = new StudentCommons();

        Course[] currentCourses = (Course[]) COURSES_FIELD.get(currentObject);
        Schedule[] currentSchedules = (Schedule[]) SCHEDULES_FIELD.get(currentObject);
        Student[] currentStudents = (Student[]) STUDENTS_FIELD.get(currentObject);
        int currentCourseIndex = (int) COURSE_INDEX_FIELD.get(currentObject);
        int currentScheduleIndex = (int) SCHEDULE_INDEX_FIELD.get(currentObject);
        int currentStudentIndex = (int) STUDENT_INDEX_FIELD.get(currentObject);
        int currentArrayMax = (int) ARRAY_MAX_FIELD.get(null);

        sb.append(indent);
        sb.append(COURSES_FIELD_NAME);
        sb.append(":  ");
        sb.append("\n");
        sb.append(indent);
        sb.append("[");
        sb.append("\n");

        boolean firstCourse = true;

        for (int i=0; i<currentCourseIndex; i++)
        {
            Course currentCourse = currentCourses[i];
            if (currentCourse != null)
            {
                if(!firstCourse)
                {
                    sb.append("\n");
                }

                firstCourse = false;
                sb.append(courseCommons.generateStateString(currentCourse, indent + DEFAULT_INDENT));
                sb.append("\n");
            }
        }

        sb.append(indent);
        sb.append("]\n");

        sb.append(indent);
        sb.append(SCHEDULES_FIELD_NAME);
        sb.append(":  ");
        sb.append("\n");
        sb.append(indent);
        sb.append("[");
        sb.append("\n");

        boolean firstSchedule = true;

        for (int i=0; i<currentScheduleIndex; i++)
        {
            Schedule currentSchedule = currentSchedules[i];

            if (currentSchedule != null)
            {
                if(!firstSchedule)
                {
                    sb.append("\n");
                }

                firstSchedule = false;
                sb.append(scheduleCommons.generateStateString(currentSchedule, indent + DEFAULT_INDENT));
                sb.append("\n");
            }
        }

        sb.append(indent);
        sb.append("]\n");

        sb.append(indent);
        sb.append(STUDENTS_FIELD_NAME);
        sb.append(":  ");
        sb.append("\n");
        sb.append(indent);
        sb.append("[");
        sb.append("\n");

        boolean firstStudent = true;

        for (int i=0; i<currentStudentIndex; i++)
        {
            Student currentStudent = currentStudents[i];

            if (currentStudent != null)
            {
                if(!firstStudent)
                {
                    sb.append("\n");
                }

                firstStudent = false;
                sb.append(studentCommons.generateStateString(currentStudent, indent + DEFAULT_INDENT));
                sb.append("\n");
            }
        }

        sb.append(indent);
        sb.append("]\n");

        sb.append(indent);
        sb.append(COURSE_INDEX_FIELD_NAME);
        sb.append(":  ");
        sb.append(currentCourseIndex);
        sb.append("\n");

        sb.append(indent);
        sb.append(SCHEDULE_INDEX_FIELD_NAME);
        sb.append(":  ");
        sb.append(currentScheduleIndex);
        sb.append("\n");

        sb.append(indent);
        sb.append(STUDENT_INDEX_FIELD_NAME);
        sb.append(":  ");
        sb.append(currentStudentIndex);
        sb.append("\n");

        sb.append(indent);
        sb.append(ARRAY_MAX_FIELD_NAME);
        sb.append(":  ");
        sb.append(currentArrayMax);

        return sb.toString();
    }
}
