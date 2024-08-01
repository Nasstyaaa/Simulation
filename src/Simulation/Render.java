package Simulation;

import Entities.*;

public class Render {
    public static void fieldRendering(MapWorld map) {
        for (int i = 0; i < map.getLengthX(); i++) {
            for (int j = 0; j < map.getLengthY(); j++) {
                Entity currentEntity = map.getMainCollectionOfLocation().get(i + "," + j);
                if (currentEntity instanceof Herbivore)
                    System.out.print(" " + "\uD83D\uDC01" + " ");
                else if (currentEntity instanceof Predator)
                    System.out.print(" " + "\uD83D\uDC0D" + " ");
                else if (currentEntity instanceof Grass)
                    System.out.print(" " + "\uD83C\uDF3F" + " ");
                else if (currentEntity instanceof Tree)
                    System.out.print(" " + "\uD83C\uDF33" + " ");
                else if (currentEntity instanceof Rock)
                    System.out.print(" " + "⛰\uFE0F" + " ");
                else
                    System.out.print(" " + "\uD83D\uDFEB" + " ");
            }
            System.out.println();
        }
    }
}
