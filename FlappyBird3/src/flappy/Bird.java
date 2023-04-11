package flappy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bird  {
	public static int WIDTH = 1200,HEIGHT = 800;
	protected Color szin;
	public Rectangle bird;
	private int sebesseg;

	public Bird(Color sz) {
		szin = sz;
		bird = new Rectangle(WIDTH/2-10,HEIGHT/2-10,20,	20);
		
	}
	
	public int getSebesseg() {return sebesseg;}
	public void setSepesseg(int s) {sebesseg = s;}
	
	public void repaint(Graphics g,Boolean JatekVege) {
		bird.y += sebesseg;
		
		g.setColor(szin);
		g.fillRect(bird.x, bird.y, bird.width, bird.height);
		
	}
	
	public int pont(Columns t, int score,int speed) {
		
		for(int i = 0 ;i < t.GetSize(); i++)
		{
			
			Rectangle oszlop = t.getOszlop(i);
			if(oszlop.y==0) {
				if ( bird.x + bird.width / 2 > oszlop.x + oszlop.width / 2 -speed && bird.x + bird.width / 2 < oszlop.x + oszlop.width / 2 )      
				{
				return ++score; 
				}
			}
		}
		return score;
	}
	
	
	public Boolean utkozik(Columns t) {
		
		for(int i = 0 ;i < t.GetSize(); i++)
		{
			
			MyRectangle oszlop = (MyRectangle) t.getOszlop(i);
			
			if (oszlop.intersects(bird)&&!(oszlop.getDestroyed()))
				return  true;

		}
			
		if (bird.y > HEIGHT - 120 || bird.y < 0)
		{
			return true;
		}
		
		
		
		return false;
	}
	
	 public  void Special(Game g,Boolean release) {	}
	
	 public Color getSzin() {return szin;}
	
	
}
