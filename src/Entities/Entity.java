package Entities;

import Сomponents.MapWorld;

import java.util.ArrayList;

public abstract class Entity {

    public abstract ArrayList<? extends Entity> createObjects(MapWorld map);

    public Entity(){

    }
}
