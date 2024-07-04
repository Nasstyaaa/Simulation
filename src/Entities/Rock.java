package Entities;

import Simulation.Map;

import java.util.ArrayList;

public class Rock extends Entity{
    @Override
    public void createObjectOnMap(Map map) {
        int sizeMap = (map.getLengthY() * map.getLengthX()) / 10;
        ArrayList<Entity> listOfRock = new ArrayList<>();
        for (int i = 0; i < sizeMap; i++){
            int locationXRock = (int) (Math.random() * (map.getLengthX()));
            int locationYRock = (int) (Math.random() * (map.getLengthY()));
            listOfRock.add(new Rock(locationXRock, locationYRock));
        }
        map.addObjectsOnMap(listOfRock);
    }

    public Rock(int locationByX, int locationByY) {
        super(locationByX, locationByY);
    }
}
