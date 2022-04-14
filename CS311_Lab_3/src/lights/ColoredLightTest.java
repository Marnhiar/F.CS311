package lights;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class ColoredLightTest {

	@Test
	public void setColorTest() {
		ColoredLight cl = new ColoredLight(Color.green);
		cl.setColor(Color.blue);
		
		assertEquals(Color.blue, cl.getColor());
	}
	
	@Test
	public void randomChangeTest() {
		ColoredLight cl = new ColoredLight(Color.black);
		cl.randomChange();
		
		assertNotEquals(Color.black, cl.getColor());
	}

}
