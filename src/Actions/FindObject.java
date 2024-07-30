//package Actions;
//
//import Entities.Entity;
//import Simulation.MapWorld;
//
//import java.util.ArrayList;
//
//public class FindObject {
//    public Entity find(MapWorld map, Entity entity, Class<? extends Entity> type) {
//        ArrayList<Entity> queueEntities = new ArrayList<>();
//        int indexOfEntity = 0;
//        queueEntities.add(entity);
//        while (indexOfEntity != map.getLengthX() * map.getLengthY()) {
//            Entity checkedEntity = queueEntities.get(indexOfEntity);
//            if (checkedEntity.getClass().equals(type)) {
//                return checkedEntity;
//            } else {
//                int locationX = checkedEntity.getLocationByX();
//                int locationY = checkedEntity.getLocationByY();
//                int[][] coordinates = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//                for (int[] coordinate : coordinates) {
//                    int newX = locationX + coordinate[0];
//                    int newY = locationY + coordinate[1];
//                    if ((newX < map.getLengthX() && newX >= 0) && (newY >= 0 && newY < map.getLengthY())) {
//                        Entity neighbor = map.getMainCollectionOfLocation().get(newX).get(newY);
//                        if (neighbor != null && !queueEntities.contains(neighbor)) {
//                            queueEntities.add(neighbor);
//                            indexOfEntity++;
//                        }
//                    }
//                }
//            }
//        }
//        return null;
//    }
//}
