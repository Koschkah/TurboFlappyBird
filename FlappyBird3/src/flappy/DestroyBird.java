package flappy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class DestroyBird extends Bird{

	public DestroyBird(Color sz) {
		super(sz);
		// TODO Auto-generated constructor stub
	}
	
	public void repaint(Graphics g,Boolean JatekVege) {
		super.repaint(g,JatekVege);
		
		g.setColor(szin);
		g.fillRect(bird.x, bird.y, bird.width, bird.height);
		
		
	}
	
	public void Special(Game g,Boolean release) {
		
		for (int i = 0; i < g.oszlopok.GetSize(); i++)
		{
			MyRectangle oszlop = (MyRectangle) g.oszlopok.getOszlop(i);

			if(bird.x < oszlop.x) {
				oszlop.setDestroyed(true);
				oszlop.setColor(Color.cyan);
				oszlop = (MyRectangle) g.oszlopok.getOszlop(++i);
				oszlop.setDestroyed(true);
				oszlop.setColor(Color.cyan);
				break;
				
			}
		}
		
		
	}
	
	
	

}
