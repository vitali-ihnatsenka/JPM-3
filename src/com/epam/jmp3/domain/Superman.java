package com.epam.jmp3.domain;

/**
 * Created by Vitali on 30.07.2016.
 */
public class Superman {
    private static final long TIME_BETWEEN_CITIES_MILLIS = 500;

    private static Superman instance;
    private City currentCity;
    private int destroyedRobotsCounter;

    private Superman (){
    }

    public static synchronized Superman getInstance(){
        if(instance == null){
            instance = new Superman();
        }
        return instance;
    }

    public boolean fightRobot(){
        if(currentCity == null || currentCity.getRobot() == null){
            return false;
        }
        Robot robot = currentCity.getRobot();
        try {
            System.out.println("Superman is fighting with " + robot.getName());
            Thread.sleep(robot.getDestroyingTime());
            currentCity.setRobot(null);
            destroyedRobotsCounter++;
            return true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void go(City city){
        try {
            if(city == null){
                return;
            }
            if(currentCity != null && currentCity.equals(city)){
                return;
            }
            System.out.println("Superman is going to " + city.getName());
            Thread.sleep(TIME_BETWEEN_CITIES_MILLIS);
            currentCity = city;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getDestroyedRobotsCounter(){
        return destroyedRobotsCounter;
    }
}
