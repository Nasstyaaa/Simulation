package Сomponents;

import Entities.*;

public class WorldRender {
    public static void render(MapWorld map) throws Exception {
        System.out.println();
        for (int i = 0; i < map.getLengthX(); i++) {
            for (int j = 0; j < map.getLengthY(); j++) {
                Entity currentEntity = map.getEntity(new Coordinate(i, j));
                if (currentEntity instanceof Herbivore) {
                    System.out.print(" " + "\uD83D\uDC01" + " ");
                } else if (currentEntity instanceof Predator) {
                    System.out.print(" " + "\uD83D\uDC0D" + " ");
                } else if (currentEntity instanceof Grass) {
                    System.out.print(" " + "\uD83C\uDF3F" + " ");
                } else if (currentEntity instanceof Tree) {
                    System.out.print(" " + "\uD83C\uDF33" + " ");
                } else if (currentEntity instanceof Rock) {
                    System.out.print(" " + "⛰\uFE0F" + " ");
                } else if (currentEntity == null) {
                    System.out.print(" " + "\uD83D\uDFEB" + " ");
                }
                else {
                    throw new Exception("Неизвестный тип сущности: " + currentEntity);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
