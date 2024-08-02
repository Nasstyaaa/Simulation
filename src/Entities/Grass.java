package Entities;

import Сomponents.MapWorld;

import java.util.ArrayList;

public class Grass extends Entity{
    @Override
    public ArrayList<Grass> createObjects(MapWorld map) {
        int sizeMap = (map.getLengthY() * map.getLengthX()) / 7;
        ArrayList<Grass> listOfGrass = new ArrayList<>();
        for(int i = 0; i < sizeMap; i++){
            listOfGrass.add(new Grass());
        }
        return listOfGrass;
    }

    public Grass(){}
}
