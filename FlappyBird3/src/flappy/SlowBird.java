package flappy;

import java.awt.Color;
import java.awt.Graphics;

public class SlowBird extends Bird{

		
	
	
	public SlowBird(Color sz) {
		super(sz);
		
	}

	public void repaint(Graphics g,Boolean JatekVege) {
		super.repaint(g,JatekVege);
		
		g.setColor(szin);
		g.fillRect(bird.x, bird.y, bird.width, bird.height);
		
		
	}
	
	public void Special(Game g,Boolean release) {
		
		if(!release) {
		
			g.GameSpeed = 5;
		}else { 
			  g.GameSpeed = 10;
			}
		
		
	}
	
}
