package src.components;

import java.lang.management.PlatformLoggingMXBean;

/*
 * Node.java
 * Superclass for RoadNode and SettlementNode in the graph
 * It needs to have player and requiredResources as fields
 * and has the functions buildableFor and build
 */

 import java.util.HashMap;
 import java.util.Map;

public abstract class BuildNode {

    private static Map<Resource, Integer> requiredResources;
    
    private Player player;

    public BuildNode() {
        player = null;
    }

    // Build a structure if it is buildable
    public void build(Player player, Map<Resource, Integer> resourcesOwned) {
        if (buildableFor(player, resourcesOwned)) {
            // Set player as owner and update resources
            this.place(player);
            /* player.addStructure(this);
            player.updateResources("substract", requiredResources); */
        }
    }

    // Place a structure in the beginning
    public boolean place(Player player) {
        if (this.player == null) {
            // Set player as owner
            this.player = player;
            /* player.addStructure(this); */
            return true;
        }
        return false;
    }

    /*
     * Checks whether a structure can be built on this node
     * for now it checks whether it has a player or not
     */
    protected abstract boolean buildableFor(Player player, Map<Resource, Integer> resourcesOwned);

    // Setters
    public Player getPlayer() {
        return player;
    }
}
