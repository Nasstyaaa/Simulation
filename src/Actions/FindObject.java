package Actions;

import Entities.Entity;
import Simulation.Map;

import java.util.ArrayList;
import java.util.List;

public interface FindObject {
    public Entity find(Map map, Entity entity);
}
