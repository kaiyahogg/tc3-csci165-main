import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InvoiceTest {
	Date date = new Date(3,11,2020);
	Address address = new Address("","","","");
	Customer customer = new Customer("","","",address);
	Account account = new Account(customer,date);
	Product p1 = new Product("","",2,"");
	
	Product p2 = new Product("","",5,"");
	
	Invoice i1 = new Invoice("", account,1,date);
	Invoice i2 = new Invoice("",account,7,date);
	
	@Test
	void testGetAmountDue() {
		assertTrue(i1.getAmountDue() == 1);
		assertEquals(i2.getAmountDue(), 7);
	}
	
	@Test
	void testCompareTo() {
		assertTrue(i1.compareTo(i2)<0);
		assertTrue(i2.compareTo(i1)>0);
		assertTrue(i2.compareTo(i2)==0);
	}

}
