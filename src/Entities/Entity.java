package Entities;

import Simulation.Map;

public abstract class Entity {
    protected int locationByX;
    protected int locationByY;

    public int getLocationByX() {
        return locationByX;
    }

    public int getLocationByY() {
        return locationByY;
    }

    public abstract void createObjectOnMap(Map map);


    public Entity(int locationByX, int locationByY) {
        this.locationByX = locationByX;
        this.locationByY = locationByY;
    }
}
