package ActionsOnMap;

import Entities.Creature;
import Entities.Entity;
import Entities.Herbivore;
import Entities.Predator;
import Сomponents.MapWorld;

import java.util.ArrayList;

public class MakeMoveCreatureAction implements Action{
    @Override
    public void doAction(MapWorld map) {
        ArrayList<Entity> allEntities = new ArrayList<>(map.getMainCollectionOfLocation().values());
        ArrayList<Creature> allCreature = new ArrayList<>();
        for(Entity entity : allEntities){
            if (entity instanceof Herbivore || entity instanceof Predator)
                allCreature.add((Creature) entity);
        }

        int numberOfCreature = (int) (Math.random() * allCreature.size());
        allCreature.get(numberOfCreature).makeMove(map);
    }
}
