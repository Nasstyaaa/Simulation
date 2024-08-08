package ActionsOnMap;

import AdditionalActions.AddEntityAction;
import Entities.EntityType;
import Сomponents.MapWorld;

public class ArrangeAllEntiitiesAction implements Action{
    @Override
    public synchronized void perfom(MapWorld map) {
        int sizeMap = map.getWidth() * map.getHeight();
        new AddEntityAction().add(map, sizeMap/6, EntityType.HERBIVORE)
                .add(map, sizeMap/8, EntityType.PREDATOR)
                .add(map, sizeMap/7, EntityType.GRASS)
                .add(map, sizeMap/10, EntityType.ROCK)
                .add(map, sizeMap/10, EntityType.TREE);
    }
}