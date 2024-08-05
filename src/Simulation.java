import ActionsOnMap.*;
import Сomponents.MapWorld;
import Сomponents.Render;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Simulation {
    private MapWorld map;
    private int moveCounter;
    List<Action> initActions = List.of(new AddGrassAction(), new AddPredatorAction(), new AddRockAction(), new AddTreeAction(), new AddHerbivoreAction());
    List<Action> turnActions = List.of(new MakeMoveCreatureAction(), new AddHerbivoreAction(), new AddGrassAction());
    public void nextTurn(MapWorld map) {
        Render.fieldRendering(map);
        turnActions.forEach(action -> action.doAction(map));
    }

    public void startSimulation(MapWorld map) {
        boolean continueSimulation = true;
        initActions.forEach(action -> action.doAction(map));
        while(continueSimulation){
            try {
                nextTurn(map);
                int userInput = userInput();
                switch (userInput){
                    case (1):
                        pauseSimulation();
                        break;
                    case (2):
                        continueSimulation = false;
                        System.out.println("Симуляция остановлена");
                        break;
                    case (3):
                        break;
                }
                Thread.sleep(3000);
            }catch (InterruptedException e) {
                System.out.println("Что-то пошло не так...");
            }
        }
    }

    public void pauseSimulation() {
        System.out.println("Пауза...(Для продолжения введите любой символ или нажмите enter)");
        Scanner in = new Scanner(System.in);
        in.nextLine();
    }

    private int userInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("1-пауза  2-стоп  3-следующий ход\n");
        int userLetter = Integer.parseInt(in.next());
        if(userLetter != 1 && userLetter != 2 && userLetter != 3){
            System.out.println("Такой цифры нет, попробуйте ещё раз");
            userInput();
        }
        return userLetter;
    }

    public MapWorld getMap() {
        return map;
    }

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.map = new MapWorld(10, 10);
        simulation.startSimulation(simulation.getMap());
    }
}
