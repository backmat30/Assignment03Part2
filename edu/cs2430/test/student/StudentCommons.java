package edu.cs2430.test.student;

import edu.cs2430.assignment3.Schedule;
import edu.cs2430.assignment3.Student;
import edu.cs2430.test.schedule.ScheduleCommons;
import edu.cs2430.test.utils.Utils;

import java.lang.reflect.Field;

public class StudentCommons
{
    // Should move to somewhere common
    private static final String DEFAULT_INDENT = "     ";

    private static final String NEXT_STUDENT_ID_FIELD_NAME = "nextStudentId";
    private static final String ID_FIELD_NAME = "id";
    private static final String NAME_FIELD_NAME = "name";
    private static final String SCHEDULE_FIELD_NAME = "schedules";
    private static final String SCHEDULE_INDEX_FIELD_NAME = "scheduleIndex";
    private static final String MAX_SCHEDULES_FIELD_NAME = "MAX_SCHEDULES";

    private final Field NEXT_STUDENT_ID_FIELD;
    private final Field ID_FIELD;
    private final Field NAME_FIELD;
    private final Field SCHEDULE_FIELD;
    private final Field SCHEDULE_INDEX_FIELD;
    private final Field MAX_SCHEDULES_FIELD;


    public StudentCommons()
    {
        // Test setup
        try
        {
            NEXT_STUDENT_ID_FIELD = Student.class.getDeclaredField(NEXT_STUDENT_ID_FIELD_NAME);
            NEXT_STUDENT_ID_FIELD.setAccessible(true);

            ID_FIELD = Student.class.getDeclaredField(ID_FIELD_NAME);
            ID_FIELD.setAccessible(true);

            NAME_FIELD = Student.class.getDeclaredField(NAME_FIELD_NAME);
            NAME_FIELD.setAccessible(true);

            SCHEDULE_FIELD = Student.class.getDeclaredField(SCHEDULE_FIELD_NAME);
            SCHEDULE_FIELD.setAccessible(true);

            SCHEDULE_INDEX_FIELD = Student.class.getDeclaredField(SCHEDULE_INDEX_FIELD_NAME);
            SCHEDULE_INDEX_FIELD.setAccessible(true);

            MAX_SCHEDULES_FIELD = Student.class.getDeclaredField(MAX_SCHEDULES_FIELD_NAME);
            MAX_SCHEDULES_FIELD.setAccessible(true);
        }
        catch (NoSuchFieldException e)
        {
            // I suppose we just rethrow it, since the program should crash if this happens
            throw new RuntimeException(e);
        }
    }

    public Field getNextStudentIdField()
    {
        return NEXT_STUDENT_ID_FIELD;
    }

    public Field getIdField()
    {
        return ID_FIELD;
    }

    public Field getNameField()
    {
        return NAME_FIELD;
    }

    public Field getScheduleField()
    {
        return SCHEDULE_FIELD;
    }

    public Field getScheduleIndexField()
    {
        return SCHEDULE_INDEX_FIELD;
    }

    public Field getMaxSchedulesField()
    {
        return MAX_SCHEDULES_FIELD;
    }

    public String generateStateString(Student currentObject) throws IllegalAccessException
    {
        return generateStateString(currentObject, "");
    }

    public String generateStateString(Student currentObject, String indent) throws IllegalAccessException
    {
        StringBuilder sb = new StringBuilder();

        if(currentObject == null)
        {
            sb.append(indent);
            sb.append("null");
            return sb.toString();
        }

        ScheduleCommons scheduleCommons = new ScheduleCommons();

        int currentNextStudentId = (int) NEXT_STUDENT_ID_FIELD.get(null);
        int currentId = (int) ID_FIELD.get(currentObject);
        String currentName = (String) NAME_FIELD.get(currentObject);
        Schedule[] currentSchedules = (Schedule[]) SCHEDULE_FIELD.get(currentObject);
        int currentScheduleIndex = (int) SCHEDULE_INDEX_FIELD.get(currentObject);
        int currentMaxSchedules = (int) MAX_SCHEDULES_FIELD.get(null);

        sb.append(indent);
        sb.append(NEXT_STUDENT_ID_FIELD_NAME);
        sb.append(":  ");
        sb.append(currentNextStudentId);
        sb.append("\n");

        sb.append(indent);
        sb.append(ID_FIELD_NAME);
        sb.append(":  ");
        sb.append(currentId);
        sb.append("\n");

        sb.append(indent);
        sb.append(NAME_FIELD_NAME);
        sb.append(":  ");
        sb.append(Utils.nullSafeToString(currentName));
        sb.append("\n");


        sb.append(indent);
        sb.append(SCHEDULE_FIELD_NAME);
        sb.append(":  ");
        sb.append("\n");
        sb.append(indent);
        sb.append("[");
        sb.append("\n");

        boolean first = true;

        for (int i=0; i<currentScheduleIndex; i++)
        {
            Schedule currentSchedule = currentSchedules[i];

            if (currentSchedule != null)
            {
                if(!first)
                {
                    sb.append("\n");
                }

                first = false;
                sb.append(scheduleCommons.generateStateString(currentSchedule, indent + DEFAULT_INDENT));
                sb.append("\n");
            }
        }

        sb.append(indent);
        sb.append("]\n");

        sb.append(indent);
        sb.append(SCHEDULE_INDEX_FIELD_NAME);
        sb.append(":  ");
        sb.append(currentScheduleIndex);
        sb.append("\n");

        sb.append(indent);
        sb.append(MAX_SCHEDULES_FIELD_NAME);
        sb.append(":  ");
        sb.append(currentMaxSchedules);

        return sb.toString();
    }
}
