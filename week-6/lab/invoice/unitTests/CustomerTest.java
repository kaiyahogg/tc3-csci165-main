import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {
	Address a1 = new Address("","","","");
	Customer c1 = new Customer("Jimi","Hendrix","electricladyland@gmail.com",a1);
	Customer clone = new Customer(c1);
	
	Customer c2 = new Customer("","","e@gmailco.m", a1);
	
	Customer c3 = new Customer("","d","wowgmail.com@",a1);
	
	@Test
	void testCustomerCustomer() {
		
		assertFalse(clone == c1);
		
		assertTrue(clone.equals(c1));
		
	}

	@Test
	void testSetName() {
		assertEquals(c1.getName(), "Jimi Hendrix");
	}

	@Test
	void testSetEmail() {
		assertEquals(c1.getEmail(), "electricladyland@gmail.com");
		assertEquals(c2.getEmail(), "invalid email");
		assertEquals(c3.getEmail(), "invalid email");
	}

	@Test
	void testEqualsCustomer() {
		assertFalse(c1.equals(c2));
		assertTrue(c1.equals(clone));
		assertFalse(c3.equals(c2));
	}

}
