package Actions;

import Entities.Entity;
import Simulation.MapWorld;

import java.util.*;
import java.util.stream.Collectors;


public class FindObject {
    public void find(MapWorld map, Entity initialEntity, Class<? extends Entity> type) {
        ArrayList<ArrayList<String>> roads = new ArrayList<>();

        Map<String, Boolean> visitedEntity = new HashMap<>();
        for (int i = 0; i < map.getLengthX(); i++) {
            for (int j = 0; j < map.getLengthY(); j++) {
                visitedEntity.put(i + "," + j, false);
            }
        }


        String[] coordinatesEntity = map.findKey(initialEntity).split(",");
        String locationX = coordinatesEntity[0];
        String locationY = coordinatesEntity[1];


        ArrayList<String> coordinatesList = new ArrayList<>();
        coordinatesList.add(locationX + "," + locationY);
        System.out.println("координаты мыши: " + locationX + "," + locationY);
        roads.add(coordinatesList);


        while (visitedEntity.containsValue(false)) {
            for (ArrayList<String> currentRoad : roads) {
                String[] currentCoordinates = currentRoad.get(currentRoad.size() - 1).split(",");
                String currentLocationX = currentCoordinates[0];
                String currentLocationY = currentCoordinates[1];
                System.out.println("последние координаты: " + currentLocationX + "," + currentLocationY);

                int[][] coordinatesNeighbours = {{-1, 0}, {1, 0}, {0, -1}, {1, 0}};
                for (int[] coordinate : coordinatesNeighbours) {
                    String neighbourX = String.valueOf((Integer.parseInt(currentLocationX) + coordinate[0]));
                    String neighbourY = String.valueOf((Integer.parseInt(currentLocationY) + coordinate[1]));
                    if (Integer.parseInt(neighbourX) >= 0 && Integer.parseInt(neighbourY) >= 0) {
                        visitedEntity.put(neighbourX + "," + neighbourY, true);

                        Entity currentEntity = map.getMainCollectionOfLocation().get(neighbourX + "," + neighbourY);
                        if(currentEntity != null && currentEntity.getClass().equals(type)){
                            ArrayList<String> anotherRoad = new ArrayList<>(currentRoad);
                            anotherRoad.add(neighbourX + "," + neighbourY);
                            roads.add(anotherRoad);

                            System.out.println("Найдена нужная дорога из: " + roads);
                            break;
                        }
                        else if (currentEntity == null) {
                            ArrayList<String> anotherRoad = new ArrayList<>(currentRoad);
                            anotherRoad.add(neighbourX + "," + neighbourY);

                            roads.add(anotherRoad);
                            System.out.println("текущие дороги " + roads);
                        }
                    }
                }
                roads.remove(currentRoad);
            }
        }
    }
}
