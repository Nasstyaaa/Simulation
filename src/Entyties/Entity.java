package Entyties;

public abstract class Entity {
    protected int locationByX;
    protected int locationByY;

    public int getLocationByX() {
        return locationByX;
    }

    public int getLocationByY() {
        return locationByY;
    }


    public Entity(int locationByX, int locationByY) {
        this.locationByX = locationByX;
        this.locationByY = locationByY;
    }
}
