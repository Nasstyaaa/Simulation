package Actions;

import Entities.*;
import Сomponents.MapWorld;

import java.util.ArrayList;

public class PrepareSimulation {
    public static synchronized void prepare(MapWorld map, ArrayList<Entity> entities){
        map.addObjectsOnMap(entities);
    }
}
