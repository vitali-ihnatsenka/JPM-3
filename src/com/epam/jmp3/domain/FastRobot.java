package com.epam.jmp3.domain;

import java.util.Random;

/**
 * Created by Vitali on 30.07.2016.
 */
public class FastRobot extends Robot {

    public FastRobot() {
        super("Fast robot");
    }

    @Override
    public long getDestroyingTime() {
        return new Random().nextInt(500) + 500;
    }
}
