package edu.cs2430.assignment3;

import java.util.UUID;

public final class ScheduleEntry {
    private final Course course;
    private final Semester semester;
    private final UUID uuid;
    private final int year;

    public ScheduleEntry(ScheduleEntry otherScheduleEntry){
        this.course = otherScheduleEntry.getCourse();
        this.semester = otherScheduleEntry.getSemester();
        uuid = UUID.randomUUID();
        year = otherScheduleEntry.getYear();
    }

    public Course getCourse() {
        return course;
    }

    public Semester getSemester() {
        return semester;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getYear() {
        return year;
    }
}
