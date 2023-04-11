package flappy;

import java.awt.Color;
import java.awt.Rectangle;

public class MyRectangle extends Rectangle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Color szin =Color.green.darker().darker();
	private Boolean Destroyed = false;
	
	public MyRectangle(int x, int i, int szeles, int j) {
		super(x,i,szeles,j);
	}

	public Color getColor() {return szin;}
	
	public void setColor(Color sz) {szin = sz;}
	
	public Boolean getDestroyed() {return Destroyed;}
	
	public void setDestroyed(Boolean d) {Destroyed = d;}
	
}
