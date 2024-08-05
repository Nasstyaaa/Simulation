package Сomponents;

import Entities.Entity;

import java.util.*;

public class MapWorld {
    private static Map<String, Entity> mainCollectionOfLocation;
    private static int lengthX;
    private static int lengthY;

    public MapWorld(int lengthByX, int lengthByY) {
        mainCollectionOfLocation = new HashMap<>();
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

    public synchronized String findKey(Entity entity) {
        Set<String> keys = mainCollectionOfLocation.keySet();
        for (String key : keys) {
            Entity currentEntity = mainCollectionOfLocation.get(key);
            if (currentEntity != null && currentEntity.equals(entity)) {
                return key;
            }
        }
        return null;
    }
}
