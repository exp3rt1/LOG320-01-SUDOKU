import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SudokuUI extends JFrame 
{
	private JTextField sudoku[][] = null;
	private Case cases[][] = null;
	private float date1 = 0;
	private float date2 = 0;
	
	public SudokuUI()
	{
		this.setSize(350,290);
		this.getContentPane().setLayout(null);
		//declare grid
		
		
		this.sudoku = new JTextField[9][9];
		
		for (int i = 0; i < sudoku.length; i++) 
		{
			for (int j = 0; j < sudoku.length; j++) 
			{
				sudoku[i][j] = new JTextField("");
				add(sudoku[i][j]);
				
				int posY = i*25+10 + (int)Math.floor(i/3) * 5, posX = j*25+10 + (int)Math.floor(j/3) * 5;
				
				sudoku[i][j].setBounds(posX, posY, 20, 20);
				sudoku[i][j].setHorizontalAlignment(JTextField.CENTER);
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
		    			  SudokuUI.this.cases = lectureFichier.verifierTableValide();
		    			  
		    			  if(SudokuUI.this.cases != null)
		    			  {
		    				  SudokuUI.this.afficheSudoku(SudokuUI.this.cases);
		    			  }
		    			  else
		    			  {
		    				  JOptionPane.showMessageDialog(SudokuUI.this, "Le fichier n'est pas du bon ou le sudoku remis a mal été fait!");
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
				if(SudokuUI.this.cases != null)
				{
					Algorithme algo = new Algorithme(SudokuUI.this.cases);
					SudokuUI.this.date1 = System.currentTimeMillis();
					SudokuUI.this.cases = algo.algorithme();
					SudokuUI.this.calculerTemps();
					
					if(SudokuUI.this.cases != null)
						SudokuUI.this.afficheSudoku(SudokuUI.this.cases);
				}
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
	
	public void calculerTemps()
	{
		this.date2 = System.currentTimeMillis();
		// mettre dans un display box
		System.out.printf("%.2f",(float)((this.date2-this.date1)/1000));
	}
	
	public void afficheSudoku(Case cases[][])
	{
		for (int i = 0; i < sudoku.length; i++) 
		{
			for (int j = 0; j < sudoku.length; j++) 
			{
				if(cases[i][j].caseValue != 0)
					sudoku[i][j].setText("" + cases[i][j].caseValue);
			}
		}
	}
}
