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
		
		
		JTextField sudoku[][] = new JTextField[9][9];
		
		for (int i = 0; i < sudoku.length; i++) 
		{
			for (int j = 0; j < sudoku.length; j++) 
			{
				sudoku[i][j] = new JTextField("");
				add(sudoku[i][j]);
				
				int posY = i*25+10 + (int)Math.floor(i/3) * 5, posX = j*25+10 + (int)Math.floor(j/3) * 5;
				
				sudoku[i][j].setBounds(posY, posX, 20, 20);
			}
		}		
		
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
		
		//Set-up the window
		
        setVisible(true);
	}
}
