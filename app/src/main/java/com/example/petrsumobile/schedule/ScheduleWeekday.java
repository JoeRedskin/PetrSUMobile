package com.example.petrsumobile.schedule;


import java.util.ArrayList;

public class ScheduleWeekday {

    public enum STATE {
        CLOSED,
        OPENED
    }
    STATE state = STATE.CLOSED;
    private ArrayList<Schedule> scheduleArrayList;
    private String nameWeekday;

    public ScheduleWeekday(ArrayList<Schedule> scheduleArrayList, String nameWeekday){
        this.scheduleArrayList = scheduleArrayList;
        this.nameWeekday = nameWeekday;
    }


    public ArrayList<Schedule> getScheduleArrayList() {
        return scheduleArrayList;
    }

    public String getNameWeekday() {
        return nameWeekday;
    }
}
