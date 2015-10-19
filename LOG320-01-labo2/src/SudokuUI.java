import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SudokuUI extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JTextField sudoku[][] = null;
	private Case cases[][] = null;
	static long date1 = 0;
	static long date2 = 0;
	private JLabel temps = null;
	
	public SudokuUI()
	{
		this.setSize(380,300);
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
				sudoku[i][j].setEditable(false);
			}
		}		

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
					
					SudokuUI.this.cases = algo.algorithme();
					SudokuUI.this.calculerTemps();
					
					if(SudokuUI.this.cases != null)
						SudokuUI.this.afficheSudoku(SudokuUI.this.cases);
					else
						JOptionPane.showMessageDialog(SudokuUI.this, "Pas de solutions!");
				}
			}
		 });
		
		this.temps = new JLabel("Temps : ");
		this.add(this.temps);
		this.temps.setBounds(250, 90, 120, 20);
		
		//add controls and place them
		add(btnSolve);
		btnSolve.setBounds(250, 10, 80, 20);
		add(btnImport);
		btnImport.setBounds(250, 40, 80, 20);
		
		//Set-up the window		
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void calculerTemps()
	{
		SudokuUI.date2 = System.currentTimeMillis();
		float total = SudokuUI.date2-SudokuUI.date1;
		// mettre dans un display box
		this.temps.setText("Temps : " + String.format("%.3f", total/1000));
	}
	
	public void afficheSudoku(Case cases[][])
	{
		this.reinitialiserSudoku();
		for (int i = 0; i < sudoku.length; i++) 
		{
			for (int j = 0; j < sudoku.length; j++) 
			{
				if(cases[i][j].caseValue != 0)
					sudoku[i][j].setText("" + cases[i][j].caseValue);
			}
		}
	}
	
	public void reinitialiserSudoku()
	{
		for (int i = 0; i < sudoku.length; i++) 
		{
			for (int j = 0; j < sudoku.length; j++) 
			{
				sudoku[i][j].setText("");
			}
		}
	}
}
