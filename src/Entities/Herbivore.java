package Entities;

import Simulation.Map;

import java.util.ArrayList;

public class Herbivore extends Creature {

    public Herbivore() {
    }

    public Herbivore(int locationOfX, int locationOfY, int speed, int numberOfHP) {
        super(locationOfX, locationOfY, speed, numberOfHP);
    }

    @Override
    public void makeMove() {
    }

    @Override
    public void createObjectOnMap(Map map) {
        int sizeMap = (map.getLengthY() * map.getLengthX()) / 6;
        ArrayList<Entity> listOfHerbivore = new ArrayList<>();
        for (int i = 0; i < sizeMap; i++){
            int locationX = (int) (Math.random() * (map.getLengthX()));
            int locationY = (int) (Math.random() * (map.getLengthY()));
            int speed = (int) (1 + Math.random() * 6);
            int numberOfHP = (int) (4 + Math.random() * 11);
            listOfHerbivore.add(new Herbivore(locationX, locationY, speed, numberOfHP));
        }
        map.addObjectsOnMap(listOfHerbivore);
    }
}
