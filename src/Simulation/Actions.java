package Simulation;

import Entyties.*;

import java.util.ArrayList;

public class Actions {
    private Herbivore createHerbivore(Map map) {
        int locationX = (int) (Math.random() * (map.getLengthX()));
        int locationY = (int) (Math.random() * (map.getLengthY()));
        int speed = (int) (1 + Math.random() * 6);
        int numberOfHP = (int) (4 + Math.random() * 11);
        return (new Herbivore(locationX, locationY, speed, numberOfHP));
    }

    private Predator createPredator(Map map) {
        int locationX = (int) (Math.random() * (map.getLengthX()));
        int locationY = (int) (Math.random() * (map.getLengthY()));
        int speed = (int) (1 + Math.random() * 6);
        int numberOfHP = (int) (4 + Math.random() * 11);
        int attackPower = (int) (1 + Math.random() * 4);
        return (new Predator(locationX, locationY, speed, numberOfHP, attackPower));
    }

    private Grass createGrass(Map map) {
        int locationX = (int) (Math.random() * (map.getLengthX()));
        int locationY = (int) (Math.random() * (map.getLengthY()));
        return (new Grass(locationX, locationY));
    }

    public void initMap(Map map) {
        int sizeMap = map.getLengthY() * map.getLengthX();
        int numberOfHerbivore = sizeMap / 6;
        int numberOfPredator = sizeMap / 8;
        int numberOfGrass = sizeMap / 7;
        ArrayList<Entity> entities = new ArrayList<>();


        for (int i = 0; i < numberOfHerbivore; i++) {
            entities.add(createHerbivore(map));
        }

        for (int i = 0; i < numberOfPredator; i++) {
            entities.add(createPredator(map));
        }

        for (int i = 0; i < numberOfGrass; i++) {
            entities.add(createGrass(map));
        }

        for (int i = 0; i < (sizeMap / 10); i++) {
            int locationXRock = (int) (Math.random() * (map.getLengthX()));
            int locationYRock = (int) (Math.random() * (map.getLengthY()));
            entities.add(new Rock(locationXRock, locationYRock));

            int locationXTree = (int) (Math.random() * (map.getLengthX()));
            int locationYTree = (int) (Math.random() * (map.getLengthY()));
            entities.add(new Tree(locationXTree, locationYTree));
        }
        map.addObjectsOnMap(entities);
    }
}
