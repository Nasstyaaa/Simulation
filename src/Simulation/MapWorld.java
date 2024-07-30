package Simulation;

import Entities.Entity;

import java.util.*;

public class MapWorld {
    private Map<String, Entity> mainCollectionOfLocation;
    private int lengthX;
    private int lengthY;

    public MapWorld(int lengthByX, int lengthByY) {
        mainCollectionOfLocation = new HashMap<>();
        for (int i = 0; i < lengthByX; i++) {
            for (int j = 0; j < lengthByY; j++) {
                mainCollectionOfLocation.put(i + "," + j, null);
            }
        }
        lengthX = lengthByX;
        lengthY = lengthByY;
    }

    public int getLengthX() {
        return lengthX;
    }

    public int getLengthY() {
        return lengthY;
    }

    public Map<String, Entity> getMainCollectionOfLocation() {
        return mainCollectionOfLocation;
    }

    public void addObjectsOnMap(ArrayList<? extends Entity> entitiesCollection) {
        for (Entity entity : entitiesCollection) {
            int locationX = 0;
            int locationY = 0;
            while(mainCollectionOfLocation.get(locationX + "," + locationY) != null){
                locationX = (int) (Math.random() * lengthX);
                locationY = (int) (Math.random() * lengthY);
            }
            mainCollectionOfLocation.put(locationX + "," + locationY, entity);
        }
    }

//    public void removeObjectsOnMap(Entity entity) {
//        if (entity != null)
//            mainCollectionOfLocation.get(entity.getLocationByX()).set(entity.getLocationByY(), null);
//    }
//
//    public void updateMap(List<? extends Entity> updateEntity) {
//        for (Entity entity : updateEntity) {
//            int locationX = entity.getLocationByX();
//            int locationY = entity.getLocationByY();
//            mainCollectionOfLocation.get(locationX).set(locationY, entity);
//        }
//    }
}
