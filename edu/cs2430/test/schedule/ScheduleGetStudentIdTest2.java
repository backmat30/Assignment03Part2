package edu.cs2430.test.schedule;

import edu.cs2430.assignment3.Schedule;

// Prerequisites:
// Course Constructor tests
// ScheduleEntry Constructor tests
// ScheduleConstructor1Test

/**
 * Test designed to test the getStudentId method in Schedule
 * @author James G. Hickey
 */
public class ScheduleGetStudentIdTest2
{
    public static void main(String[] args) throws IllegalAccessException
    {
        ScheduleCommons scheduleCommons = new ScheduleCommons();

        // Test input
        int studentId = 60711993;

        Schedule testSchedule = new Schedule(studentId);

        // Test method
        int returnValue = testSchedule.getStudentId();

        // Output
        String outputString = scheduleCommons.generateStateString(testSchedule);

        System.out.println("Return Value:  " + returnValue + "\n");
        System.out.println("Schedule:");
        System.out.println(outputString);
    }
}
