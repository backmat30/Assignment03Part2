package edu.cs2430.test.schedule;

import edu.cs2430.assignment3.Schedule;


// Prerequisites:
// Course Constructor tests
// ScheduleEntry Constructor tests
// ScheduleConstructor1Test

/**
 * @author James G. Hickey
 */
public class ScheduleGetStudentIdTest1
{
    public static void main(String[] args) throws IllegalAccessException
    {
        ScheduleCommons scheduleCommons = new ScheduleCommons();

        // Test input
        int studentId = 1000;

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
