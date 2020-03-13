import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductTest {
	
	Product p1 = new Product("","",-10,"001yeahwow");
	
	Product clone = new Product(p1);
	
	Product p2 = new Product("sand paper","yuck",10,"005yeahwow");
	
	Product p3 = new Product("toilet paper","d",5,"004yeah");
	@Test
	void testProductProduct() {
		
		assertFalse(p1 == clone);
		assertTrue(p1.equals(clone));
	}

	@Test
	void testSetPrice() {
		assertEquals(p1.getPrice(),p2.getPrice());
		assertTrue(p1.getPrice() > -10);
		assertFalse(p1.getPrice() == -10);
	}

	@Test
	void testSetSku() {
		assertTrue(p1.getSku() == "001yeahwow");
		assertTrue(p2.getSku() == "Invalid sku");
		assertFalse(p3.getSku() == "004yeah");
	}

	@Test
	void testEqualsProduct() {
		assertFalse(p1.equals(p2));
		assertFalse(p2.equals(p3));
		assertFalse(p3.equals(p1));
	}

}
