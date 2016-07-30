package com.epam.jmp3.domain;

/**
 * Created by Vitali on 30.07.2016.
 */
public class City {
    private Robot robot;
    private String name;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;

        City city = (City) o;

        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        if (robot != null ? !robot.equals(city.robot) : city.robot != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = robot != null ? robot.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "robot=" + robot +
                ", name='" + name + '\'' +
                '}';
    }
}
