package Entyties;

public class Predator extends Creature{
    protected int attackPower;

    public int getAttackPower() {
        return attackPower;
    }

    public Predator(int speed, int numberOfHP, int attackPower) {
        super(speed, numberOfHP);
        this.attackPower = attackPower;
    }

    @Override
    public void makeMove() {
    }
}
