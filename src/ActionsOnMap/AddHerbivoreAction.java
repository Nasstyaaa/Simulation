package ActionsOnMap;

import Entities.Entity;
import Entities.Herbivore;
import Сomponents.MapWorld;

import java.util.ArrayList;

public class AddHerbivoreAction extends AddObjectsAction {

    @Override
    public synchronized void doAction(MapWorld map) {
        ArrayList<Entity> allEntities = new ArrayList<>(map.getMainCollectionOfLocation().values());
        int numberOfEntity = 0;
        for (Entity entity : allEntities) {
            if (entity instanceof Herbivore)
                numberOfEntity++;
        }
        if (numberOfEntity <= (map.getLengthY() * map.getLengthX()) / 15) {
            map.addObjectsOnMap(addObjects(map));
        }
    }

    @Override
    ArrayList<? extends Entity> addObjects(MapWorld map) {
        Herbivore herbivore = new Herbivore();
        return herbivore.createObjects(map);
    }
}
