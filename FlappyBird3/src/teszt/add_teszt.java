package teszt;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import flappy.Bird;
import flappy.DashBird;
import flappy.DestroyBird;
import flappy.Eredmenyek;
import flappy.Game;
import flappy.Menu;
import flappy.SlowBird;

public class add_teszt {

	@Test
	public void test() {
		
		Game g =  new Game(new DashBird(Color.pink.darker()),false,"ismeretlen");
		assertEquals(g.GameSpeed,13);
		
	}

	@Test
	public void test2() {
		Eredmenyek eredmeny = new Eredmenyek();
			eredmeny.kiir();
			eredmeny.add("Test", 100000000);
			
			assertEquals(eredmeny.get(),"Test");
		
	}
	
	
	@Test
	public void test3() {
		Menu m = new Menu();
		assertEquals(m.GetName(),"Ismeretlen");
			
	}
	
	@Test
	public void test4() {
		
		Game g =  new Game(new SlowBird(Color.yellow),false,"ismeretlen");
		assertEquals(g.bird.getSzin(),Color.yellow);
		
	}
	
	@Test
	public void test5() {
		
		Game g =  new Game(new DestroyBird(Color.black),false,"ismeretlen");
		assertEquals(g.bird.getSzin(),Color.black);
		
	}
	
	@Test
	public void test6() {
		
		Game g =  new Game(new Bird(Color.red),true,"ismeretlen");
		assertEquals(g.bird.getSzin(),Color.red);
		
	}
	
	
}
