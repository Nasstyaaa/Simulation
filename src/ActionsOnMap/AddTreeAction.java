package ActionsOnMap;

import Entities.Entity;
import Entities.Grass;
import Entities.Tree;
import Сomponents.MapWorld;

import java.util.ArrayList;

public class AddTreeAction extends AddObjectsAction {

    public AddTreeAction(MapWorld map){
        super.requiredQuantity = 0;
        super.type = Tree.class;
    }

    @Override
    ArrayList<? extends Entity> createObject(MapWorld map) {
        return new Tree().createObjects(map);
    }
}
