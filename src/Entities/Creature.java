package Entities;

import Сomponents.MapWorld;

public abstract class Creature extends Entity {
    protected int speed;
    protected int hp;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Creature(int speed, int numberOfHP){
        this.hp = numberOfHP;
        this.speed = speed;
    }

    public abstract void makeMove(MapWorld map);

    public boolean isDead(){
        return this.hp <= 0;
    }
}
