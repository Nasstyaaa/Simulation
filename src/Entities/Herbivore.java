package Entities;

import Actions.FindGrass;
import Actions.FindHerbivore;
import Simulation.Map;

import java.util.ArrayList;

public class Herbivore extends Creature {

    public Herbivore() {
    }

    public Herbivore(int locationOfX, int locationOfY, int speed, int numberOfHP) {
        super(locationOfX, locationOfY, speed, numberOfHP);
    }

    public void makeMove(Map map) {
        FindGrass findGrass = new FindGrass();
        Grass foundGrass = (Grass) findGrass.find(map, this);
        if(foundGrass != null){
            int differenceInX = this.getLocationByX() - foundGrass.locationByX;
            int differenceInY = this.getLocationByY() - foundGrass.locationByY;
            if(differenceInX == 1 || differenceInY == 1){
                map.removeObjectsOnMap(foundGrass);
                this.numberOfHP += 1;
            }
            else{
                if(differenceInX > differenceInY)
                    this.locationByY += this.speed;
                else
                    this.locationByX += this.speed;
            }
        }
        else{
            //добавить травы метод
            makeMove(map);
        }
    }


    @Override
    public void createObjectOnMap(Map map) {
        int sizeMap = (map.getLengthY() * map.getLengthX()) / 6;
        ArrayList<Entity> listOfHerbivore = new ArrayList<>();
        for (int i = 0; i < sizeMap; i++){
            int locationX = (int) (Math.random() * (map.getLengthX()));
            int locationY = (int) (Math.random() * (map.getLengthY()));
            int speed = (int) (1 + Math.random() * 6);
            int numberOfHP = (int) (4 + Math.random() * 11);
            listOfHerbivore.add(new Herbivore(locationX, locationY, speed, numberOfHP));
        }
        map.addObjectsOnMap(listOfHerbivore);
    }

}
