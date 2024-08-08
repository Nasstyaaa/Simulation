package Entities;

import AdditionalActions.FindObject;
import Сomponents.Coordinate;
import Сomponents.MapWorld;

import java.util.List;

public class Predator extends Creature {
    private int attackPower;

    public Predator(int speed, int hp, int attackPower) {
        super(speed, hp);
        this.attackPower = attackPower;
    }

    @Override
    public void makeMove(MapWorld map) {
        List<Coordinate> foundPath = FindObject.find(map, this, Herbivore.class);
        Coordinate originalPosition = map.findCoordinate(this);
        if (!foundPath.isEmpty()) {
            map.removeEntity(originalPosition);
            if (foundPath.size() == 1) {
                Herbivore foundHerbivore = (Herbivore) map.getEntity(foundPath.get(0));
                if (foundHerbivore.getHp() - attackPower <= 0) {
                    foundHerbivore.setHp(foundHerbivore.getHp() - attackPower);
                    map.putEntity(foundPath.get(0), this);
                } else {
                    map.putEntity(originalPosition, this);
                    foundHerbivore.setHp(foundHerbivore.getHp() - attackPower);
                }
            } else if (foundPath.size() <= speed) {
                map.putEntity(foundPath.get(foundPath.size() - 2), this);
            } else {
                map.putEntity(foundPath.get(this.speed - 1), this);
            }
        }
    }

}
