import ActionsOnMap.*;
import Сomponents.MapWorld;
import Сomponents.Render;

import java.util.List;
import java.util.Map;

public class Simulation {
    private MapWorld map;
    private int moveCounter;
    List<Action> initActions = List.of(new AddGrassAction(), new AddPredatorAction(), new AddRockAction(), new AddTreeAction(), new AddHerbivoreAction());
    List<Action> turnActions = List.of(new MakeMoveCreatureAction(), new AddHerbivoreAction(), new AddGrassAction());
    public void nextTurn(MapWorld map) {
        turnActions.forEach(action -> action.doAction(map));
        Render.fieldRendering(map);
    }

    public void startSimulation(MapWorld map) {
        initActions.forEach(action -> action.doAction(map));
        Render.fieldRendering(map);
        int count = 0;
        while(true){
            nextTurn(map);
            count++;
            if (count > 5)
                break;
        }
    }

    public void pauseSimulation() {
        System.out.println("pause");
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
