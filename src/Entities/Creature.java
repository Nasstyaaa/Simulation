package Entities;

import Simulation.Map;

public abstract class Creature extends Entity {
    protected int speed;
    protected int numberOfHP;

    public int getSpeed() {
        return speed;
    }

    public int getNumberOfHP() {
        return numberOfHP;
    }

    public void setNumberOfHP(int numberOfHP) {
        this.numberOfHP = numberOfHP;
    }

    public Creature() {
    }

    public Creature(int locationOfX, int locationOfY, int speed, int numberOfHP){
        super(locationOfX, locationOfY);
        this.numberOfHP = numberOfHP;
        this.speed = speed;
    }

    public abstract void makeMove(Map map);
}
