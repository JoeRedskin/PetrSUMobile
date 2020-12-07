package com.example.petrsumobile.schedule;

import java.util.ArrayList;

public class ScheduleWeekType {

    private ArrayList<ScheduleWeek> scheduleWeekArrayList;
    private String weekType;

    public ScheduleWeekType(ArrayList<ScheduleWeek> scheduleWeekArrayList, String weekType){
        this.scheduleWeekArrayList = scheduleWeekArrayList;
        this.weekType = weekType;
    }

    public ArrayList<ScheduleWeek> getScheduleWeekArrayList() {
        return scheduleWeekArrayList;
    }

    public String getWeekType() {
        return weekType;
    }
}
