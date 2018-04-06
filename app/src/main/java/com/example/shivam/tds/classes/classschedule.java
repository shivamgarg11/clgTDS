package com.example.shivam.tds.classes;

/**
 * Created by shivam on 06/04/18.
 */

public class classschedule {
    String topic;
    String time;
    String venue;
    String lectureno;
    String teacher;

    public classschedule(String topic, String time, String venue, String lectureno, String teacher) {
        this.topic = topic;
        this.time = time;
        this.venue = venue;
        this.lectureno = lectureno;
        this.teacher = teacher;
    }

    public classschedule(){

    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getLectureno() {
        return lectureno;
    }

    public void setLectureno(String lectureno) {
        this.lectureno = lectureno;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
