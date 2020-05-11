import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.awt.*;

class CreatureTest {
	
	Item w = new Weapon();
	Item a = new Armor();
	Item f = new Food();
	
	Creature h1 = new Hobbit();
	Creature h2 = new Hobbit();
	Creature h3 = new Hobbit();
	
	Creature n1 = new Nazgul();
	Creature n2 = new Nazgul();
	Creature n3 = new Nazgul();
	
	Creature v1 = new Vegetation();
	Creature v2 = new Vegetation();
	Creature v3 = new Vegetation();
	
	Creature s1 = new Sauron();
	Creature s2 = new Sauron();
	Creature s3 = new Sauron();
	
	
	@Test
	void testEquip() {
		
		h1.equip(w);
		h2.equip(a);
		h3.equip(f);
		n1.equip(w);
		n2.equip(a);
		n3.equip(f);
		
		
		assertTrue(h1.inventory.get(0) == w);
		assertTrue(h2.inventory.get(0) == a);
		assertTrue(h3.inventory.get(0) == f);
		assertTrue(n1.inventory.get(0) == w);
		assertTrue(n2.inventory.get(0) == a);
		assertTrue(n3.inventory.get(0) == f);
		assertTrue(h1.getAttack() > 10);
		assertTrue(n2.getHealth() > 200);
		assertTrue(h3.getHunger() > 11);
		
	}

	@Test
	void testMoveUp() {
		//fail("Not yet implemented");
		Map.world[50][100] = h1;
		Map.locationOf(h1);
		int px = h1.locationPoint[0]; int py = h1.locationPoint[1];
		h1.moveUp();
		Map.locationOf(h1);
		int ax = h1.locationPoint[0]; int ay = h1.locationPoint[1];
		
		assertTrue(px == ax);
		assertTrue(py != ay);
	}

	@Test
	void testMoveDown() {
		//fail("Not yet implemented");
		Map.world[50][100] = h1;
		Map.locationOf(h1);
		int px = h1.locationPoint[0]; int py = h1.locationPoint[1];
		h1.moveDown();
		Map.locationOf(h1);
		int ax = h1.locationPoint[0]; int ay = h1.locationPoint[1];
		
		assertTrue(px == ax);
		assertTrue(py != ay);
	}

	@Test
	void testMoveRight() {
		//fail("Not yet implemented");
		Map.world[50][100] = h1;
		Map.locationOf(h1);
		int px = h1.locationPoint[0]; int py = h1.locationPoint[1];
		h1.moveRight();
		Map.locationOf(h1);
		int ax = h1.locationPoint[0]; int ay = h1.locationPoint[1];
		
		assertTrue(px != ax);
		assertTrue(py == ay);
	}

	@Test
	void testMoveLeft() {
		//fail("Not yet implemented");
		Map.world[50][100] = h1;
		Map.locationOf(h1);
		int px = h1.locationPoint[0]; int py = h1.locationPoint[1];
		h1.moveLeft();
		Map.locationOf(h1);
		int ax = h1.locationPoint[0]; int ay = h1.locationPoint[1];
		
		assertTrue(px != ax);
		assertTrue(py == ay);
	}

	@Test
	void testAttack() {
		//fail("Not yet implemented");
	}

	@Test
	void testReplicateUp() {
		//fail("Not yet implemented");
		Map.world[50][100] = h1;
		Map.locationOf(h1);
		int px = h1.locationPoint[0]; int py = h1.locationPoint[1];
		h1.replicateUp();
		Map.locationOf(h1);
		int ax = h1.locationPoint[0]; int ay = h1.locationPoint[1];
		
		assertTrue(px == ax);
		assertTrue(py == ay);
		assertTrue(Map.world[50][90] instanceof Hobbit);
	}

	@Test
	void testReplicateDown() {
		//fail("Not yet implemented");
		Map.world[50][100] = h1;
		Map.locationOf(h1);
		int px = h1.locationPoint[0]; int py = h1.locationPoint[1];
		h1.replicateDown();
		Map.locationOf(h1);
		int ax = h1.locationPoint[0]; int ay = h1.locationPoint[1];
		
		assertTrue(px == ax);
		assertTrue(py == ay);
		assertTrue(Map.world[50][110] instanceof Hobbit);
	}

