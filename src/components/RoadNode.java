package src.components;

/*
 * RoadNode.java
 * Represents a road node in the graph
 * Extends BuildNode
 * Also need to have the functions
 */

import java.util.HashMap;
import java.util.Map;

public class RoadNode extends BuildNode {
    static private Map<Resource, Integer> requiredResources = Map.of(Resource.BRICK, 1, Resource.LUMBER, 1);
    private Player player;

    public RoadNode() {
        super();
    }
    
    // Checks whether a road can be built on this node
    // for now it checks whether it has a player or not
    @Override
    protected boolean buildableFor(Player player, Map<Resource, Integer> resourcesOwned) {
        // Check whether the counter in the resourcesOwned is more than the counter in the requiredResources
        // If it is, return true
        return (this.player == null 
            && resourcesOwned.get(Resource.BRICK) >= requiredResources.get(Resource.BRICK) 
            && resourcesOwned.get(Resource.LUMBER) >= requiredResources.get(Resource.LUMBER));
        
    }
}
