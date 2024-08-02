package AdditionalActions;

import Entities.Entity;
import Сomponents.MapWorld;

import java.util.*;


public class FindObject{
    public static ArrayList<String> find(MapWorld map, Entity initialEntity, Class<? extends Entity> type) {
        ArrayList<ArrayList<String>> roads = new ArrayList<>();

        Map<String, Boolean> visitedEntity = new HashMap<>();
        for (int i = 0; i < map.getLengthX(); i++) {
            for (int j = 0; j < map.getLengthY(); j++) {
                visitedEntity.put(i + "," + j, false);
            }
        }


        String[] coordinatesEntity = map.findKey(initialEntity).split(",");
        if(coordinatesEntity.length == 0) {
            return null;
        }
        String locationX = coordinatesEntity[0];
        String locationY = coordinatesEntity[1];

        ArrayList<String> coordinatesList = new ArrayList<>();
        coordinatesList.add(locationX + "," + locationY);
        roads.add(coordinatesList);


        ArrayList<ArrayList<String>> newRoads = new ArrayList<>(roads);
        while (visitedEntity.containsValue(false)) {
            for (ArrayList<String> currentRoad : roads) {
                newRoads.clear();
                String[] currentCoordinates = currentRoad.get(currentRoad.size() - 1).split(",");
                String currentLocationX = currentCoordinates[0];
                String currentLocationY = currentCoordinates[1];

                int[][] coordinatesNeighbours = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                for (int[] coordinate : coordinatesNeighbours) {
                    String neighbourX = String.valueOf((Integer.parseInt(currentLocationX) + coordinate[0]));
                    String neighbourY = String.valueOf((Integer.parseInt(currentLocationY) + coordinate[1]));
                    if (Integer.parseInt(neighbourX) >= 0 && Integer.parseInt(neighbourY) >= 0 &&
                            Integer.parseInt(neighbourX) <= map.getLengthX() - 1 && Integer.parseInt(neighbourY) <= map.getLengthY() - 1) {
                        Entity currentEntity = map.getMainCollectionOfLocation().get(neighbourX + "," + neighbourY);
                        if (currentEntity != null && currentEntity.getClass().equals(type)) {
                            ArrayList<String> newRoad = new ArrayList<>(currentRoad);
                            newRoad.add(neighbourX + "," + neighbourY);
                            newRoad.remove(0);
                            return newRoad;
                        } else if (currentEntity == null && !visitedEntity.get(neighbourX + "," + neighbourY)) {
                            ArrayList<String> newRoad = new ArrayList<>(currentRoad);
                            newRoad.add(neighbourX + "," + neighbourY);
                            addIfNotExists(newRoads, newRoad);
                        }
                        visitedEntity.put(neighbourX + "," + neighbourY, true);
                    }
                }
            }
            if (newRoads.isEmpty())
                return null;
            roads.clear();
            roads.addAll(newRoads);
        }
        return null;
    }

    private static void addIfNotExists(ArrayList<ArrayList<String>> newRoads, ArrayList<String> newRoad) {
        for (ArrayList<String> existingItem : newRoads) {
            if (existingItem.equals(newRoad)) {
                return;
            }
        }
        newRoads.add(newRoad);
    }
}
