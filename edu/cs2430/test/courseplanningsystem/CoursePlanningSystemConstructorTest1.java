package edu.cs2430.test.courseplanningsystem;

import edu.cs2430.assignment3.CoursePlanningSystem;

// public CoursePlanningSystem()

// Prerequisites:
// Course Constructor tests
// ScheduleEntry Constructor tests
// Student Constructor tests
public class CoursePlanningSystemConstructorTest1
{
    public static void main(String[] args) throws IllegalAccessException
    {
        CoursePlanningSystemCommons coursePlanningSystemCommons = new CoursePlanningSystemCommons();

        // Test input
        // None - default constructor

        // Test method with test input
        CoursePlanningSystem newCoursePlanningSystem = new CoursePlanningSystem();

        // Verify the output -> Output the information to a file and compare string output
        String outputString = coursePlanningSystemCommons.generateStateString(newCoursePlanningSystem);

        System.out.println(outputString);
    }
}
