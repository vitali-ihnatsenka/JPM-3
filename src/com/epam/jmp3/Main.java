package com.epam.jmp3;

import com.epam.jmp3.domain.City;
import com.epam.jmp3.domain.Earth;
import com.epam.jmp3.domain.Robot;
import com.epam.jmp3.domain.Superman;
import com.epam.jmp3.factory.RobotFactory;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread lexThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Lex has started");
                Earth earth = Earth.getInstance();
                while(!earth.isTimeOver()){
                    Robot robot = RobotFactory.createRobot();
                    System.out.println(robot.getName() + " has been created");
                    City city = earth.getFreeCity();
                    if(city != null){
                        System.out.println(robot.getName() + " occupied " + city.getName());
                        city.setRobot(robot);
                        earth.incrLiveRobotsConuter();
                    }else{
                        System.out.println("There is no free city");
                    }
                }
                System.out.println("Lex has finished");
            }
        });

        Thread supermanThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Superman has started");
                Earth earth = Earth.getInstance();
                Superman superman = Superman.getInstance();
                while(!earth.isTimeOver()){
                    City city = earth.getRandomCity();
                    if(city != null){
                        superman.go(city);
                        if(superman.fightRobot()){
                            earth.decrLiveRobotsConuter();
                        }
                    }
                }
                System.out.println("Superman has finished");
                System.out.println(superman.getDestroyedRobotsCounter() +" Robots destroyed");
            }
        });

        lexThread.start();
        supermanThread.start();
        lexThread.join();
        supermanThread.join();

        System.out.println("Max robots alive: " + Earth.getInstance().getMaxRobotsCount());

    }
}
