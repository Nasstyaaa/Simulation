package AdditionalActions;

import Entities.Entity;
import Сomponents.Coordinate;
import Сomponents.MapWorld;

import java.util.*;


public class FindObject {
    public static List<Coordinate> find(MapWorld map, Entity initialEntity, Class<? extends Entity> type) {
        ArrayDeque<List<Coordinate>> roads = new ArrayDeque<>();
        ArrayList<Coordinate> visitedCoordinates = new ArrayList<>();

        roads.add(List.of(map.findCoordinate(initialEntity)));

        while (!roads.isEmpty()) {
            List<Coordinate> currentRoad = roads.pop();
            Coordinate lastCoordinate = currentRoad.get(currentRoad.size() - 1);

            for (Coordinate neighboringCoordinate : findNeighbourCoordinates(lastCoordinate, map)) {
                Entity currentEntity = map.getEntity(neighboringCoordinate);
                if (currentEntity == null) {
                    if (!visitedCoordinates.contains(neighboringCoordinate)) {
                        visitedCoordinates.add(neighboringCoordinate);
                        addNewRoad(roads, currentRoad, neighboringCoordinate);
                    }
                } else if (currentEntity.getClass().equals(type)) {
                    return getFoundRoad(currentRoad, neighboringCoordinate);
                }
            }
            if (roads.isEmpty()){
                return new ArrayList<>();
            }
        }
        throw new NullPointerException("Ошибка...Путь не найден");
    }


    private static List<Coordinate> findNeighbourCoordinates(Coordinate lastCoordinate, MapWorld map) {
        List<Coordinate> neighboringCoordinates = new ArrayList<>();
        int[][] coordinatesNeighbours = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] coordinate : coordinatesNeighbours) {
            int neighbourX = lastCoordinate.getPointX() + coordinate[0];
            int neighbourY = lastCoordinate.getPointY() + coordinate[1];

            if (neighbourX >= 0 && neighbourX <= map.getLengthX() - 1
                    && neighbourY >= 0 && neighbourY <= map.getLengthY() - 1) {
                neighboringCoordinates.add(new Coordinate(neighbourX, neighbourY));
            }
        }
        return neighboringCoordinates;
    }


    private static List<Coordinate> getFoundRoad(List<Coordinate> currentRoad, Coordinate neighboringCoordinate) {
        List<Coordinate> foundPath = new ArrayList<>(currentRoad);
        foundPath.add(neighboringCoordinate);
        foundPath.remove(0);
        return foundPath;
    }

    private static void addNewRoad(ArrayDeque<List<Coordinate>> roads, List<Coordinate> currentRoad, Coordinate neighboringCoordinate) {
        List<Coordinate> foundRoad = new ArrayList<>(currentRoad);
        foundRoad.add(neighboringCoordinate);
        roads.add(foundRoad);
    }
}
