package com.example.petrsumobile.schedule;


import java.util.ArrayList;

public class ScheduleWeek {

    public enum STATE {
        CLOSED,
        OPENED
    }
    STATE state = STATE.CLOSED;
    private ArrayList<Schedule> scheduleArrayList;
    private String nameWeek;

    public ScheduleWeek(ArrayList<Schedule> scheduleArrayList, String nameWeek){
        this.scheduleArrayList = scheduleArrayList;
        this.nameWeek = nameWeek;
    }


    public ArrayList<Schedule> getScheduleArrayList() {
        return scheduleArrayList;
    }

    public String getNameWeek() {
        return nameWeek;
    }
}
