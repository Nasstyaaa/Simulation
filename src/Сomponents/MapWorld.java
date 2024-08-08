package Сomponents;

import Entities.Entity;

import java.util.*;

public class MapWorld {
    private Map<Coordinate, Entity> entityMap;
    private int width;
    private int height;

    public MapWorld(int lengthByX, int lengthByY) {
        entityMap = new HashMap<>();
        width = lengthByX;
        height = lengthByY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void removeEntity(Coordinate coordinate) {
        entityMap.remove(coordinate);
    }

    public void putEntity(Coordinate coordinates, Entity entity) {
        entityMap.put(coordinates, entity);
    }

    public Entity getEntity(Coordinate coordinate) {
        return entityMap.get(coordinate);
    }

    public boolean isCoordinateExist(Coordinate coordinate) {
        return entityMap.containsKey(coordinate);
    }

    public Collection<Entity> getAllEntities() {
        return Collections.unmodifiableCollection(entityMap.values());
    }

    public void add(Entity entity) {
        Random random = new Random();
        Coordinate coordinate;
        do {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            coordinate = new Coordinate(x, y);
        }
        while (isCoordinateExist(coordinate));
        entityMap.put(coordinate, entity);
    }

    public Coordinate findCoordinate(Entity entity) {
        Set<Coordinate> coordinates = entityMap.keySet();
        for (Coordinate coordinate : coordinates) {
            Entity currentEntity = entityMap.get(coordinate);
            if (currentEntity != null && currentEntity.equals(entity)) {
                return coordinate;
            }
        }
        throw new NullPointerException("Error...an animal that does not exist on the map is being processed");
    }
}
