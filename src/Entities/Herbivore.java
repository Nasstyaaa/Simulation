package Entities;

import AdditionalActions.FindObject;
import Сomponents.MapWorld;

import java.util.ArrayList;

public class Herbivore extends Creature {

    public Herbivore() {
    }

    public Herbivore(int speed, int numberOfHP) {
        super(speed, numberOfHP);
    }

    public synchronized void makeMove(MapWorld map) {
        ArrayList<String> foundPath = FindObject.find(map, this, Grass.class);
        if (foundPath != null) {
            map.getMainCollectionOfLocation().remove(map.findKey(this));
            if (foundPath.size() <= speed) {
                map.getMainCollectionOfLocation().put(foundPath.get(foundPath.size() - 1), this);
            }
            else {
                map.getMainCollectionOfLocation().put(foundPath.get(speed - 1), this);
            }
        }
    }


    @Override
    public ArrayList<Herbivore> createObjects(MapWorld map) {
        int sizeMap = (map.getLengthY() * map.getLengthX()) / 6;
        ArrayList<Herbivore> listOfHerbivore = new ArrayList<>();
        for (int i = 0; i < sizeMap; i++) {
            int speed = (int) (1 + Math.random() * 3);
            int numberOfHP = (int) (4 + Math.random() * 11);
            listOfHerbivore.add(new Herbivore(speed, numberOfHP));
        }
        return listOfHerbivore;
    }
}
