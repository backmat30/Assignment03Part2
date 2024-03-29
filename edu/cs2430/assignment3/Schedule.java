package edu.cs2430.assignment3;

import java.util.UUID;

public class Schedule {
    private static final int MAX_SCHEDULE_ENTRY = 50;
    private ScheduleEntry[] scheduleEntries;
    private int scheduleEntryIndex;
    private int studentId;
    private UUID uuid;

    public Schedule(int studentID) {
        this.studentId = studentID;
        uuid = UUID.randomUUID();
        scheduleEntries = new ScheduleEntry[MAX_SCHEDULE_ENTRY];
    }

    public Schedule(Schedule otherSchedule) {
        studentId = otherSchedule.studentId;
        uuid = UUID.randomUUID();
        scheduleEntries = new ScheduleEntry[MAX_SCHEDULE_ENTRY];
        while (addScheduleEntry(otherSchedule.getScheduleEntry(scheduleEntryIndex)))
            ;
    }

    public boolean addScheduleEntry(ScheduleEntry scheduleEntry) {
        if (scheduleEntryIndex >= MAX_SCHEDULE_ENTRY || scheduleEntry == null) {
            return false;
        }
        scheduleEntries[scheduleEntryIndex] = scheduleEntry;
        scheduleEntryIndex++;
        return true;
    }

    public int calculateCredits() {
        int totalCredits = 0;
        for (ScheduleEntry scheduleEntry : scheduleEntries) {
            if (scheduleEntry != null) {
                totalCredits += scheduleEntry.getCourse().getNumberOfCredits();

            }
        }
        return totalCredits;
    }

    public int calculateCredits(Semester semester, int year) {
        int totalCredits = 0;
        for (ScheduleEntry scheduleEntry : scheduleEntries) {
            if (scheduleEntry != null && scheduleEntry.getSemester() == semester && scheduleEntry.getYear() == year) {
                totalCredits += scheduleEntry.getCourse().getNumberOfCredits();
            }
        }
        return totalCredits;
    }

    public Course[] getCoursesForSemester(Semester semester, int year) {
        Course[] coursesForSemester = new Course[0];
        for (ScheduleEntry scheduleEntry : scheduleEntries) {
            if (scheduleEntry != null && scheduleEntry.getSemester() == semester && scheduleEntry.getYear() == year) {
                Course[] tempCoursesForSemester = new Course[coursesForSemester.length + 1];
                for(int i = 0; i < coursesForSemester.length; i++){
                    tempCoursesForSemester[i] = coursesForSemester[i];
                }
                coursesForSemester = tempCoursesForSemester.clone();
                coursesForSemester[coursesForSemester.length - 1] = scheduleEntry.getCourse();
            }
        }
        return coursesForSemester;
    }

    public ScheduleEntry getScheduleEntry(int index) {
        return scheduleEntries[index];
    }

    public int getStudentId() {
        return studentId;
    }

    public UUID getUuid() {
        return uuid;
    }

    public boolean isCourseInSchedule(Course course) {
        for (ScheduleEntry scheduleEntry : scheduleEntries) {
            if (scheduleEntry != null && scheduleEntry.getCourse().equals(course)) {
                return true;
            }
        }
        return false;
    }

    private void removeScheduleEntry(int index) {
        for (int i = index; i < MAX_SCHEDULE_ENTRY - 2; i++) {
            scheduleEntries[i] = scheduleEntries[i + 1];
        }
        scheduleEntries[MAX_SCHEDULE_ENTRY - 1] = null;
        scheduleEntryIndex--;
    }

    public boolean removeScheduleEntry(Course course) {
        boolean isRemoved = false;
        for (int i = 0; i < MAX_SCHEDULE_ENTRY - 2; i++) {
            if (scheduleEntries[i] != null && scheduleEntries[i].getCourse().equals(course)) {
                isRemoved = true;
            }
            if (isRemoved) {
                scheduleEntries[i] = scheduleEntries[i + 1];
            }
        }
        if (isRemoved || scheduleEntries[MAX_SCHEDULE_ENTRY - 1].getCourse().equals(course)) {
            scheduleEntries[MAX_SCHEDULE_ENTRY - 1] = null;
            isRemoved = true;
            scheduleEntryIndex--;
            
        }
        return isRemoved;
    }

    public boolean removeScheduleEntry(UUID uuid) {
        boolean isRemoved = false;
        for (int i = 0; i < MAX_SCHEDULE_ENTRY - 2; i++) {
            if (scheduleEntries[i] != null && scheduleEntries[i].getUuid().equals(uuid)) {
                isRemoved = true;
            }
            if (isRemoved) {
                scheduleEntries[i] = scheduleEntries[i + 1];
            }
        }
        if (isRemoved || scheduleEntries[MAX_SCHEDULE_ENTRY - 1].getUuid().equals(uuid)) {
            scheduleEntries[MAX_SCHEDULE_ENTRY - 1] = null;
            isRemoved = true;
            scheduleEntryIndex--;
        }
        return isRemoved;
    }

}
