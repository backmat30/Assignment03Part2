package edu.cs2430.test.schedule;

import edu.cs2430.assignment3.*;

// public Schedule(int studentId)

// Prerequisites:
// Course Constructor tests
// ScheduleEntry Constructor tests

public class ScheduleConstructor1Test1
{
    public static void main(String[] args) throws IllegalAccessException
    {
        ScheduleCommons scheduleCommons = new ScheduleCommons();

        // Test input
        int setStudentId = 1;

        // Test method with test input
        Schedule newSchedule = new Schedule(setStudentId);

        // Verify the output -> Output the information to a file and compare string output
        String outputString = scheduleCommons.generateStateString(newSchedule);

        System.out.println(outputString);
    }
}
