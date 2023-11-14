package edu.cs2430.test.schedule;

import edu.cs2430.assignment3.Schedule;
import edu.cs2430.assignment3.ScheduleEntry;
import edu.cs2430.test.course.CourseCommons;
import edu.cs2430.test.scheduleentry.ScheduleEntryCommons;

import java.lang.reflect.Field;
import java.util.UUID;

public class ScheduleCommons
{
    // Should move to somewhere common
    private static final String DEFAULT_INDENT = "     ";

    private static final String UUID_FIELD_NAME = "uuid";
    private static final String STUDENT_ID_FIELD_NAME = "studentId";
    private static final String SCHEDULE_ENTRIES_FIELD_NAME = "scheduleEntries";
    private static final String SCHEDULE_ENTRY_INDEX_FIELD_NAME = "scheduleEntryIndex";
    private static final String MAX_SCHEDULE_ENTRY_FIELD_NAME = "MAX_SCHEDULE_ENTRY";

    private final Field UUID_FIELD;
    private final Field STUDENT_ID_FIELD;
    private final Field SCHEDULE_ENTRIES_FIELD;
    private final Field SCHEDULE_ENTRY_INDEX_FIELD;
    private final Field MAX_SCHEDULE_ENTRY_FIELD;


    public ScheduleCommons()
    {
        // Test setup
        try
        {
            UUID_FIELD = Schedule.class.getDeclaredField(UUID_FIELD_NAME);
            UUID_FIELD.setAccessible(true);

            STUDENT_ID_FIELD = Schedule.class.getDeclaredField(STUDENT_ID_FIELD_NAME);
            STUDENT_ID_FIELD.setAccessible(true);

            SCHEDULE_ENTRIES_FIELD = Schedule.class.getDeclaredField(SCHEDULE_ENTRIES_FIELD_NAME);
            SCHEDULE_ENTRIES_FIELD.setAccessible(true);

            SCHEDULE_ENTRY_INDEX_FIELD = Schedule.class.getDeclaredField(SCHEDULE_ENTRY_INDEX_FIELD_NAME);
            SCHEDULE_ENTRY_INDEX_FIELD.setAccessible(true);

            MAX_SCHEDULE_ENTRY_FIELD = Schedule.class.getDeclaredField(MAX_SCHEDULE_ENTRY_FIELD_NAME);
            MAX_SCHEDULE_ENTRY_FIELD.setAccessible(true);
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

    public Field getStudentIdField()
    {
        return STUDENT_ID_FIELD;
    }

    public Field getScheduleEntriesField()
    {
        return SCHEDULE_ENTRIES_FIELD;
    }

    public Field getScheduleEntryIndexField()
    {
        return SCHEDULE_ENTRY_INDEX_FIELD;
    }

    public Field getMaxScheduleEntryField()
    {
        return MAX_SCHEDULE_ENTRY_FIELD;
    }

    public String generateStateString(Schedule currentObject) throws IllegalAccessException
    {
        return generateStateString(currentObject, "");
    }

    public String generateStateString(Schedule currentObject, String indent) throws IllegalAccessException
    {
        StringBuilder sb = new StringBuilder();

        if(currentObject == null)
        {
            sb.append(indent);
            sb.append("null");
            return sb.toString();
        }

        CourseCommons courseCommons = new CourseCommons();
        ScheduleEntryCommons scheduleEntryCommons = new ScheduleEntryCommons();

        UUID currentUuid = (UUID) UUID_FIELD.get(currentObject);
        int currentStudentId = (int) STUDENT_ID_FIELD.get(currentObject);
        ScheduleEntry[] currentScheduleEntries = (ScheduleEntry[]) SCHEDULE_ENTRIES_FIELD.get(currentObject);
        int currentScheduleEntryIndex = (int) SCHEDULE_ENTRY_INDEX_FIELD.get(currentObject);
        int currentMaxScheduleEntry = (int) MAX_SCHEDULE_ENTRY_FIELD.get(null);

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
        sb.append(STUDENT_ID_FIELD_NAME);
        sb.append(":  ");
        sb.append(currentStudentId);
        sb.append("\n");


        sb.append(indent);
        sb.append(SCHEDULE_ENTRIES_FIELD_NAME);
        sb.append(":  ");
        sb.append("\n");
        sb.append(indent);
        sb.append("[");
        sb.append("\n");

        boolean first = true;

        for (int i=0; i<currentScheduleEntryIndex; i++)
        {
            ScheduleEntry currentScheduleEntry = currentScheduleEntries[i];
            if (currentScheduleEntry != null)
            {
                if(!first)
                {
                    sb.append("\n");
                }

                first = false;
                sb.append(scheduleEntryCommons.generateStateString(currentScheduleEntry, indent + DEFAULT_INDENT));
                sb.append("\n");
            }
        }

        sb.append(indent);
        sb.append("]\n");

        sb.append(indent);
        sb.append(SCHEDULE_ENTRY_INDEX_FIELD_NAME);
        sb.append(":  ");
        sb.append(currentScheduleEntryIndex);
        sb.append("\n");

        sb.append(indent);
        sb.append(MAX_SCHEDULE_ENTRY_FIELD_NAME);
        sb.append(":  ");
        sb.append(currentMaxScheduleEntry);

        return sb.toString();
    }
}
