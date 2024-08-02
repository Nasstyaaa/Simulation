package ActionsOnMap;

import Entities.Entity;
import Entities.Grass;
import Сomponents.MapWorld;

import java.util.ArrayList;

public class AddGrassAction extends AddObjectsAction {
    @Override
    public synchronized void doAction(MapWorld map) {
        ArrayList<Entity> allEntities = new ArrayList<>(map.getMainCollectionOfLocation().values());
        int numberOfEntity = 0;
        for (Entity entity : allEntities) {
            if (entity instanceof Grass)
                numberOfEntity++;
        }
        if (numberOfEntity <= (map.getLengthY() * map.getLengthX()) / 20) {
            map.addObjectsOnMap(addObjects(map));
        }
    }

    @Override
    ArrayList<? extends Entity> addObjects(MapWorld map) {
        Grass grass = new Grass();
        return grass.createObjects(map);
    }
}
