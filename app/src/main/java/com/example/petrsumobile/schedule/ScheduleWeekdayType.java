package com.example.petrsumobile.schedule;

import java.util.ArrayList;

public class ScheduleWeekdayType {

    private ArrayList<ScheduleWeekday> scheduleWeekdayArrayList;
    private String weekdayType;

    public ScheduleWeekdayType(ArrayList<ScheduleWeekday> scheduleWeekdayArrayList, String weekdayType){
        this.scheduleWeekdayArrayList = scheduleWeekdayArrayList;
        this.weekdayType = weekdayType;
    }

    public ArrayList<ScheduleWeekday> getScheduleWeekdayArrayList() {
        return scheduleWeekdayArrayList;
    }

    public String getWeekdayType() {
        return weekdayType;
    }
}
