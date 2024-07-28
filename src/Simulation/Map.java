package Simulation;

import Entities.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Map {
    private ArrayList<ArrayList<Entity>> mainCollectionOfLocation;
    private int lengthX;
    private int lengthY;

    public ArrayList<ArrayList<Entity>> getMainCollectionOfLocation() {
        return mainCollectionOfLocation;
    }

    public int getLengthX() {
        return lengthX;
    }

    public int getLengthY() {
        return lengthY;
    }

    public Map(int lengthByX, int lengthByY) {
        mainCollectionOfLocation = new ArrayList<>(lengthByX);
        for (int i = 0; i < lengthByX; i++) {
            mainCollectionOfLocation.add(new ArrayList<>(Collections.nCopies(lengthByY, null)));
        }
        lengthX = lengthByX;
        lengthY = lengthByY;
    }

    public void addObjectsOnMap(ArrayList<Entity> entitiesCollection) {
        for (Entity entity : entitiesCollection) {
            int x = entity.getLocationByX();
            int y = entity.getLocationByY();
            if (mainCollectionOfLocation.get(x).get(y) == null) {
                mainCollectionOfLocation.get(x).set(y, entity);
            } else {
                while (mainCollectionOfLocation.get(x).get(y) != null) {
                    x = (int) (Math.random() * (lengthX));
                    y = (int) (Math.random() * (lengthY));
                }
                mainCollectionOfLocation.get(x).set(y, entity);
            }
        }
    }

//    public ArrayList<Entity> findNeighboringObjects(Entity entity) {
//        ArrayList<Entity> listOfNeighbors = new ArrayList<>();
//        int locationX = entity.getLocationByX();
//        int locationY = entity.getLocationByY();
//        int[][] coordinates = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//        for (int[] coordinate : coordinates) {
//            int newX = locationX + coordinate[0];
//            int newY = locationY + coordinate[1];
//            if ((newX < lengthX && newX >= 0) && (newY >=0 && newY < lengthY)) {
//                Entity neighbor = mainCollectionOfLocation.get(newX).get(newY);
//                if (neighbor != null)
//                    listOfNeighbors.add(neighbor);
//            }
//        }
//        return listOfNeighbors;
//    }
}
