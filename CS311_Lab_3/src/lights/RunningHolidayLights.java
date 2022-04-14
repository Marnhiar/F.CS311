package lights;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class RunningHolidayLights implements HolidayLights {
	
	/**
	 * Creates new running holiday lights.
	 * @param length - length of this set of lights.
	 */

	int length;
	List<Light> lights = new ArrayList<Light>();
	
	public RunningHolidayLights(int length) {
		this.length = length;
		for (int i=0; i<length; i++) {
			ColoredLight cl = new ColoredLight(Color.black);
			cl.randomChange();
			
			lights.add(cl);
		}
	}
	
	public List<Light> next() {
		int i = (int) (Math.random() * length);
		ColoredLight cl = (ColoredLight) lights.get(i);
			
		if (cl.isOn())
			cl.setOn(false);
		else
			cl.setOn(true);
			
		lights.set(i, cl);
		return lights;
	}
	
	/**
	 * Returns the length of this
	 * @return length of this
	 */
	public int getLength() {
		return length;
	}
						
}