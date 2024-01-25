package src.unittest;

/*
 * Unit test for RoadNode class
 * To be tested:
 * 1. road belongs to a player after calling build()
 * 2. road can be build by a player with satisfying criteria
 * 3. road CANNOT be build by a player without enough resources
 * 5. road CANNOT be build by on an existing road by a different player
 * 6. road belongs to a player after calling place()
 * 7. road CANNOT be build by on an existing road  by the same player   - Can only be tested during integration
 * 
 * later
 * - road CANNOT be build by a player without enough roads
 */

 // use jUnit for testing

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import src.components.RoadNode;
import src.components.Player;
import src.components.Resource;

public class RoadTest {

    static private Map<Resource, Integer> requiredResources = Map.of(Resource.BRICK, 1, Resource.LUMBER, 1);

    @Test
    public void roadHasNullPlayerBeforeBuild() {
        RoadNode road = new RoadNode();
        assertNull(road.getPlayer());
    }

    @Test
    public void roadHasPlayerAfterBuild() {
        RoadNode road = new RoadNode();
        Player player = new Player("player", true, "red");
        road.build(player, requiredResources);
        assertEquals(player, road.getPlayer());
    }

    @Test
    public void roadCanBeBuilt() {
        RoadNode road = new RoadNode();
        Player player = new Player("player", true, "red");
        road.build(player, requiredResources);
        assertEquals(player, road.getPlayer());
    }

    @Test
    public void roadCannotBeBuiltWithoutEnoughResources() {
        RoadNode road = new RoadNode();
        Player player = new Player("player", true, "red");
        road.build(player, Map.of(Resource.BRICK, 1, Resource.LUMBER, 0));

        assertNull(road.getPlayer());
    }

    @Test
    public void roadCannotBeBuiltByDifferentPlayerOnExistingRoad() {
        RoadNode road = new RoadNode();
        Player player = new Player("player", true, "red");
        Player player2 = new Player("player2", true, "blue");
        road.build(player, requiredResources);
        road.build(player2, requiredResources);

        assertEquals(player, road.getPlayer());
    }

    /*  !!! This test requires Player class to work, which is not appropriate for unit test !!!
        !!! Do it during the phase of integration test !!!
    
    @Test
    public void roadCannotBeBuiltBySamePlayerOnExistingRoad() {
        RoadNode road = new RoadNode();
        Player player = new Player("player", true, "red");

        Map<Resource, Integer> requiredResources = Map.of(Resource.BRICK, 2, Resource.LUMBER, 2);
        Map<Resource, Integer> endResources = Map.of(Resource.BRICK, 1, Resource.LUMBER, 1);

        road.build(player, requiredResources);
        road.build(player, requiredResources);

        // Assert equality on the player's resources and the requiredResources
        // i.e. assert equality on two maps
        assertEquals(endResources, requiredResources);

        

    } */
}
