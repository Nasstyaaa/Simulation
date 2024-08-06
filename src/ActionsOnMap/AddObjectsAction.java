package ActionsOnMap;

import Entities.Entity;
import Сomponents.MapWorld;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class AddObjectsAction implements Action {

    protected Class<? extends Entity> type;
    protected int requiredQuantity;

    public synchronized void perfom(MapWorld map) {
        Collection<Entity> allEntities = map.getAllEntities();
        int numberOfEntity = 0;
        for (Entity entity : allEntities) {
            if (entity.getClass().equals(type))
                numberOfEntity++;
        }
        if (numberOfEntity <= requiredQuantity) {
            map.add(createObject(map));
        }
    }

    abstract ArrayList<? extends Entity> createObject(MapWorld map);
}
