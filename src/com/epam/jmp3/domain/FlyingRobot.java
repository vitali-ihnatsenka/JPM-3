package com.epam.jmp3.domain;

/**
 * Created by Vitali on 30.07.2016.
 */
public class FlyingRobot extends Robot {

    public FlyingRobot() {
        super("Flying Robot");
    }

    @Override
    public long getDestroyingTime() {
        return 500;
    }
}
