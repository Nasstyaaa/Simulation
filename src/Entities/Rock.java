package Entities;

import Simulation.MapWorld;

import java.util.ArrayList;

public class Rock extends Entity{
    @Override
    public ArrayList<Rock> createObjectOnMap(MapWorld map) {
        int sizeMap = (map.getLengthY() * map.getLengthX()) / 10;
        ArrayList<Rock> listOfRock = new ArrayList<>();
        for (int i = 0; i < sizeMap; i++){
            listOfRock.add(new Rock());
        }
        map.addObjectsOnMap(listOfRock);
        return listOfRock;
    }
    public Rock(){}
}
