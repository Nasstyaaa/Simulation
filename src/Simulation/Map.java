package Simulation;

import Entyties.Entity;

import java.util.ArrayList;
import java.util.Collections;

public class Map {
    ArrayList<ArrayList<Entity>> mainCollectionOfLocation;

    public ArrayList<ArrayList<Entity>> getMainCollectionOfLocation() {
        return mainCollectionOfLocation;
    }

    public Map(int lengthByX, int lengthByY) {
        mainCollectionOfLocation = new ArrayList<>(lengthByX);
        for(int i = 0; i < lengthByX; i++){
            mainCollectionOfLocation.add(new ArrayList<>(Collections.nCopies(lengthByY, null)));
        }
    }

// TODO добавить проверки
    public void addObjectsOnMap(ArrayList<Entity> entitiesCollection){
       for(Entity entity: entitiesCollection){
           int x = entity.getLocationByX();
           int y = entity.getLocationByY();
           mainCollectionOfLocation.get(x).set(y, entity);
       }
    }
}
