package lights;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class MyHolidayLights implements HolidayLights {
	private int length, mode = 0, count = 0;
	private List<Light> lights = new ArrayList<Light>();
	private boolean allOn = false;
	
	public MyHolidayLights(int length) {
		this.length = length;
		for (int i=0; i<length; i++) {
			ColoredLight cl = new ColoredLight(Color.black);
			cl.randomChange();
			cl.setOn(false);
			
			lights.add(cl);
		}
	}
	
	public int getLength() {
		return length;
	}

	@Override
	public List<Light> next() {
		switch (mode) {
		case 0:
			twoEndBlink();
			break;
		case 1:
			firstEndBlink();
			break;
		case 2:
			lastEndBlink();
			break;
		case 3:
			randomBlink();
			break;
		}
		
		return lights;
	}
	
	private void twoEndBlink() {
		int n = 0;

		if (!allOn) {
			for (int i=0; i<length/2; i++) {
				ColoredLight firstEnd = (ColoredLight) lights.get(i);
				ColoredLight lastEnd = (ColoredLight) lights.get(length-i-1);
						
				if (!firstEnd.isOn() || !lastEnd.isOn()) {
					firstEnd.setOn(true);
					lastEnd.setOn(true);
					
					lights.set(i, firstEnd);
					lights.set(length-i-1, lastEnd);
					break;
				}
				
				else {
					n++;
				}
			}
			
			if (n >= length/2)
				allOn = true;
			
			n = 0;
		}
		
		else {
			for (int i=length/2-1; i>=0; i--) {
				ColoredLight firstEnd = (ColoredLight) lights.get(i);
				ColoredLight lastEnd = (ColoredLight) lights.get(length-1-i);
						
				if (firstEnd.isOn()) {
					firstEnd.setOn(false);
					lastEnd.setOn(false);
					
					lights.set(i, firstEnd);
					lights.set(length-1-i, lastEnd);
					break;
				}
				else {
					n++;
				}
			}
			
			if (n >= length/2) {
				allOn = false;
				ColoredLight temp = (ColoredLight) lights.get(0);
				temp.setOn(true);
				mode = 1;
			}
		}
	}
	
	private void firstEndBlink() {
		for (int i=0; i<length-1; i++) {
			ColoredLight cl = (ColoredLight) lights.get(i);
			if (cl.isOn()) {
				cl.setOn(false);
				ColoredLight clNext = (ColoredLight) lights.get(i+1);
				clNext.setOn(true);
				break;
			}
			if (i == length-2)
				mode = 2;
		}
	}
	
	private void lastEndBlink() {
		for (int i=length-1; i>0; i--) {
			ColoredLight cl = (ColoredLight) lights.get(i);
			if (cl.isOn()) {
				cl.setOn(false);
				ColoredLight clNext = (ColoredLight) lights.get(i-1);
				clNext.setOn(true);
				break;
			}
			if (i == 1) {
				ColoredLight clNext = (ColoredLight) lights.get(i-1);
				clNext.setOn(false);
				mode = 3;
			}
		}
	}
	
	private void randomBlink() {
		int i = (int) (Math.random() * length);
		ColoredLight cl = (ColoredLight) lights.get(i);
			
		if (cl.isOn())
			cl.setOn(false);
		else
			cl.setOn(true);
			
		lights.set(i, cl);
		
		count++;
		
		if (count > 19) {
			for (int j=0; j<length; j++) {
				ColoredLight temp = (ColoredLight) lights.get(j);
				temp.setOn(false);
			}
			count = 0;
			mode = 0;
		}
	}
	
}
