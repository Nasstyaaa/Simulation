package AdditionalActions;

import Entities.*;

import java.util.Random;

public class EntityFactory {
    public Entity create(EntityType entityType) {
        Random random = new Random();
        return switch (entityType) {
            case ROCK -> new Rock();
            case GRASS -> new Grass();
            case TREE -> new Tree();
            case HERBIVORE -> new Herbivore(random.nextInt(3) + 1, random.nextInt(11) + 4);
            case PREDATOR -> new Predator(random.nextInt(4) + 1, random.nextInt(11) + 4, random.nextInt(4) + 1);
            default -> throw new IllegalArgumentException("The passed entity type is not supported");
        };
    }
}
