import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountTest {
	
	Date date = new Date(03,11,2019);
	Address address = new Address("","","","");
	Customer customer = new Customer("","","",address);
	Account account = new Account(customer,-10,-30,date);
	
	Date d2 = new Date(03,11,2020);
	Account a2 = new Account(customer,0,0,d2);
	
	Account a3 = new Account(customer,-10,0,date);
	
	Customer cTest = new Customer("Kaiya","Hogg","",address);
	Account aTest = new Account(cTest,date);
	
	@Test
	void testAccountAccount() {
		Account clone = new Account(account);
		
		assertFalse(account == clone);
		
		//assertTrue(account.equals(clone));
		
		assertEquals(account.compareTo(clone),0);
	}
	@Test
	void testGetDiscountLevel() {
		
		assertEquals(account.getDiscountLevel(), 2);
		
		assertFalse(a2.getDiscountLevel() == account.getDiscountLevel());
		assertTrue(a2.getDiscountLevel() < account.getDiscountLevel());
	}

	@Test
	void testSetBalance() {
		assertEquals(account.getBalance(),10);
	}

	@Test
	void testSetCreditLimit() {
		assertEquals(account.getCreditLimit(),20);
	}

	@Test
	void testGetID() {
		assertEquals(aTest.getID(),"KYHGG031120193");
	}
	
	@Test
	void testEqualsAccount() {
		assertFalse(account.equals(a2));
	}

	@Test
	void testCompareTo() {
		assertEquals(account.compareTo(a3),0);
		assertTrue(account.compareTo(a2) == 1);
		assertTrue(a2.compareTo(account) == -1);
	}

}
