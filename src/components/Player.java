package src.components;

/*
 * Player.java
 * Class for the player
 * It needs to have a name, boolean isHuman, a color, total points, a graph of structures, and a set of resources
 * It also needs to have the functions addStructure, addResources, subtractResources, build, and adjustPoints
 */
import java.util.Set;
import java.util.HashSet;
 import java.util.HashMap;
 import java.util.Map;

public class Player {
    
    private String name;
    private boolean isHuman;
    private String color;
    private int points;
    private Map<Resource, Integer> resources;
    private Set<BuildNode> structures;      // Make this into a graph structure

    public Player(String name, boolean isHuman, String color) {
        this.name = name;
        this.isHuman = isHuman;
        this.color = color;
        points = 0;
        resources = new HashMap<>();
        structures = new HashSet<>();

        // Initialize resources
        resources.put(Resource.BRICK, 0);
        resources.put(Resource.GRAIN, 0);
        resources.put(Resource.LUMBER, 0);
        resources.put(Resource.ORE, 0);
        resources.put(Resource.WOOL, 0);
    }

    // Add every resources in the parameter to the player's resources
    public void addResource(Resource resources, int amount) {
        this.resources.put(resources, this.resources.getOrDefault(resources, 0) + amount);
    }

    // Subtract every resources in the parameter to the player's resources
    // If the subtraction results in a negative number, throw an error
    public void subtractResource(Resource resources, int amount) {
        if (this.resources.get(resources) - amount < 0) {
            throw new IllegalArgumentException("Subtracting cause the resource to be negative");
        }
        this.resources.put(resources, this.resources.get(resources) - amount);
    }
    

    public void build(BuildNode node) {
        node.build(this, resources);
        structures.add(node);
    }

    public void place(BuildNode node) {
        node.build(this, resources);
        structures.add(node);
    }

    public void adjustPoints(int points) {
        this.points += points;
    }


    // Getters
    // Resource
    public int getResource(Resource resource) {
        return resources.get(resource);
    }

    // Points
    public int getPoints() {
        return points;
    }
}
