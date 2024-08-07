package AdditionalActions;

import Entities.*;

public class EntityFactory {
    public Entity create(EntityType entityType) {
        return switch (entityType) {
            case ROCK -> new Rock();
            case GRASS -> new Grass();
            case TREE -> new Tree();
            case HERBIVORE -> new Herbivore((int) (1 + Math.random() * 3), (int) (4 + Math.random() * 11));
            case PREDATOR -> new Predator((int) (1 + Math.random() * 4),
                    (int) (4 + Math.random() * 11), (int) (1 + Math.random() * 4));
            default -> throw new IllegalArgumentException("Переданный тип сущности не поддерживается");
        };
    }
}
