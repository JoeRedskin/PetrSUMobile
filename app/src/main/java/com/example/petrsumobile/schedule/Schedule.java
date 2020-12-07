package com.example.petrsumobile.schedule;

public class Schedule {

    private String classroom;
    private String startTime;
    private String endTime;
    private String lecturer;
    private String title;
    private String type;
    private Integer number;

    public Schedule(String classroom,String startTime,
                    String endTime,String lecturer,
                    String title, String type, Integer number){
        this.classroom = classroom;
        this.startTime = startTime;
        this.endTime = endTime;
        this.lecturer = lecturer;
        this.title = title;
        this.type = type;
        this.number = number;
    }

    public String getClassroom() {
        return classroom;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getLecturer() {
        return lecturer;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public Integer getNumber() {
        return number;
    }
}