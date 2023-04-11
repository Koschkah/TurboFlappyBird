package flappy;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu extends JFrame implements ActionListener{

	public static int WIDTH = 500,HEIGHT = 500;
	
	
	private JButton gamestart = new JButton();
	private JButton eredmeny = new JButton();
	private JButton Kaosz = new JButton();
	private JLabel valassz = new JLabel("Valasszon madarat:");
	private String[] Birds = {"DashBird","SlowBird","DestroyBird"};
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox madarval = new JComboBox(Birds);
	private JLabel nev = new JLabel("Adja meg a nevet:");
	private JTextField nevt= new JTextField();
	private String Nev = "Ismeretlen";
	
	public Menu() {
		
				
		//////////////////////////////Frame
		super("Turbo Flappy Bird");
		
		this.setLayout(new GridLayout(4,1));
		
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
       // setMinimumSize(new Dimension(WIDTH,HEIGHT));
       // setMaximumSize(new Dimension(WIDTH,HEIGHT));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		////////////////////////////////Button
		
		gamestart.setText("Start");
		gamestart.addActionListener(this);
		gamestart.setPreferredSize(new Dimension(150,50));
		
		eredmeny.setText("Eredmenyek");
		eredmeny.addActionListener(this);
		eredmeny.setPreferredSize(new Dimension(150,50));
		
		Kaosz.setText("Kaosz mod!");
		Kaosz.addActionListener(this);
		Kaosz.setPreferredSize(new Dimension(150,50));
	
	
		
		/////////////////////////////Panel
		JPanel panel = new JPanel();
		
		panel.add(gamestart);
		panel.add(eredmeny);
		///////////////
		JPanel panel2 = new JPanel();
		panel2.add(valassz);
		madarval.setPreferredSize(new Dimension(150,50));
		panel2.add(madarval);
			
		///////////
		JPanel panel3 = new JPanel();
	
		panel3.add(Kaosz);
		///////////
		JPanel panel4 = new JPanel();
		panel4.add(nev);
		nevt.setEditable(true);
		nevt.setPreferredSize(new Dimension(200,30));
		panel4.add(nevt);
		/////////////////
		this.add(panel);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		this.pack();
		this.setVisible(true);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==gamestart) {
			Nev = nevt.getText();
			if(Nev.equals(""))
				Nev = "Ismeretlen";
			if(madarval.getSelectedItem().toString()=="DashBird")
			{
			 new Game(new DashBird(Color.pink.darker()),false,Nev);
			 dispose();
			 
			}else if(madarval.getSelectedItem().toString()=="SlowBird") {
				
				new Game(new SlowBird(Color.yellow),false,Nev);
				 dispose();
			}	
			else if(madarval.getSelectedItem().toString()=="DestroyBird") {
				
				new Game(new DestroyBird(Color.black),false,Nev);
				 dispose();
				
				
			
			}
		}
		//////////////////////////////////
		
		
		if(e.getSource()==Kaosz) {
			Nev = nevt.getText();
			
			new Game(new Bird(Color.red),true,Nev);
			 dispose();
			
			
		}
		if(e.getSource()==eredmeny) {
			
			Eredmenyek el = new Eredmenyek();
			el.kiir();
			 
			
			
		}
		
		
	}
	
	public String GetName() {
		return Nev;
		
		
	}
	
	
}
