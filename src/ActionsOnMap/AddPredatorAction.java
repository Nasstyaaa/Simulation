package ActionsOnMap;

import Entities.Entity;
import Entities.Grass;
import Entities.Predator;
import Сomponents.MapWorld;

import java.util.ArrayList;

public class AddPredatorAction extends AddObjectsAction {
    public AddPredatorAction(MapWorld map){
        super.requiredQuantity = 0;
        super.type = Predator.class;
    }

    @Override
    ArrayList<? extends Entity> createObject(MapWorld map) {
        return new Predator().createObjects(map);
    }
}
