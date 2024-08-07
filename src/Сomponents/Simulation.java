package Сomponents;

import ActionsOnMap.*;

import java.util.List;
import java.util.Scanner;

public class Simulation {
    private MapWorld map;
    private int moveCounter = 0;
    private List<Action> initActions = List.of(new ArrangeAllEntiitiesAction());;
    private List<Action> turnActions = List.of(new MakeMoveCreatureAction(), new AddIfNotEnoughAction());
    private boolean paused = false;
    private static final int COMMAND_PAUSE = 1;
    private static final int COMMAND_STOP = 2;

    public Simulation(int lenghtX, int lenghtY) {
        this.map = new MapWorld(lenghtX, lenghtY);
    }

    public MapWorld getMap() {
        return map;
    }

    public void nextTurn(MapWorld map) throws Exception {
        WorldRender.render(map);
        System.out.printf("%d-пауза  %d-стоп " + "(Ход номер: %d) \n", COMMAND_PAUSE, COMMAND_STOP, moveCounter);
        turnActions.forEach(action -> action.perfom(map));
        moveCounter++;
    }

    public void start(MapWorld map) {
        boolean continueSimulation = true;
        initActions.forEach(action -> action.perfom(map));

        Thread turnThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    while (paused)
                        Thread.sleep(100);
                    nextTurn(map);
                    Thread.sleep(4000);
                } catch (Exception e) {
                    return;
                }
            }
        });

        turnThread.start();

        while (continueSimulation) {
            int userInput = userInput();
            System.out.println();
            switch (userInput) {
                case (COMMAND_PAUSE):
                    pause();
                    break;
                case (COMMAND_STOP):
                    continueSimulation = false;
                    System.out.println("Симуляция остановлена");
                    break;
            }
        }
        turnThread.interrupt();
    }

    public void pause() {
        paused = true;
        System.out.println("Пауза...(Для продолжения введите любой символ или нажмите enter)");
        Scanner in = new Scanner(System.in);
        in.nextLine();
        paused = false;
    }

    private int userInput() {
        Scanner in = new Scanner(System.in);
        int userLetter = -1;
        while (true) {
            try {
                userLetter = Integer.parseInt(in.next());
                paused = true;
                if (userLetter == COMMAND_PAUSE || userLetter == COMMAND_STOP) {
                    paused = false;
                    break;
                }
                else {
                    System.out.println("Такой команды нет, попробуйте ещё раз");
                }
            } catch (NumberFormatException exception) {
                System.out.println("Ошибка (это вообще не число), попробуйте ещё раз");
                paused = true;
            }
        }
        return userLetter;
    }
}
