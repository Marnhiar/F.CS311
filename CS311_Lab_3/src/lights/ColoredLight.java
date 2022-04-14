package lights;

import java.awt.Color;

public class ColoredLight extends Light{
	
	private Color color;
	
	public ColoredLight(Color color) {
		super(true);
		this.color = color;
	}
	
	/**
	 * Returns the color of this light.
	 * @return color of this light.
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Changes the color of this light to be c.
	 */
	public void setColor(Color c) {
		color = c;
	}
	
	/**
	 * Randomly changes this light to be on or off and its color.
	 */
	@Override
	public void randomChange() {
		super.randomChange();
		
		int r = (int) (Math.random() * 255);
		int g = (int) (Math.random() * 255);
		int b = (int) (Math.random() * 255);
		Color c = new Color(r, g, b);
		this.color = c;
	}
	
}