package com.mottakin.birthdayReminder.model;

public class Birthday {
    private Integer id;
    private String name;
    private String monthDate;

    public Birthday() {
    }

    public Birthday(Integer id, String name, String monthDate) {
        this.id = id;
        this.name = name;
        this.monthDate = monthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonthDate() {
        return monthDate;
    }

    public void setMonthDate(String monthDate) {
        this.monthDate = monthDate;
    }
}
