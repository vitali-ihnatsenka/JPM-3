package com.epam.jmp3.domain;

/**
 * Created by Vitali on 30.07.2016.
 */
public class HeavyRobot extends Robot {

    public HeavyRobot() {
        super("Heavy robot");
    }

    @Override
    public long getDestroyingTime() {
        return 1000;
    }
}
