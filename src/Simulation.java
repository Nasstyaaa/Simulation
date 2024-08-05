import ActionsOnMap.*;
import Сomponents.MapWorld;
import Сomponents.Render;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Simulation {
    private MapWorld map;
    private int moveCounter = 0;
    List<Action> initActions;
    List<Action> turnActions;
    private Thread turnThread;
    private boolean paused = false;

    public Simulation(int lenghtX, int lenghtY) {
        this.map = new MapWorld(lenghtX, lenghtY);
    }

    public void initializeActions(MapWorld map) {
        initActions = new ArrayList<>(List.of(new AddGrassAction(map),
                new AddPredatorAction(map), new AddRockAction(map), new AddTreeAction(map), new AddHerbivoreAction(map)));

        turnActions = new ArrayList<>(List.of(new MakeMoveCreatureAction(), new AddHerbivoreAction(map), new AddGrassAction(map)));
    }

    public MapWorld getMap() {
        return map;
    }

    public void nextTurn(MapWorld map) {
        Render.fieldRendering(map);
        System.out.print("1-пауза  2-стоп " + "(Ход номер: " + moveCounter + ")\n");
        turnActions.forEach(action -> action.doAction(map));
        moveCounter++;
    }

    public void startSimulation(MapWorld map) {
        initializeActions(map);
        boolean continueSimulation = true;
        initActions.forEach(action -> action.doAction(map));

        turnThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    while (paused)
                        Thread.sleep(100);
                    nextTurn(map);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        });

        turnThread.start();

        while (continueSimulation) {
            int userInput = userInput();
            switch (userInput) {
                case (1):
                    pauseSimulation();
                    break;
                case (2):
                    continueSimulation = false;
                    System.out.println("Симуляция остановлена");
                    break;
            }
        }
        if (turnThread != null) {
            turnThread.interrupt();
        }
    }

    public void pauseSimulation() {
        paused = true;
        System.out.println("Пауза...(Для продолжения введите любой символ или нажмите enter)");
        Scanner in = new Scanner(System.in);
        in.nextLine();
        paused = false;
    }

    private int userInput() {
        Scanner in = new Scanner(System.in);
        int userLetter = Integer.parseInt(in.next());
        if (userLetter != 1 && userLetter != 2) {
            System.out.println("Такой цифры нет, попробуйте ещё раз");
            userInput();
        }
        return userLetter;
    }

    public static void main(String[] args) {
        Simulation simulation = new Simulation(10, 10);
        simulation.startSimulation(simulation.getMap());
    }
}
