package com.sda.diary.backend;


public class TimeDTO {
    private String currentDateTime;

    public TimeDTO() {
    }
    public TimeDTO(String currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public String getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(String currentDateTime) {
        this.currentDateTime = currentDateTime;
    }
}
