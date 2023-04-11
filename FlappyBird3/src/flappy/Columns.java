package flappy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class Columns {
	public static int WIDTH = 1200,HEIGHT = 800;
	private ArrayList<MyRectangle> oszlopok;
	private Random random;

	
	public Columns() {
		oszlopok = new ArrayList<MyRectangle>();
		random = new Random();
		
		
	}
	
	
	
	public void addOszlop(Boolean start) {
		int koz = 300;
		int szeles = 100; 
		int magas = 50+ random.nextInt(300);
		
		if(start) {
		MyRectangle temp = new MyRectangle(WIDTH + szeles + oszlopok.size()*300,HEIGHT-magas-120,szeles,magas);
		oszlopok.add(temp);
		temp = new MyRectangle(WIDTH+ szeles + (oszlopok.size()-1)*300,0,szeles,HEIGHT-magas-koz);
		oszlopok.add(temp);
		}
		else {
			
			MyRectangle temp = new MyRectangle(oszlopok.get(oszlopok.size() - 1).x + 600,HEIGHT-magas-120,szeles,magas);
			oszlopok.add(temp);
			temp = new MyRectangle(oszlopok.get(oszlopok.size()-1).x,0,szeles,HEIGHT-magas-koz);
			oszlopok.add(temp);
			
		}
		
	}

		public void StartAdd() {
		
				for(int i = 0;i < 4;i++)
						addOszlop(true);
			}
	
	
	
	
	
	
	
	
	
	
	
	
	public void repaint(Graphics g) {
		
		for(MyRectangle oszlop: oszlopok) { 
			g.setColor(oszlop.getColor());
			g.fillRect(oszlop.x, oszlop.y, oszlop.width, oszlop.height);
		}
		
		
	}
	
	
	
	public Rectangle getOszlop(int i) {
		return oszlopok.get(i);
		
	}
	
	public int GetSize() {return oszlopok.size();}



	public void remove(Rectangle oszlop) {

      oszlopok.remove(oszlop);
		
	}



	public void clear() {
		
		oszlopok.clear();
		
	}
}
