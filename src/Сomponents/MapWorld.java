package Сomponents;

import Entities.Entity;

import java.util.*;

public class MapWorld {
    private Map<Coordinate, Entity> entityMap;
    private int lengthX;
    private int lengthY;

    public MapWorld(int lengthByX, int lengthByY) {
        entityMap = new HashMap<>();
        lengthX = lengthByX;
        lengthY = lengthByY;
    }

    public int getLengthX() {
        return lengthX;
    }

    public int getLengthY() {
        return lengthY;
    }

    public synchronized void removeEntity(Coordinate coordinate) {
        entityMap.remove(coordinate);
    }

    public synchronized void putEntity(Coordinate coordinates, Entity entity) {
        entityMap.put(coordinates, entity);
    }

    public synchronized Entity getEntity(Coordinate coordinate) {
        return entityMap.get(coordinate);
    }

    public boolean isCoordinateExist(Coordinate coordinate) {
        return entityMap.containsKey(coordinate);
    }

    public Collection<Entity> getAllEntities() {
        return Collections.unmodifiableCollection(entityMap.values());
    }

    public void add(ArrayList<? extends Entity> entitiesCollection) {
        for (Entity entity : entitiesCollection) {
            int locationX = 0;
            int locationY = 0;
            Coordinate coordinate = new Coordinate(locationX, locationY);
            while(isCoordinateExist(coordinate)){
                locationX = (int) (Math.random() * lengthX);
                locationY = (int) (Math.random() * lengthY);
                coordinate = new Coordinate(locationX, locationY);
            }
            entityMap.put(coordinate, entity);
        }
    }

    public synchronized Coordinate findCoordinate(Entity entity) {
        Set<Coordinate> coordinates = entityMap.keySet();
        for (Coordinate coordinate : coordinates) {
            Entity currentEntity = entityMap.get(coordinate);
            if (currentEntity != null && currentEntity.equals(entity)) {
                return coordinate;
            }
        }
        throw new NullPointerException("Ошибка...Обрабатывается животное, не существующее на карте");
    }
}
