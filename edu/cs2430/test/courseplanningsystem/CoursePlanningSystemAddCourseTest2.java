package edu.cs2430.test.courseplanningsystem;

import edu.cs2430.assignment3.Course;
import edu.cs2430.assignment3.CoursePlanningSystem;
import edu.cs2430.assignment3.Program;

// public boolean addCourse(Course course)

// Prerequisites:
// Course Constructor tests
// ScheduleEntry Constructor tests
// Student Constructor tests
// CoursePlanningSystem Constructor tests
// CoursePlanningSystemAddCourseTest1
public class CoursePlanningSystemAddCourseTest2
{
    public static void main(String[] args) throws IllegalAccessException
    {
        CoursePlanningSystemCommons coursePlanningSystemCommons = new CoursePlanningSystemCommons();

        CoursePlanningSystem setCoursePlanningSystem = new CoursePlanningSystem();
        int maxArraySize = 1000;
        // Test input

        for(int i=0; i<maxArraySize; i++)
        {
            String setCourseName = "Course " + (i+1);
            int setCourseNumber = i;
            Program setProgram = Program.COMPUTER_SCIENCE;
            int setCredits = 3;
            Course setCourse = new Course(setCourseName, setCourseNumber, setProgram, setCredits);
            setCoursePlanningSystem.addCourse(setCourse);
        }

        String setCourseName = "Course " + (maxArraySize+1);
        int setCourseNumber = maxArraySize;
        Program setProgram = Program.COMPUTER_SCIENCE;
        int setCredits = 3;

        Course setCourse = new Course(setCourseName, setCourseNumber, setProgram, setCredits);

        // Test method with test input
        boolean returnValue = setCoursePlanningSystem.addCourse(setCourse);

        // Verify the output -> Output the information to a file and compare string output
        String outputString = coursePlanningSystemCommons.generateStateString(setCoursePlanningSystem);

        System.out.println("Return Value:  " + returnValue);
    }
}
