package Actions;

import Entities.Entity;
import Сomponents.MapWorld;

import java.util.ArrayList;

public interface AddObjects {
    public ArrayList<? extends Entity> addObjectsOnMap(MapWorld map);
}
