package Actions;

import Entities.Entity;
import Entities.Grass;
import Сomponents.MapWorld;

import java.util.ArrayList;

public class AddGrass implements AddObjects{
    public synchronized ArrayList<? extends Entity> addObjectsOnMap(MapWorld map) {
        ArrayList<Grass> grassArrayList = new ArrayList<>();
        ArrayList<Entity> allEntities = new ArrayList<>(map.getMainCollectionOfLocation().values());
        int numberOfEntity = 0;
        for (Entity entity : allEntities) {
            if (entity != null && entity.getClass().equals(Grass.class))
                numberOfEntity++;
        }
        if (numberOfEntity <= (map.getLengthY() * map.getLengthX()) / 20) {
            Grass grass = new Grass();
            grassArrayList.addAll(grass.createObjects(map));
            map.addObjectsOnMap(grassArrayList);
        }
        return grassArrayList;
    };
}
