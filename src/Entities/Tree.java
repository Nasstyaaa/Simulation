package Entities;

import Simulation.MapWorld;

import java.util.ArrayList;

public class Tree extends Entity{
    @Override
    public ArrayList<Tree> createObjectOnMap(MapWorld map) {
        int sizeMap = (map.getLengthY() * map.getLengthX()) / 10;
        ArrayList<Tree> listOfTree = new ArrayList<>();
        for (int i = 0; i < sizeMap; i++){
            listOfTree.add(new Tree());
        }
        map.addObjectsOnMap(listOfTree);
        return listOfTree;
    }

    public Tree(){}
}
