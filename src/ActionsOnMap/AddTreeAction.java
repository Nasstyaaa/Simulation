package ActionsOnMap;

import Entities.Entity;
import Entities.Tree;
import Сomponents.MapWorld;

import java.util.ArrayList;

public class AddTreeAction extends AddObjectsAction {
    @Override
    public synchronized void doAction(MapWorld map) {
        ArrayList<Entity> allEntities = new ArrayList<>(map.getMainCollectionOfLocation().values());
        int numberOfEntity = 0;
        for (Entity entity : allEntities) {
            if (entity instanceof Tree)
                numberOfEntity++;
        }
        if (numberOfEntity == 0) {
            map.addObjectsOnMap(addObjects(map));
        }
    }

    @Override
    ArrayList<? extends Entity> addObjects(MapWorld map) {
        Tree tree = new Tree();
        return tree.createObjects(map);
    }
}
