package ActionsOnMap;

import Entities.Entity;
import Сomponents.MapWorld;

import java.util.ArrayList;

public abstract class AddObjectsAction implements Action {

    protected Class<? extends Entity> type;
    protected int requiredQuantity;

    public synchronized void doAction(MapWorld map) {
        ArrayList<Entity> allEntities = new ArrayList<>(map.getMainCollectionOfLocation().values());
        int numberOfEntity = 0;
        for (Entity entity : allEntities) {
            if (entity.getClass().equals(type))
                numberOfEntity++;
        }
        if (numberOfEntity <= requiredQuantity) {
            map.addObjectsOnMap(createObject(map));
        }
    }

    abstract ArrayList<? extends Entity> createObject(MapWorld map);
}
