import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TemperatureTest2 {

	Temperature t = new Temperature();
	
    @Test
    void testCelsius() {
        //double temp = -40;
    	t.setTemp(-40);

        double desired_result = -40;
        double real_result = t.getCelsius();

        assertEquals(desired_result,real_result);
    }

    @Test
    void testFahrenheit() {
        //double temp = -40;
        t.setTemp(-40);

        double desired_result = -40;
        double real_result = t.getFahrenheit();

        assertEquals(desired_result,real_result);
    }
    
    @Test
    void testBoolean() {
    	t.setTemp(-40);
    	
    	boolean real_result = t.equals(t.getCelsius());
    	boolean desired_result = true;
    	
    	assertEquals(desired_result,real_result);
    }
    
    @Test
    void testCompare() {
    	t.setTemp(-40);
    	
    	int desired_result = 0;
    	int real_result = t.compareTo(t.getCelsius());
    	
    	assertEquals(desired_result,real_result);
    }
    
}
