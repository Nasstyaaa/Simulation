package Entities;

import Simulation.MapWorld;

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

    public Creature(int speed, int numberOfHP){
        this.numberOfHP = numberOfHP;
        this.speed = speed;
    }

    public abstract void makeMove(MapWorld map);
}
