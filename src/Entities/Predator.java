package Entities;

import AdditionalActions.FindObject;
import Сomponents.Coordinate;
import Сomponents.MapWorld;

import java.util.ArrayList;
import java.util.List;

public class Predator extends Creature {
    private int attackPower;

    public Predator(int speed, int numberOfHP, int attackPower) {
        super(speed, numberOfHP);
        this.attackPower = attackPower;
    }

    @Override
    public synchronized void makeMove(MapWorld map) {
        List<Coordinate> foundPath = FindObject.find(map, this, Herbivore.class);
        Coordinate originalPosition = map.findCoordinate(this);
        if (!foundPath.isEmpty()) {
            map.removeEntity(originalPosition);
            if (foundPath.size() == 1) {
                Herbivore foundHerbivore = (Herbivore) map.getEntity(foundPath.get(0));
                if (foundHerbivore.getNumberOfHP() - attackPower <= 0) {
                    foundHerbivore.setNumberOfHP(foundHerbivore.getNumberOfHP() - attackPower);
                    map.putEntity(foundPath.get(0), this);
                } else {
                    map.putEntity(originalPosition, this);
                    foundHerbivore.setNumberOfHP(foundHerbivore.getNumberOfHP() - attackPower);
                }
            } else if (foundPath.size() <= speed) {
                map.putEntity(foundPath.get(foundPath.size() - 2), this);
            } else {
                map.putEntity(foundPath.get(this.speed - 1), this);
            }
        }
    }

}
