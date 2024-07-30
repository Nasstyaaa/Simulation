package Entities;

import Simulation.MapWorld;

import java.util.ArrayList;

public class Herbivore extends Creature {

    public Herbivore() {
    }

    public Herbivore(int speed, int numberOfHP) {
        super(speed, numberOfHP);
    }
    public void makeMove(MapWorld map) {
//        FindGrass findGrass = new FindGrass();
//        Grass foundGrass = (Grass) findGrass.find(map, this);
//        if (foundGrass != null) {
//            int differenceInX = this.getLocationByX() - foundGrass.locationByX;
//            int differenceInY = this.getLocationByY() - foundGrass.locationByY;
//            if ((Math.abs(differenceInY) <= this.speed && differenceInX == 0) ||
//                    (Math.abs(differenceInX) <= this.speed && differenceInY == 0)) {
//                System.out.println("поели");
//                map.removeObjectsOnMap(this);
//                this.numberOfHP += 1;
//                this.locationByX = foundGrass.locationByX;
//                this.locationByY = foundGrass.locationByY;
//                map.removeObjectsOnMap(foundGrass);
//            } else {
//                Entity nextEntity = map.getMainCollectionOfLocation().get(this.locationByX).get(this.locationByY + 1);
//                if (differenceInX > differenceInY & nextEntity == null)  {
//                    map.removeObjectsOnMap(this);
//                    System.out.println("ходим по Y " + this.locationByY);
//                    System.out.println("скорость: " + this.speed);
//                    for (int i = 1; i <= this.speed; i++) {
//                        if (map.getMainCollectionOfLocation().get(this.locationByX).get(this.locationByY + i) == null) {
//                            if (this.locationByY >= map.getLengthY()) {
//                                System.out.println("оно больше размера");
//                                this.locationByY = 0;
//                            }
//                            this.locationByY++;
//                            System.out.println(this.locationByY);
//                        } else
//                            break;
//                    }
//                    System.out.println("Y" + this.locationByY);
//                } else {
//                    map.removeObjectsOnMap(this);
//                    System.out.println("ходим по X" + this.locationByX);
//                    System.out.println("скорость: " + this.speed);
//                    for (int i = 1; i <= this.speed; i++) {
//                        if (map.getMainCollectionOfLocation().get(this.locationByX + i).get(this.locationByY) == null) {
//                            this.locationByX++;
//                            if(this.locationByX >= map.getLengthX()) {
//                                System.out.println("оно больше размера");
//                                this.locationByX = 0;
//                            }
//                            System.out.println(this.locationByX);
//                        } else
//                            break;
//                    }
//                    System.out.println("X" + this.locationByX);
//                }
//            }
//            System.out.println(this.locationByX + " " + this.locationByY);
//        } else {
//            Grass grass = new Grass();
//            grass.createObjectOnMap(map);
//            makeMove(map);
//        }
    }


    @Override
    public ArrayList<Herbivore> createObjectOnMap(MapWorld map) {
        int sizeMap = (map.getLengthY() * map.getLengthX()) / 6;
        ArrayList<Herbivore> listOfHerbivore = new ArrayList<>();
        for (int i = 0; i < sizeMap; i++) {
            int speed = (int) (1 + Math.random() * 4);
            int numberOfHP = (int) (4 + Math.random() * 11);
            listOfHerbivore.add(new Herbivore(speed, numberOfHP));
        }
        map.addObjectsOnMap(listOfHerbivore);
        return listOfHerbivore;
    }

}
