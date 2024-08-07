package AdditionalActions;

import Entities.*;

public class EntityFactory {
    public Entity create(EntityType entityType) {
        Entity entity = null;

        switch (entityType) {
            case ROCK -> entity = new Rock();
            case GRASS -> entity = new Grass();
            case TREE -> entity = new Tree();
            case HERBIVORE -> entity = new Herbivore((int) (1 + Math.random() * 3), (int) (4 + Math.random() * 11));
            case PREDATOR -> entity = new Predator((int) (1 + Math.random() * 4),
                    (int) (4 + Math.random() * 11), (int) (1 + Math.random() * 4));
        }
        return entity;
    }
}
