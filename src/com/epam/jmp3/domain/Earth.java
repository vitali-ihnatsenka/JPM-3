package com.epam.jmp3.domain;

import java.util.*;

/**
 * Created by Vitali on 30.07.2016.
 */
public class Earth {
    private static final long EARTH_LIVE_TIME_MILLIS = 60000;

    Set<City> cities = Collections.synchronizedSet(new HashSet<City>());
    private static Earth instance;
    private long overTime;
    private int liveRobotsCounter;
    private int maxRobotsCount;

    private Earth(){
        cities.add(new City("Tokyo"));
        cities.add(new City("New York"));
        cities.add(new City("Sao Paulo"));
        cities.add(new City("Seoul"));
        cities.add(new City("Mexico"));
        cities.add(new City("Manila"));
        cities.add(new City("Jakarta"));
        cities.add(new City("Los Angeles"));
        cities.add(new City("Moscow"));
        cities.add(new City("Istanbul"));
    }

    public static synchronized Earth getInstance(){
        if(instance == null){
            instance = new Earth();
            instance.overTime = Calendar.getInstance().getTimeInMillis() + EARTH_LIVE_TIME_MILLIS;
        }
        return instance;
    }

    public boolean isTimeOver(){
        if(Calendar.getInstance().getTimeInMillis() >= overTime ){
            return true;
        }
        return false;
    }

    public City getFreeCity(){
        Iterator<City> iterator = cities.iterator();
        while (iterator.hasNext()){
            City city = iterator.next();
            if(city.getRobot() == null){
                return city;
            }
        }
        return null;
    }

    public City getRandomCity() {
        int size = cities.size();
        int item = new Random().nextInt(size);
        int i = 0;
        for(City city :cities)
        {
            if (i == item)
                return city;
            i = i + 1;
        }
        return null;
    }

    public void incrLiveRobotsConuter(){
        liveRobotsCounter++;
        if(liveRobotsCounter > maxRobotsCount){
            maxRobotsCount = liveRobotsCounter;
        }
    }

    public void decrLiveRobotsConuter(){
        liveRobotsCounter--;
    }

    public int getLiveRobotsCount(){
        return liveRobotsCounter;
    }

    public int getMaxRobotsCount(){
        return maxRobotsCount;
    }
}
