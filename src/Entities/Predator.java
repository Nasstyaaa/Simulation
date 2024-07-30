package Entities;

import Simulation.MapWorld;

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
    public void makeMove(MapWorld map) {
    }

    @Override
    public ArrayList<Predator> createObjectOnMap(MapWorld map) {
        int sizeMap = (map.getLengthY() * map.getLengthX()) / 8;
        ArrayList<Predator> listOfPredator = new ArrayList<>();
        for (int i = 0; i < sizeMap; i++) {
            int speed = (int) (1 + Math.random() * 6);
            int numberOfHP = (int) (4 + Math.random() * 11);
            int attackPower = (int) (1 + Math.random() * 4);
            listOfPredator.add(new Predator(speed, numberOfHP, attackPower));
        }
        map.addObjectsOnMap(listOfPredator);
        return listOfPredator;
    }
}
