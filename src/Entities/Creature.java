package Entities;

import Сomponents.MapWorld;

public abstract class Creature extends Entity {
    protected int speed;
    protected int numberOfHP;

    public int getNumberOfHP() {
        return numberOfHP;
    }

    public void setNumberOfHP(int numberOfHP) {
        this.numberOfHP = numberOfHP;
    }

    public Creature(int speed, int numberOfHP){
        this.numberOfHP = numberOfHP;
        this.speed = speed;
    }

    public abstract void makeMove(MapWorld map);

    public boolean isDead(){
        return this.numberOfHP <= 0;
    }
}
