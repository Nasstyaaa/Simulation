package Actions;

import Entities.Entity;
import Entities.Herbivore;
import Simulation.Map;

import java.util.ArrayList;
import java.util.List;

public class FindHerbivore implements FindObject {
    @Override
    public Entity find(Map map, Entity entity) {
        ArrayList<Entity> queueEntities = new ArrayList<>();
        int indexOfEntity = 0;
        queueEntities.add(entity);
        while (indexOfEntity != map.getLengthX() * map.getLengthY()) {
            Entity checkedEntity = queueEntities.get(indexOfEntity);
            if (checkedEntity instanceof Herbivore) {
                return checkedEntity;
            } else {
                int locationX = checkedEntity.getLocationByX();
                int locationY = checkedEntity.getLocationByY();
                int[][] coordinates = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                for (int[] coordinate : coordinates) {
                    int newX = locationX + coordinate[0];
                    int newY = locationY + coordinate[1];
                    if ((newX < map.getLengthX() && newX >= 0) && (newY >= 0 && newY < map.getLengthY())) {
                        Entity neighbor = map.getMainCollectionOfLocation().get(newX).get(newY);
                        if (neighbor != null && !queueEntities.contains(neighbor)) {
                            queueEntities.add(neighbor);
                            indexOfEntity++;
                        }
                    }
                }
            }
        }
        return null;
    }
}
