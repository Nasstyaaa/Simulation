package ActionsOnMap;

import Entities.Entity;
import Entities.Predator;
import Сomponents.MapWorld;

import java.util.ArrayList;

public class AddPredatorAction extends AddObjectsAction {
    @Override
    public synchronized void doAction(MapWorld map) {
        ArrayList<Entity> allEntities = new ArrayList<>(map.getMainCollectionOfLocation().values());
        int numberOfEntity = 0;
        for (Entity entity : allEntities) {
            if (entity instanceof Predator)
                numberOfEntity++;
        }
        if (numberOfEntity == 0) {
            map.addObjectsOnMap(addObjects(map));
        }
    }

    @Override
    ArrayList<? extends Entity> addObjects(MapWorld map) {
        Predator predator = new Predator();
        return predator.createObjects(map);
    }
}
