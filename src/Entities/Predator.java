package Entities;

import Actions.FindGrass;
import Actions.FindHerbivore;
import Simulation.Map;

import java.util.ArrayList;

public class Predator extends Creature {
    protected int attackPower;

    public int getAttackPower() {
        return attackPower;
    }

    public Predator() {
    }

    public Predator(int locationOfX, int locationOfY, int speed, int numberOfHP, int attackPower) {
        super(locationOfX, locationOfY, speed, numberOfHP);
        this.attackPower = attackPower;
    }

    @Override
    public void makeMove(Map map) {
        FindHerbivore findHerbivore = new FindHerbivore();
        Herbivore foundHerbivore = (Herbivore) findHerbivore.find(map, this);
        if (foundHerbivore != null) {
            int differenceInX = this.getLocationByX() - foundHerbivore.locationByX;
            int differenceInY = this.getLocationByY() - foundHerbivore.locationByY;
            if (differenceInX == 1 || differenceInY == 1) {
                foundHerbivore.setNumberOfHP(foundHerbivore.getNumberOfHP() - this.attackPower);
                if (foundHerbivore.getNumberOfHP() <= 0) {
                    map.removeObjectsOnMap(foundHerbivore);
                    this.numberOfHP += 1;
                }
            } else {
                if (differenceInX > differenceInY)
                    this.locationByY += this.speed;
                else
                    this.locationByX += this.speed;
            }
        } else {
            //добавить травы метод
            makeMove(map);
        }
    }

    @Override
    public void createObjectOnMap(Map map) {
        int sizeMap = (map.getLengthY() * map.getLengthX()) / 8;
        ArrayList<Entity> listOfPredator = new ArrayList<>();
        for (int i = 0; i < sizeMap; i++) {
            int locationX = (int) (Math.random() * (map.getLengthX()));
            int locationY = (int) (Math.random() * (map.getLengthY()));
            int speed = (int) (1 + Math.random() * 6);
            int numberOfHP = (int) (4 + Math.random() * 11);
            int attackPower = (int) (1 + Math.random() * 4);
            listOfPredator.add(new Predator(locationX, locationY, speed, numberOfHP, attackPower));
        }
        map.addObjectsOnMap(listOfPredator);
    }
}
