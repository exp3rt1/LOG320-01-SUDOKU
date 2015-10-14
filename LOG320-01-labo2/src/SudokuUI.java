import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SudokuUI extends JFrame {
	public SudokuUI(){
		this.setSize(350,290);
		this.getContentPane().setLayout(null);
		//declare grid
		
		JTextField a1 = new JTextField("");
		JTextField a2 = new JTextField("");
		JTextField a3 = new JTextField("");
		JTextField a4 = new JTextField("");
		JTextField a5 = new JTextField("");
		JTextField a6 = new JTextField("");
		JTextField a7 = new JTextField("");
		JTextField a8 = new JTextField("");
		JTextField a9 = new JTextField("");
		
		JTextField b1 = new JTextField("");
		JTextField b2 = new JTextField("");
		JTextField b3 = new JTextField("");
		JTextField b4 = new JTextField("");
		JTextField b5 = new JTextField("");
		JTextField b6 = new JTextField("");
		JTextField b7 = new JTextField("");
		JTextField b8 = new JTextField("");
		JTextField b9 = new JTextField("");
		
		JTextField c1 = new JTextField("");
		JTextField c2 = new JTextField("");
		JTextField c3 = new JTextField("");
		JTextField c4 = new JTextField("");
		JTextField c5 = new JTextField("");
		JTextField c6 = new JTextField("");
		JTextField c7 = new JTextField("");
		JTextField c8 = new JTextField("");
		JTextField c9 = new JTextField("");
		
		JTextField d1 = new JTextField("");
		JTextField d2 = new JTextField("");
		JTextField d3 = new JTextField("");
		JTextField d4 = new JTextField("");
		JTextField d5 = new JTextField("");
		JTextField d6 = new JTextField("");
		JTextField d7 = new JTextField("");
		JTextField d8 = new JTextField("");
		JTextField d9 = new JTextField("");
		
		JTextField e1 = new JTextField("");
		JTextField e2 = new JTextField("");
		JTextField e3 = new JTextField("");
		JTextField e4 = new JTextField("");
		JTextField e5 = new JTextField("");
		JTextField e6 = new JTextField("");
		JTextField e7 = new JTextField("");
		JTextField e8 = new JTextField("");
		JTextField e9 = new JTextField("");
		
		JTextField f1 = new JTextField("");
		JTextField f2 = new JTextField("");
		JTextField f3 = new JTextField("");
		JTextField f4 = new JTextField("");
		JTextField f5 = new JTextField("");
		JTextField f6 = new JTextField("");
		JTextField f7 = new JTextField("");
		JTextField f8 = new JTextField("");
		JTextField f9 = new JTextField("");
		
		JTextField g1 = new JTextField("");
		JTextField g2 = new JTextField("");
		JTextField g3 = new JTextField("");
		JTextField g4 = new JTextField("");
		JTextField g5 = new JTextField("");
		JTextField g6 = new JTextField("");
		JTextField g7 = new JTextField("");
		JTextField g8 = new JTextField("");
		JTextField g9 = new JTextField("");
		
		JTextField h1 = new JTextField("");
		JTextField h2 = new JTextField("");
		JTextField h3 = new JTextField("");
		JTextField h4 = new JTextField("");
		JTextField h5 = new JTextField("");
		JTextField h6 = new JTextField("");
		JTextField h7 = new JTextField("");
		JTextField h8 = new JTextField("");
		JTextField h9 = new JTextField("");
		
		JTextField i1 = new JTextField("");
		JTextField i2 = new JTextField("");
		JTextField i3 = new JTextField("");
		JTextField i4 = new JTextField("");
		JTextField i5 = new JTextField("");
		JTextField i6 = new JTextField("");
		JTextField i7 = new JTextField("");
		JTextField i8 = new JTextField("");
		JTextField i9 = new JTextField("");
		
		
		JLabel lblSource = new JLabel("Source");
		JLabel lblSourcePath = new JLabel("No file selected");
		
		JLabel lblDestination = new JLabel("Destination");
		JLabel lblDestinationPath = new JLabel("No destination selected");
		

		JButton btnImport = new JButton("Import");
		btnImport.addActionListener(new ActionListener()
	    {
		      public void actionPerformed(ActionEvent e)
		      {
		    	  //import
		    	  JFileChooser fileChooser = new JFileChooser();		    	  
		    	  int option = fileChooser.showOpenDialog(SudokuUI.this);
		    	  
		    	  if (option == JFileChooser.APPROVE_OPTION) 
		    	  {
		    		  try 
		    		  {
		    			  LectureFichier lectureFichier = new LectureFichier(fileChooser.getSelectedFile().getAbsolutePath());
		    			  Case[][] cases = lectureFichier.verifierTableValide();
		    			  
		    			  if(cases != null)
		    			  {
		    				  System.out.print("Fichier Valide");
		    				  Algorithme algo = new Algorithme(cases);
		    				  algo.algorithme();
		    			  }
		    			  else
		    			  {
		    				  System.out.print("Fichier non Valide");
		    			  }
		    		  } 
		    		  catch (FileNotFoundException e1) 
		    		  {
		    			  e1.printStackTrace();
		    		  }
		          }
		      }
		});
		
		JButton btnSolve = new JButton("Solve");
		btnSolve.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) 
			{
				//solve
			}
		 });
		
		//add controls and place them

		add(btnSolve);
		btnSolve.setBounds(250, 10, 80, 20);
		add(btnImport);
		btnImport.setBounds(250, 40, 80, 20);
		
		//add grid
		add(a1);
		a1.setBounds(10, 10, 20, 20);
		add(a2);
		a2.setBounds(10, 35, 20, 20);
		add(a3);
		a3.setBounds(10, 60, 20, 20);
		add(a4);
		a4.setBounds(35, 10, 20, 20);
		add(a5);
		a5.setBounds(35, 35, 20, 20);
		add(a6);
		a6.setBounds(35, 60, 20, 20);
		add(a7);
		a7.setBounds(60, 10, 20, 20);
		add(a8);
		a8.setBounds(60, 35, 20, 20);
		add(a9);
		a9.setBounds(60, 60, 20, 20);
		
		add(b1);
		b1.setBounds(90, 10, 20, 20);
		add(b2);
		b2.setBounds(90, 35, 20, 20);
		add(b3);
		b3.setBounds(90, 60, 20, 20);
		add(b4);
		b4.setBounds(115, 10, 20, 20);
		add(b5);
		b5.setBounds(115, 35, 20, 20);
		add(b6);
		b6.setBounds(115, 60, 20, 20);
		add(b7);
		b7.setBounds(140, 10, 20, 20);
		add(b8);
		b8.setBounds(140, 35, 20, 20);
		add(b9);
		b9.setBounds(140, 60, 20, 20);
		
		add(c1);
		c1.setBounds(170, 10, 20, 20);
		add(c2);
		c2.setBounds(170, 35, 20, 20);
		add(c3);
		c3.setBounds(170, 60, 20, 20);
		add(c4);
		c4.setBounds(195, 10, 20, 20);
		add(c5);
		c5.setBounds(195, 35, 20, 20);
		add(c6);
		c6.setBounds(195, 60, 20, 20);
		add(c7);
		c7.setBounds(220, 10, 20, 20);
		add(c8);
		c8.setBounds(220, 35, 20, 20);
		add(c9);
		c9.setBounds(220, 60, 20, 20);
		
		add(d1);
		d1.setBounds(10, 90, 20, 20);
		add(d2);
		d2.setBounds(10, 115, 20, 20);
		add(d3);
		d3.setBounds(10, 140, 20, 20);
		add(d4);
		d4.setBounds(35, 90, 20, 20);
		add(d5);
		d5.setBounds(35, 115, 20, 20);
		add(d6);
		d6.setBounds(35, 140, 20, 20);
		add(d7);
		d7.setBounds(60, 90, 20, 20);
		add(d8);
		d8.setBounds(60, 115, 20, 20);
		add(d9);
		d9.setBounds(60, 140, 20, 20);
		
		add(e1);
		e1.setBounds(90, 90, 20, 20);
		add(e2);
		e2.setBounds(90, 115, 20, 20);
		add(e3);
		e3.setBounds(90, 140, 20, 20);
		add(e4);
		e4.setBounds(115, 90, 20, 20);
		add(e5);
		e5.setBounds(115, 115, 20, 20);
		add(e6);
		e6.setBounds(115, 140, 20, 20);
		add(e7);
		e7.setBounds(140, 90, 20, 20);
		add(e8);
		e8.setBounds(140, 115, 20, 20);
		add(e9);
		e9.setBounds(140, 140, 20, 20);
		
		add(f1);
		f1.setBounds(170, 90, 20, 20);
		add(f2);
		f2.setBounds(170, 115, 20, 20);
		add(f3);
		f3.setBounds(170, 140, 20, 20);
		add(f4);
		f4.setBounds(195, 90, 20, 20);
		add(f5);
		f5.setBounds(195, 115, 20, 20);
		add(f6);
		f6.setBounds(195, 140, 20, 20);
		add(f7);
		f7.setBounds(220, 90, 20, 20);
		add(f8);
		f8.setBounds(220, 115, 20, 20);
		add(f9);
		f9.setBounds(220, 140, 20, 20);
		
		add(g1);
		g1.setBounds(10, 170, 20, 20);
		add(g2);
		g2.setBounds(10, 195, 20, 20);
		add(g3);
		g3.setBounds(10, 220, 20, 20);
		add(g4);
		g4.setBounds(35, 170, 20, 20);
		add(g5);
		g5.setBounds(35, 195, 20, 20);
		add(g6);
		g6.setBounds(35, 220, 20, 20);
		add(g7);
		g7.setBounds(60, 170, 20, 20);
		add(g8);
		g8.setBounds(60, 195, 20, 20);
		add(g9);
		g9.setBounds(60, 220, 20, 20);
		
		add(h1);
		h1.setBounds(90, 170, 20, 20);
		add(h2);
		h2.setBounds(90, 195, 20, 20);
		add(h3);
		h3.setBounds(90, 220, 20, 20);
		add(h4);
		h4.setBounds(115, 170, 20, 20);
		add(h5);
		h5.setBounds(115, 195, 20, 20);
		add(h6);
		h6.setBounds(115, 220, 20, 20);
		add(h7);
		h7.setBounds(140, 170, 20, 20);
		add(h8);
		h8.setBounds(140, 195, 20, 20);
		add(h9);
		h9.setBounds(140, 220, 20, 20);
		
		add(i1);
		i1.setBounds(170, 170, 20, 20);
		add(i2);
		i2.setBounds(170, 195, 20, 20);
		add(i3);
		i3.setBounds(170, 220, 20, 20);
		add(i4);
		i4.setBounds(195, 170, 20, 20);
		add(i5);
		i5.setBounds(195, 195, 20, 20);
		add(i6);
		i6.setBounds(195, 220, 20, 20);
		add(i7);
		i7.setBounds(220, 170, 20, 20);
		add(i8);
		i8.setBounds(220, 195, 20, 20);
		add(i9);
		i9.setBounds(220, 220, 20, 20);
		
		//Set-up the window
		
        setVisible(true);
	}
}
