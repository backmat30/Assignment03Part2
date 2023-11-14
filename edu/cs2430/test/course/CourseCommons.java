package edu.cs2430.test.course;

import edu.cs2430.assignment3.Course;
import edu.cs2430.assignment3.Program;
import edu.cs2430.test.utils.Utils;

import java.lang.reflect.Field;

public class CourseCommons
{
    // Should move to somewhere common
    private static final String DEFAULT_INDENT = "     ";

    private static final String NAME_FIELD_NAME = "name";
    private static final String COURSE_NUMBER_FIELD_NAME = "number";
    private static final String PROGRAM_FIELD_NAME = "program";
    private static final String NUMBER_OF_CREDITS_FIELD_NAME = "numberOfCredits";
    private static final String PREREQUISITE_COURSES_FIELD_NAME = "prerequisiteCourses";
    private static final String CURRENT_PREREQUISITE_INDEX_FIELD_NAME = "currentPrerequisiteIndex";
    private static final String MAX_PREREQUISITES_FIELD_NAME = "MAX_PREREQUISITES";


    private final Field NAME_FIELD;
    private final Field COURSE_NUMBER_FIELD;
    private final Field PROGRAM_FIELD;
    private final Field NUMBER_OF_CREDITS_FIELD;
    private final Field PREREQUISITE_COURSES_FIELD;
    private final Field CURRENT_PREREQUISITE_INDEX_FIELD;
    private final Field MAX_PREREQUISITES_FIELD;

    public CourseCommons()
    {
        // Test setup
        try
        {
            NAME_FIELD = Course.class.getDeclaredField(NAME_FIELD_NAME);
            NAME_FIELD.setAccessible(true);

            COURSE_NUMBER_FIELD = Course.class.getDeclaredField(COURSE_NUMBER_FIELD_NAME);
            COURSE_NUMBER_FIELD.setAccessible(true);

            PROGRAM_FIELD = Course.class.getDeclaredField(PROGRAM_FIELD_NAME);
            PROGRAM_FIELD.setAccessible(true);

            NUMBER_OF_CREDITS_FIELD = Course.class.getDeclaredField(NUMBER_OF_CREDITS_FIELD_NAME);
            NUMBER_OF_CREDITS_FIELD.setAccessible(true);

            PREREQUISITE_COURSES_FIELD = Course.class.getDeclaredField(PREREQUISITE_COURSES_FIELD_NAME);
            PREREQUISITE_COURSES_FIELD.setAccessible(true);

            CURRENT_PREREQUISITE_INDEX_FIELD = Course.class.getDeclaredField(CURRENT_PREREQUISITE_INDEX_FIELD_NAME);
            CURRENT_PREREQUISITE_INDEX_FIELD.setAccessible(true);

            MAX_PREREQUISITES_FIELD = Course.class.getDeclaredField(MAX_PREREQUISITES_FIELD_NAME);
            MAX_PREREQUISITES_FIELD.setAccessible(true);
        }
        catch (NoSuchFieldException e)
        {
            // I suppose we just rethrow it, since the program should crash if this happens
            throw new RuntimeException(e);
        }
    }

    public Field getNameField()
    {
        return NAME_FIELD;
    }

    public Field getCourseNumberField()
    {
        return COURSE_NUMBER_FIELD;
    }

    public Field getProgramField()
    {
        return PROGRAM_FIELD;
    }

    public Field getNumberOfCreditsField()
    {
        return NUMBER_OF_CREDITS_FIELD;
    }

    public Field getPrerequisiteCoursesField()
    {
        return PREREQUISITE_COURSES_FIELD;
    }

    public Field getCurrentPrerequisiteIndexField()
    {
        return CURRENT_PREREQUISITE_INDEX_FIELD;
    }

    public Field getMaxPrerequisitesField()
    {
        return MAX_PREREQUISITES_FIELD;
    }

    public String generateStateString(Course currentObject) throws IllegalAccessException
    {
        return generateStateString(currentObject, "");
    }

    public String generateStateString(Course currentObject, String indent) throws IllegalAccessException
    {
        StringBuilder sb = new StringBuilder();

        if(currentObject == null)
        {
            sb.append(indent);
            sb.append("null");
            return sb.toString();
        }

        String currentName = (String) NAME_FIELD.get(currentObject);
        int currentCourseNumber = (int) COURSE_NUMBER_FIELD.get(currentObject);
        Program currentProgram = (Program) PROGRAM_FIELD.get(currentObject);
        int currentNumberOfCredits = (int) NUMBER_OF_CREDITS_FIELD.get(currentObject);
        Course[] currentPrerequisiteCourses = (Course[]) PREREQUISITE_COURSES_FIELD.get(currentObject);
        int currentPrerequisiteIndex = (int) CURRENT_PREREQUISITE_INDEX_FIELD.get(currentObject);
        int currentMaxPrerequisiteIndex = (int) MAX_PREREQUISITES_FIELD.get(null);


        sb.append(indent);
        sb.append(NAME_FIELD_NAME);
        sb.append(":  ");
        sb.append(Utils.nullSafeToString(currentName));
        sb.append("\n");

        sb.append(indent);
        sb.append(COURSE_NUMBER_FIELD_NAME);
        sb.append(":  ");
        sb.append(currentCourseNumber);
        sb.append("\n");

        sb.append(indent);
        sb.append(PROGRAM_FIELD_NAME);
        sb.append(":  ");
        sb.append(currentProgram);
        sb.append("\n");

        sb.append(indent);
        sb.append(NUMBER_OF_CREDITS_FIELD_NAME);
        sb.append(":  ");
        sb.append(currentNumberOfCredits);
        sb.append("\n");


        sb.append(indent);
        sb.append(PREREQUISITE_COURSES_FIELD_NAME);
        sb.append(":  ");
        sb.append("\n");
        sb.append(indent);
        sb.append("[");
        sb.append("\n");

        boolean first = true;

        for (int i=0; i<currentPrerequisiteIndex; i++)
        {
            Course currentPrerequisiteCourse = currentPrerequisiteCourses[i];

            if (currentPrerequisiteCourse != null)
            {
                if(!first)
                {
                    sb.append("\n");
                }

                first = false;
                sb.append(generateStateString(currentPrerequisiteCourse, indent + DEFAULT_INDENT));
                sb.append("\n");
            }
        }

        sb.append(indent);
        sb.append("]\n");

        sb.append(indent);
        sb.append(CURRENT_PREREQUISITE_INDEX_FIELD_NAME);
        sb.append(":  ");
        sb.append(currentPrerequisiteIndex);
        sb.append("\n");

        sb.append(indent);
        sb.append(MAX_PREREQUISITES_FIELD_NAME);
        sb.append(":  ");
        sb.append(currentMaxPrerequisiteIndex);

        return sb.toString();
    }
}
