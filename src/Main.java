import Сomponents.Simulation;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation(10, 10);
        simulation.start(simulation.getMap());
    }
}
