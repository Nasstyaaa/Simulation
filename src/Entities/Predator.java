package Entities;

import AdditionalActions.FindObject;
import Сomponents.MapWorld;

import java.util.ArrayList;

public class Predator extends Creature {
    protected int attackPower;

    public int getAttackPower() {
        return attackPower;
    }

    public Predator() {
    }

    public Predator(int speed, int numberOfHP, int attackPower) {
        super(speed, numberOfHP);
        this.attackPower = attackPower;
    }

    @Override
    public synchronized void makeMove(MapWorld map) {
        ArrayList<String> foundPath = FindObject.find(map, this, Herbivore.class);
        String originalPositionKey = map.findKey(this);
        if (foundPath != null && originalPositionKey != null) {
            map.getMainCollectionOfLocation().remove(originalPositionKey);
            if (foundPath.size() == 1) {
                Herbivore foundHerbivore = (Herbivore) map.getMainCollectionOfLocation().get(foundPath.get(0));
                if (foundHerbivore.getNumberOfHP() - attackPower <= 0)
                    map.getMainCollectionOfLocation().put(foundPath.get(0), this);
                else {
                    map.getMainCollectionOfLocation().put(originalPositionKey, this);
                    foundHerbivore.setNumberOfHP(foundHerbivore.getNumberOfHP() - attackPower);
                }

            } else if (foundPath.size() <= speed)
                map.getMainCollectionOfLocation().put(foundPath.get(foundPath.size() - 2), this);
            else
                map.getMainCollectionOfLocation().put(foundPath.get(this.speed - 1), this);
        }
    }

    @Override
    public ArrayList<Predator> createObjects(MapWorld map) {
        int sizeMap = (map.getLengthY() * map.getLengthX()) / 8;
        ArrayList<Predator> listOfPredator = new ArrayList<>();
        for (int i = 0; i < sizeMap; i++) {
            int speed = (int) (1 + Math.random() * 4);
            int numberOfHP = (int) (4 + Math.random() * 11);
            int attackPower = (int) (1 + Math.random() * 4);
            listOfPredator.add(new Predator(speed, numberOfHP, attackPower));
        }
        return listOfPredator;
    }
}
