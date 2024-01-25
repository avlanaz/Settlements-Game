package src.unittest;

/**
 * PlayerTest
 * 
 * To test:
 * 1. Player has 0 resources, points at the start
 * 2. Resources are added correctly for all resource types
 * 3. Resources are subtracted correctly for all resource types
 * 4. Resources can't be below 0; throw an error (No valid functions should make this happen)
 * 5. Points are adjusted correctly
 */
import static org.junit.Assert.*;

import org.junit.Test;

import src.components.RoadNode;
import src.components.Player;
import src.components.Resource;


public class PlayerTest {
    
    @Test
    public void playerHasZeroResourcesAndPointsAtStart() {
        Player player = new Player("player", true, "red");
        assertEquals(0, player.getResource(Resource.BRICK));
        assertEquals(0, player.getResource(Resource.GRAIN));
        assertEquals(0, player.getResource(Resource.LUMBER));
        assertEquals(0, player.getResource(Resource.ORE));
        assertEquals(0, player.getResource(Resource.WOOL));

        assertEquals(0, player.getPoints());
    }

    @Test
    public void playerHasCorrectResourcesAfterAdding() {
        Player player = new Player("player", true, "red");
        player.addResource(Resource.BRICK, 1);
        player.addResource(Resource.GRAIN, 2);
        player.addResource(Resource.LUMBER, 3);
        player.addResource(Resource.ORE, 4);
        player.addResource(Resource.WOOL, 5);

        assertEquals(1, player.getResource(Resource.BRICK));
        assertEquals(2, player.getResource(Resource.GRAIN));
        assertEquals(3, player.getResource(Resource.LUMBER));
        assertEquals(4, player.getResource(Resource.ORE));
        assertEquals(5, player.getResource(Resource.WOOL));
    }

    @Test
    public void playerHasCorrectResourcesAfterSubtracting() {
        Player player = new Player("player", true, "red");
        player.addResource(Resource.BRICK, 1);
        player.addResource(Resource.GRAIN, 2);
        player.addResource(Resource.LUMBER, 3);
        player.addResource(Resource.ORE, 4);
        player.addResource(Resource.WOOL, 5);

        player.subtractResource(Resource.BRICK, 1);
        player.subtractResource(Resource.GRAIN, 2);
        player.subtractResource(Resource.LUMBER, 3);
        player.subtractResource(Resource.ORE, 4);
        player.subtractResource(Resource.WOOL, 5);

        assertEquals(0, player.getResource(Resource.BRICK));
        assertEquals(0, player.getResource(Resource.GRAIN));
        assertEquals(0, player.getResource(Resource.LUMBER));
        assertEquals(0, player.getResource(Resource.ORE));
        assertEquals(0, player.getResource(Resource.WOOL));
    }

    @Test
    public void throwErrorIfResourceIsBelowZero() {
        Player player = new Player("player", true, "red");
        player.addResource(Resource.BRICK, 1);
        player.addResource(Resource.GRAIN, 2);
        player.addResource(Resource.LUMBER, 3);
        player.addResource(Resource.ORE, 4);
        player.addResource(Resource.WOOL, 5);

        try {
            player.subtractResource(Resource.BRICK, 2);
            fail("Should throw an error");
        } catch (Exception e) {
            assertEquals("Subtracting cause the resource to be negative", e.getMessage());
        }

        try {
            player.subtractResource(Resource.GRAIN, 3);
            fail("Should throw an error");
        } catch (Exception e) {
            assertEquals("Subtracting cause the resource to be negative", e.getMessage());
        }

        try {
            player.subtractResource(Resource.LUMBER, 4);
            fail("Should throw an error");
        } catch (Exception e) {
            assertEquals("Subtracting cause the resource to be negative", e.getMessage());
        }

        try {
            player.subtractResource(Resource.ORE, 5);
            fail("Should throw an error");
        } catch (Exception e) {
            assertEquals("Subtracting cause the resource to be negative", e.getMessage());
        }

        try {
            player.subtractResource(Resource.WOOL, 6);
            fail("Should throw an error");
        } catch (Exception e) {
            assertEquals("Subtracting cause the resource to be negative", e.getMessage());
        }
    }

    @Test
    public void playerHasCorrectPointsAfterAdjusting() {
        Player player = new Player("player", true, "red");
        player.adjustPoints(1);
        player.adjustPoints(-2);
        player.adjustPoints(3);
        player.adjustPoints(-4);
        player.adjustPoints(5);

        assertEquals(3, player.getPoints());
    }
}
