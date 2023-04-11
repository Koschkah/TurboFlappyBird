package flappy;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Eredmenyek implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String[][] eredmeny = new String[10][2];
	
	public Eredmenyek() {
		
		
		
		for(int i = 0;i<10;i++) {
			
			eredmeny[i][0]="Ismeretlen";
			eredmeny[i][1]="0";
			
		}
		
		
	}
	
	
	public void Save()  {
		
		 File fout = new File("Data.txt");

		 try {
			 BufferedWriter bwr = new BufferedWriter(new FileWriter(fout));


	        for (int i = 0; i < 10; i++) {
	        	
	            try {
						bwr.write(eredmeny[i][0]);
					 	bwr.newLine();
			            bwr.write(eredmeny[i][1]);
			            bwr.newLine();
					
	       } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	           
	        }
		bwr.close();
} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
		
	}
	
	public void Load() {
		
		File filein = new File("Data.txt");
        FileInputStream fin = null;
		try {
			fin = new FileInputStream(filein);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

        BufferedReader br = new BufferedReader(new InputStreamReader(fin));

       
        for (int i = 0; i < 10; i++) {
        	
            try {
            	eredmeny[i][0] = br.readLine();
				 	
            	eredmeny[i][1] = br.readLine();
		           
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
        }
		
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sort() {
		
		   String[] temp = null;  
	         for(int i=0; i < 10; i++){  
	                 for(int j=1; j < (10-i); j++){  
	                          if( Integer.valueOf(eredmeny[j-1][1]) <  Integer.valueOf(eredmeny[j][1])){  
	                                
	                                 temp = eredmeny[j-1];  
	                                 eredmeny[j-1] = eredmeny[j];  
	                                 eredmeny[j] = temp;  
	                         }  
	                          
	                 }  
	         }  
		
		
	}
	
	public void add(String n, int p) {
	Load();
		  for(int i=0; i < 10; i++){  
			  if( Integer.valueOf(eredmeny[i][1])< p) {
				  eredmeny[i][0] = n;
				  eredmeny[i][1] = String.valueOf(p);
				  break;
			  }
			 
			 
			  
			  
		  }
		  sort();
		Save();
		
		
	}
	
	public String get() {
		return eredmeny[0][0];
		
	}
	
	
	public void kiir() {
		Load();
		sort();
		String[] columnNames = {"Name","Point"};
		JTable table = new JTable(eredmeny, columnNames);
		JFrame frame = new JFrame();
		JPanel  panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		
		table.setSize(new Dimension(400,600));
		table.setPreferredSize(new Dimension(400,600));
		panel.add(scrollPane);
		frame.add(panel);
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(800,400));
		frame.setSize(new Dimension(800,400));
		frame.setResizable(false);
		
		
		
	}
	
	
	
	
}
