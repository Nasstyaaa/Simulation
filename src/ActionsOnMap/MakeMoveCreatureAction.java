package ActionsOnMap;

import Entities.Creature;
import Entities.Entity;
import Сomponents.MapWorld;

import java.util.ArrayList;
import java.util.List;

public class MakeMoveCreatureAction implements Action {
    @Override
    public void perfom(MapWorld map) {
        List<Creature> creaturesToMove = new ArrayList<>();
        for (Entity entity : map.getAllEntities()) {
            if (entity instanceof Creature){
                creaturesToMove.add((Creature) entity);
            }
        }
        creaturesToMove.forEach(entity -> {
            if (!entity.isDead()) {
                entity.makeMove(map);
            }
        });
    }
}
