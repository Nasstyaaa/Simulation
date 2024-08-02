package Entities;

import Сomponents.MapWorld;

import java.util.ArrayList;

public class Rock extends Entity{
    @Override
    public ArrayList<Rock> createObjects(MapWorld map) {
        int sizeMap = (map.getLengthY() * map.getLengthX()) / 10;
        ArrayList<Rock> listOfRock = new ArrayList<>();
        for (int i = 0; i < sizeMap; i++){
            listOfRock.add(new Rock());
        }
        return listOfRock;
    }
    public Rock(){}
}
