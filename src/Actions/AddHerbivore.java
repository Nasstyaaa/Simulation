package Actions;

import Entities.Entity;
import Entities.Grass;
import Entities.Herbivore;
import Сomponents.MapWorld;

import java.util.ArrayList;

public class AddHerbivore {
    public synchronized ArrayList<? extends Entity> addObjectsOnMap(MapWorld map) {
        ArrayList<Herbivore> herbivoreArrayList = new ArrayList<>();
        ArrayList<Entity> allEntities = new ArrayList<>(map.getMainCollectionOfLocation().values());
        int numberOfEntity = 0;
        for (Entity entity : allEntities) {
            if (entity != null && entity.getClass().equals(Herbivore.class))
                numberOfEntity++;
        }
        if (numberOfEntity <= (map.getLengthY() * map.getLengthX()) / 15) {
            Herbivore herbivore = new Herbivore();
            herbivoreArrayList.addAll(herbivore.createObjects(map));
            map.addObjectsOnMap(herbivoreArrayList);
        }
        return herbivoreArrayList;
    };
}
