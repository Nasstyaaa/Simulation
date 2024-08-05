package ActionsOnMap;

import Entities.Entity;
import Entities.Grass;
import Entities.Herbivore;
import Сomponents.MapWorld;

import java.util.ArrayList;

public class AddHerbivoreAction extends AddObjectsAction {

    public AddHerbivoreAction(MapWorld map){
        super.requiredQuantity = (map.getLengthY() * map.getLengthX()) / 15;
        super.type = Herbivore.class;
    }

    @Override
    ArrayList<? extends Entity> createObject(MapWorld map) {
        return new Herbivore().createObjects(map);
    }
}
