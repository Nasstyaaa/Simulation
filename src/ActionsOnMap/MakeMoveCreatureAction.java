package ActionsOnMap;

import Entities.Creature;
import Entities.Entity;
import Сomponents.MapWorld;

import java.util.ArrayList;

public class MakeMoveCreatureAction implements Action {
    @Override
    public void doAction(MapWorld map) {
        ArrayList<Entity> allEntities = new ArrayList<>(map.getMainCollectionOfLocation().values());
        for (Entity entity : allEntities) {
            if (entity instanceof Creature) {
                ((Creature) entity).makeMove(map);
            }
        }
    }
}
