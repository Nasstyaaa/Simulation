package Entities;

import Simulation.Map;

import java.util.ArrayList;

public class Predator extends Creature{
    protected int attackPower;

    public int getAttackPower() {
        return attackPower;
    }

    public Predator(int locationOfX, int locationOfY, int speed, int numberOfHP, int attackPower) {
        super(locationOfX, locationOfY, speed, numberOfHP);
        this.attackPower = attackPower;
    }

    @Override
    public void makeMove() {
    }

    public Predator() {
    }

    @Override
    public void createObjectOnMap(Map map) {
        int sizeMap = (map.getLengthY() * map.getLengthX()) / 8;
        ArrayList<Entity> listOfPredator = new ArrayList<>();
        for (int i = 0; i < sizeMap; i++){
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
