import Simulation.Actions;
import Simulation.Map;

public class Main {
    public static void main(String[] args) {
        Actions action = new Actions();
        Map map = new Map(5, 5);
        action.initMap(map);
        System.out.println(map.getMainCollectionOfLocation());
    }
}