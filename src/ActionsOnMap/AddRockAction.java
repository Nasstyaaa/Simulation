package ActionsOnMap;

import Entities.Entity;
import Entities.Rock;
import Сomponents.MapWorld;

import java.util.ArrayList;

public class AddRockAction extends AddObjectsAction {
    @Override
    public synchronized void doAction(MapWorld map) {
        ArrayList<Entity> allEntities = new ArrayList<>(map.getMainCollectionOfLocation().values());
        int numberOfEntity = 0;
        for (Entity entity : allEntities) {
            if (entity instanceof Rock)
                numberOfEntity++;
        }
        if (numberOfEntity == 0) {
            map.addObjectsOnMap(new Rock().createObjects(map));
        }
    }
}
