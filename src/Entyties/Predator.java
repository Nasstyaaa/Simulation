package Entyties;

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
}
