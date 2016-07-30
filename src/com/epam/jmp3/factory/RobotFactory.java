package com.epam.jmp3.factory;

import com.epam.jmp3.domain.FastRobot;
import com.epam.jmp3.domain.FlyingRobot;
import com.epam.jmp3.domain.HeavyRobot;
import com.epam.jmp3.domain.Robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Vitali on 30.07.2016.
 */
public class RobotFactory {
    private static final int ROBOT_CREATION_TIME_MILLIS = 3000;
    private static List<Class> robotClasses = new ArrayList<Class>();

    static {
        robotClasses.add(FastRobot.class);
        robotClasses.add(FlyingRobot.class);
        robotClasses.add(HeavyRobot.class);
    }

    public static Robot createRobot (){
        try {
            Thread.sleep(ROBOT_CREATION_TIME_MILLIS);
            int randomIndex = new Random().nextInt(robotClasses.size() - 1);
            return (Robot) robotClasses.get(randomIndex).newInstance();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
