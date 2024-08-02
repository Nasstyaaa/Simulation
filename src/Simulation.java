import Actions.PrepareSimulation;
import Entities.*;
import Сomponents.MapWorld;
import Сomponents.Render;

import java.util.ArrayList;


public class Simulation {
    public static void main(String[] args) {
        MapWorld map = new MapWorld(10, 10);

        Herbivore herbivore = new Herbivore();
        Predator predator = new Predator();
        Grass grass = new Grass();
        Rock rock = new Rock();
        Tree tree = new Tree();

        ArrayList<Entity> entities = new ArrayList<>(herbivore.createObjects(map));
        entities.addAll(predator.createObjects(map));
        entities.addAll(grass.createObjects(map));
        entities.addAll(rock.createObjects(map));
        entities.addAll(tree.createObjects(map));

        PrepareSimulation.prepare(map, entities);

        Render.fieldRendering(map);
    }
}
