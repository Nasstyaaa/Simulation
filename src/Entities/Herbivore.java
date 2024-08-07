package Entities;

import AdditionalActions.FindObject;
import Сomponents.Coordinate;
import Сomponents.MapWorld;

import java.util.List;

public class Herbivore extends Creature {
    public Herbivore(int speed, int numberOfHP) {
        super(speed, numberOfHP);
    }

    @Override
    public synchronized void makeMove(MapWorld map) {
        List<Coordinate> foundPath = FindObject.find(map, this, Grass.class);
        if (!foundPath.isEmpty()) {
            map.removeEntity(map.findCoordinate(this));
            if (foundPath.size() <= speed) {
                map.putEntity(foundPath.get(foundPath.size() - 1), this);
            } else {
                map.putEntity(foundPath.get(speed - 1), this);
            }
        }
    }
}
