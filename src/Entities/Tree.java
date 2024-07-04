package Entities;

import Simulation.Map;

import java.util.ArrayList;

public class Tree extends Entity{
    @Override
    public void createObjectOnMap(Map map) {
        int sizeMap = (map.getLengthY() * map.getLengthX()) / 10;
        ArrayList<Entity> listOfTree = new ArrayList<>();
        for (int i = 0; i < sizeMap; i++){
            int locationXRock = (int) (Math.random() * (map.getLengthX()));
            int locationYRock = (int) (Math.random() * (map.getLengthY()));
            listOfTree.add(new Tree(locationXRock, locationYRock));
        }
        map.addObjectsOnMap(listOfTree);
    }

    public Tree(int locationByX, int locationByY) {
        super(locationByX, locationByY);
    }
}
