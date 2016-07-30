package com.epam.jmp3.domain;

/**
 * Created by Vitali on 30.07.2016.
 */
public abstract class Robot {
    private String name;

    public Robot() {
    }

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract long getDestroyingTime();
}
