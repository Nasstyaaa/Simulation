import Entities.*;
import Simulation.MapWorld;
import Simulation.Render;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        MapWorld map = new MapWorld(5, 5);

        Herbivore herbivore = new Herbivore();
        ArrayList<Herbivore> arrayOfHerbivore = herbivore.createObjectOnMap(map);

        Predator predator = new Predator();
        predator.createObjectOnMap(map);

        Grass grass = new Grass();
        grass.createObjectOnMap(map);

        Rock rock = new Rock();
        rock.createObjectOnMap(map);

        Tree tree = new Tree();
        tree.createObjectOnMap(map);

        Set<String> keys = map.getMainCollectionOfLocation().keySet();
        System.out.println("Keys: " + keys);

        for (String key : keys) {
            Entity entity = map.getMainCollectionOfLocation().get(key);
            if (entity != null) {
                System.out.println("Entity at " + key + ": " + entity.getClass());
            }
        }
    }
}