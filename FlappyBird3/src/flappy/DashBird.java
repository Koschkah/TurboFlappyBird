package flappy;

import java.awt.Color;
import java.awt.Graphics;

public class DashBird extends Bird{

	public DashBird(Color sz) {
		super(sz);
		// TODO Auto-generated constructor stub
	}
	
	public void repaint(Graphics g,Boolean JatekVege) {
		super.repaint(g,JatekVege);
		
		g.setColor(szin);
		g.fillRect(bird.x, bird.y, bird.width, bird.height);
		
		
	}
	
	public void Special(Game g,Boolean release) {
		
		if(!release) { 
		
			g.GameSpeed = 20;
		}else { 
			  g.GameSpeed = 10;
			}
		
		
	}
	
	
	
	
}
