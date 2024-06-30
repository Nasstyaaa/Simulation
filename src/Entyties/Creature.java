package Entyties;

public abstract class Creature extends Entity {
    protected int speed;
    protected int numberOfHP;

    public int getSpeed() {
        return speed;
    }

    public int getNumberOfHP() {
        return numberOfHP;
    }

    public Creature(int speed, int numberOfHP){
        this.numberOfHP = numberOfHP;
        this.speed = speed;
    }

    public abstract void makeMove();
}
