package flappy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;

public class Game implements ActionListener,MouseListener,KeyListener {

	public static Game game;
	
	public Renderer renderer;
	
	public int ticks,pont = 0;
	
	public Random rand;
	
	public Bird bird;
	
	 public String nev;
	
	public Boolean Kaosz;
	
	public Eredmenyek eredmeny;
	
	public Columns oszlopok = new Columns();
	
	public int GameSpeed = 13;
	
	public static int WIDTH = 1200,HEIGHT = 800;
	
	public Boolean JatekVege = false,Jatek = false;
	
	public JFrame keret;
	public Game(Bird bird,Boolean Kaosz,String n) {
		nev = n;
		rand = new Random();
		this.Kaosz = Kaosz;
		game = this;
		this.bird = bird;
		eredmeny = new Eredmenyek();
		/////////////////////////////////Frame
		 keret = new JFrame();
		keret.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		keret.setSize(WIDTH, HEIGHT);
		keret.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		keret.addKeyListener(this);
		keret.setResizable(false);
		keret.addMouseListener(this);
		////////////////////////////////////Timer
		Timer timer = new Timer(20,this);
		timer.start();
		 
		 
		//////////////////////////////////renderer jpanel
		renderer = new Renderer();
		keret.add(renderer);
		
		
		//////////////////////////////pack
		
		keret.setVisible(true);
	
	
	////////////////////////////// oszlopok
		
		oszlopok.StartAdd();
	
	
	
	
	
	}
	public void repaint(Graphics g) {
		
		
		

		//////////////////////////////Hatter
		g.setColor(Color.cyan);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(Color.orange.darker().darker());
		g.fillRect(0, HEIGHT - 120, WIDTH, 120);
		
		g.setColor(Color.green.brighter());
		g.fillRect(0, HEIGHT - 120, WIDTH, 20);

		
		////////////////////////////Oszlopok
		oszlopok.repaint(g);
		/////////////////////////////Bird
		bird.repaint(g,JatekVege);
		////////////////////////////////////////Felhasznalo uzik
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("serif", Font.BOLD, 60));
		
		if (!Jatek)
		{
			g.drawString("Click to Start!", WIDTH / 2 - g.getFontMetrics().stringWidth("Click to Start!") / 2,
				   HEIGHT / 2 + g.getFontMetrics().getHeight() / 2);
		}
	
		if (JatekVege)
		{
			g.drawString("Game Over!", WIDTH / 2 - g.getFontMetrics().stringWidth("Game Over!") / 2,
				   HEIGHT / 2 + g.getFontMetrics().getHeight() / 2);
		}
	
		if (!JatekVege&&Jatek)
		{
			g.drawString(String.valueOf(pont), WIDTH / 2 -25,  100);
		}
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(Jatek) {
			
		
		// TODO Auto-generated method stub
		/////////////////////////////////////////oszlop mozgas
		for (int i = 0; i < oszlopok.GetSize(); i++)
		{
			Rectangle oszlop = oszlopok.getOszlop(i);

			oszlop.x -= GameSpeed;
		}
		///////////////////////////////////////oszlop torles/ generalas
		for (int i = 0; i < oszlopok.GetSize(); i++)
		{
			Rectangle oszlop = oszlopok.getOszlop(i);

			if(oszlop.x + oszlop.width< 0) {
				oszlopok.remove(oszlop);
				if (oszlop.y == 0)
				{
					oszlopok.addOszlop(false);
				}
				
			}
		}
		
		
		///////////////////////////////////////madar eses
		if( bird.getSebesseg()<14) {
			
			bird.setSepesseg(bird.getSebesseg()+1);
		}
		
		
		////////////////////////////////////////Kaosz mod
		
		if(Kaosz) {
			ticks++;
				if(ticks % 50==0){
						
					if(GameSpeed < 0) {
						GameSpeed = GameSpeed* (-1) + rand.nextInt(-5, 10);
					}else {
					GameSpeed = rand.nextInt(-10, 20);
					}
				
				}
		}
		//////////////////////////////////////////////// jatek vege ck
		
			if(!JatekVege)
		  JatekVege = bird.utkozik(oszlopok);
		
		  
		}
		//////////////////////////////////////pont
		if(!JatekVege)
		pont = bird.pont(oszlopok, pont,GameSpeed);
		//System.out.println(pont);
		//////////////////////////render
		renderer.repaint();
		
	}
	
	public void klikk() {
		
		
		if(JatekVege) {
			
			eredmeny.add(nev,pont);
			keret.dispose();
			new Menu();
			
			
		}

		if(!Jatek) {
			
			Jatek = true;
		}else if (!JatekVege)
		{
			if ( bird.getSebesseg()> 0)
			{
				bird.setSepesseg(0);
			}

			bird.setSepesseg(bird.getSebesseg()-10);
		}
	}
		
		
		
		
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		klikk();
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {	}
	@Override
	public void keyPressed(KeyEvent e) {	
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			bird.Special(game,false);
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			bird.Special(game,true);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