	@Test
	void testReplicateRight() {
		//fail("Not yet implemented");
		Map.world[50][100] = h1;
		Map.locationOf(h1);
		int px = h1.locationPoint[0]; int py = h1.locationPoint[1];
		h1.replicateRight();
		Map.locationOf(h1);
		int ax = h1.locationPoint[0]; int ay = h1.locationPoint[1];
		
		assertTrue(px == ax);
		assertTrue(py == ay);
		assertTrue(Map.world[60][100] instanceof Hobbit);
	}

	@Test
	void testReplicateLeft() {
		//fail("Not yet implemented");
		Map.world[50][100] = h1;
		Map.locationOf(h1);
		int px = h1.locationPoint[0]; int py = h1.locationPoint[1];
		h1.replicateLeft();
		Map.locationOf(h1);
		int ax = h1.locationPoint[0]; int ay = h1.locationPoint[1];
		
		assertTrue(px == ax);
		assertTrue(py == ay);
		assertTrue(Map.world[40][100] instanceof Hobbit);
	}

	@Test
	void testChooseAction() {
		//fail("Not yet implemented");
		Map.world[50][100] = h1;
		Map.locationOf(h1);
		int px = h1.locationPoint[0]; int py = h1.locationPoint[1];
		h1.chooseAction();
		Map.locationOf(h1);
		int ax = h1.locationPoint[0]; int ay = h1.locationPoint[1];
		assertTrue(Map.world[px][py] == null);
		assertTrue(Map.world[ax][ay] == h1);
		
		Map.world[300][300] = h2;
		int previousHealthHobbit = h2.getHealth();
		Map.world[310][300] = n1;
		Map.locationOf(h2);
		Map.locationOf(n1);
		int px2 = h2.locationPoint[0]; int py2 = h2.locationPoint[1];
		int nx = n1.locationPoint[0]; int ny = n1.locationPoint[1];
		
		n1.chooseAction();
		h2.chooseAction();
		
		Map.locationOf(h2);
		Map.locationOf(n1);
		
		int ax2 = h2.locationPoint[0]; int ay2 = h2.locationPoint[1];
		int nx2 = n1.locationPoint[0]; int ny2 = n1.locationPoint[1];
		
		n1.attack(h2);
		
		//assertTrue(Map.world[ax2][ay2] == Map.world[290][300]);
		assertTrue(Map.world[nx2][ny2] == Map.world[300][300]);
		assertTrue(previousHealthHobbit > h2.getHealth());
		
		Map.world[200][200] = h3;
		Map.world[210][200] = v1;
		int previousHealth = v1.getHealth();
		Map.locationOf(h3);
		Map.locationOf(v1);
		int px3 = h2.locationPoint[0]; int py3 = h2.locationPoint[1];
		int vx = n1.locationPoint[0]; int vy = n1.locationPoint[1];
		
		h3.chooseAction();
		v1.chooseAction();
		
		Map.locationOf(h3);
		Map.locationOf(v1);
		
		int ax3 = h2.locationPoint[0]; int ay3 = h2.locationPoint[1];
		int vx2 = n1.locationPoint[0]; int vy2 = n1.locationPoint[1];
		
		//n1.attack(h2);
		
		//assertTrue(Map.world[ax2][ay2] == Map.world[290][300]);
		//assertTrue(h3 == Map.world[210][200]);
		assertTrue(previousHealth > v1.getHealth());
	}

	@Test
	void testColor() {
		//fail("Not yet implemented");
		Color hob1 = h1.color();
		
		assertTrue(hob1 == Color.BLUE);
		
		h2.setHealth(60);
		Color hob2 = h2.color();
		
		assertTrue(hob2 == Color.YELLOW);
		
		h3.setHealth(30);
		Color hob3 = h3.color();
		
		assertTrue(hob3 == Color.RED);
		
		
		
		
	}

}
