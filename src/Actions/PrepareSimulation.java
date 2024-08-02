package Actions;

import Entities.*;
import Сomponents.MapWorld;

import java.util.ArrayList;

public class PrepareSimulation {
    public static void prepare(MapWorld map, ArrayList<Entity> entities){
        map.addObjectsOnMap(entities);
    }
}
