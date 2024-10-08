package ActionsOnMap;

import AdditionalActions.AddEntityAction;
import Entities.*;
import Сomponents.MapWorld;

public class AddIfNotEnoughAction implements Action {
    @Override
    public synchronized void perfom(MapWorld map) {
        int sizeMap = map.getWidth() * map.getHeight();
        long totalEntitiesCount = map.getAllEntities().stream()
                .filter(entity -> entity instanceof Herbivore || entity instanceof Grass)
                .count();

        if (totalEntitiesCount <= sizeMap / 8) {
            new AddEntityAction().add(map, sizeMap / 7, EntityType.GRASS)
                    .add(map, sizeMap / 8, EntityType.HERBIVORE);
        }
    }
}
