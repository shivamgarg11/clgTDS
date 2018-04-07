package com.example.shivam.tds.classes;

/**
 * Created by shivam on 07/04/18.
 */

public class questionofweek {
    String weekno;
    String description;
    String input;
    String output;
    String solve;
    String solution;

    public questionofweek(String weekno, String description, String input, String output, String solve, String solution) {
        this.weekno = weekno;
        this.description = description;
        this.input = input;
        this.output = output;
        this.solve = solve;
        this.solution = solution;
    }

    public questionofweek(){

    }

    public String getWeekno() {
        return weekno;
    }

    public void setWeekno(String weekno) {
        this.weekno = weekno;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getSolve() {
        return solve;
    }

    public void setSolve(String solve) {
        this.solve = solve;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
