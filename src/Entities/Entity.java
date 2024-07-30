package Entities;

import Simulation.MapWorld;

import java.util.ArrayList;

public abstract class Entity {

    public abstract ArrayList<? extends Entity> createObjectOnMap(MapWorld map);

    public Entity(){

    }
}
