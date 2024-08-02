package ActionsOnMap;

import Entities.Entity;
import Сomponents.MapWorld;

import java.util.ArrayList;

public abstract class AddObjectsAction implements Action{
    abstract ArrayList<? extends Entity> addObjects(MapWorld map);
}
