import Actions.FindObject;
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

        Render render = new Render();
        render.fieldRendering(map);

        FindObject findObject = new FindObject();
        findObject.find(map, arrayOfHerbivore.get(2), Grass.class);
    }
}
