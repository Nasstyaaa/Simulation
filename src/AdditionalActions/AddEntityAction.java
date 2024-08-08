package AdditionalActions;

import Entities.EntityType;
import Сomponents.MapWorld;

public class AddEntityAction {

    public synchronized AddEntityAction add(MapWorld map, int numberEntities, EntityType entityType) {
        EntityFactory factory = new EntityFactory();
        for (int i = 0; i < numberEntities; i++) {
            map.add(factory.create(entityType));
        }
        return this;
    }
}
