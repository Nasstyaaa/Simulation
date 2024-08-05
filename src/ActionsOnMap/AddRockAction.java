package ActionsOnMap;

import Entities.Entity;
import Entities.Grass;
import Entities.Rock;
import Сomponents.MapWorld;

import java.util.ArrayList;

public class AddRockAction extends AddObjectsAction {

    public AddRockAction(MapWorld map){
        super.requiredQuantity = 0;
        super.type = Rock.class;
    }

    @Override
    ArrayList<? extends Entity> createObject(MapWorld map) {
        return new Rock().createObjects(map);
    }
}
