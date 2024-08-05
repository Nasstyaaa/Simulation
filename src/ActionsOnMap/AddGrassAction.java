package ActionsOnMap;

import Entities.Entity;
import Entities.Grass;
import Сomponents.MapWorld;

import java.util.ArrayList;

public class AddGrassAction extends AddObjectsAction {

    public AddGrassAction(MapWorld map){
        super.requiredQuantity = (map.getLengthY() * map.getLengthX()) / 20;
        super.type = Grass.class;
    }

    @Override
    ArrayList<? extends Entity> createObject(MapWorld map) {
        return new Grass().createObjects(map);
    }
}
