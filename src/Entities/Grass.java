package Entities;

import Simulation.Map;

import java.util.ArrayList;

public class Grass extends Entity{
    @Override
    public void createObjectOnMap(Map map) {
        int sizeMap = (map.getLengthY() * map.getLengthX()) / 7;
        ArrayList<Entity> listOfGrass = new ArrayList<>();
        for(int i = 0; i < sizeMap; i++){
            int locationX = (int) (Math.random() * (map.getLengthX()));
            int locationY = (int) (Math.random() * (map.getLengthY()));
            listOfGrass.add(new Grass(locationX, locationY));
        }
        map.addObjectsOnMap(listOfGrass);
    }

    public Grass(){}

    public Grass(int locationByX, int locationByY) {
        super(locationByX, locationByY);
    }
}
