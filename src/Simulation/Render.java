package Simulation;

import Entities.*;

import java.util.Map;

public class Render {
    public void fieldRendering(MapWorld map) {
        for (Map.Entry<String, Entity> entry : map.getMainCollectionOfLocation().entrySet()) {
            String[] cords = entry.getKey().split(",");
            int x = Integer.parseInt(cords[0]);
            int y = Integer.parseInt(cords[1]);

            Entity currentEntity = entry.getValue();
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

            if ((x + 1) % map.getLengthX() == 0) {
                System.out.println();
            }
        }
    }
}
