import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;


public class Table 
{
	private int totalNbOfLines, totalNbOfColumns;
	private Case[][] caseArray;
	private Ligne[] ligneArray = new Ligne[9];
	private Colonne[] colonneArray = new Colonne[9];
	private Block[] blockArray = new Block[9];

	public Table(Case[][] caseArray)
	{
		this.totalNbOfLines = 9;
		this.totalNbOfColumns = 9;
		this.caseArray = caseArray;
		this.initialiser();
	}
	
	public void initialiser()
	{
		int ligne, colonne;
		
		for (int i = 0; i < ligneArray.length; i++) 
		{
			ligneArray[i] = new Ligne();
			colonneArray[i] = new Colonne();
			blockArray[i] = new Block();
			
			for (int j = 0; j < ligneArray.length; j++) 
			{
				if(this.caseArray[i][j].caseValue != 0)
					ligneArray[i].disableHint(this.caseArray[i][j].caseValue);
				
				if(this.caseArray[j][i].caseValue != 0)
					colonneArray[i].disableHint(this.caseArray[j][i].caseValue);
				
				ligne = (int)Math.floor(j/3) + (int)Math.floor(i/3)*3;
				colonne = (j%3) + ((i*3)%9);
				
				if(this.caseArray[ligne][colonne].caseValue != 0)
					blockArray[i].disableHint(this.caseArray[ligne][colonne].caseValue);
			}
		}
	}
	
    
    public void disableHints(int line, int column, int hint)
    {
    	ligneArray[line].disableHint(hint);
    	colonneArray[column].disableHint(hint);    	
    	this.getBlock(line, column).disableHint(hint);
    }
    
    public void enableHints(int line, int column, int hint)
    {
    	ligneArray[line].enableHint(hint);
    	colonneArray[column].enableHint(hint);        
        this.getBlock(line, column).enableHint(hint);
    }
    
    public HashMap<Integer, Integer> getIndicesCase(Case c, int line, int column)
    {    	
    	return c.getIndice(ligneArray[line], colonneArray[column], this.getBlock(line, column));
    }
    
    public Case getCase(int line, int column)
    {
    	return caseArray[line][column];
    }
    
    public Block getBlock(int line, int column)
    {
    	int blockLine = (int) Math.floor(line/3) * 3;
        int blockColumn = (int) Math.floor(column/3);
        
    	return blockArray[blockLine+blockColumn];
    }
    
    public boolean caseValide(int nombre, int ligne, int colonne)
    {
    	if(this.ligneArray[ligne].getIndice().get(nombre) != 1)
    	{
    		if(this.colonneArray[colonne].getIndice().get(nombre) != 1)
    		{
    			if(this.getBlock(ligne, colonne).getIndice().get(nombre) != 1)
    			{
    				return true;
    			}
    		}
    	}
    	
    	return false;
    }
    
    // le nombre a vérifié avec sa position en ligne et en colonne
    public boolean ligneValide(int nombre, int ligne, int colonne)
    {
    	boolean valide = true;
    	
    	for(int i=0; i < totalNbOfLines; i++)
		{
			if(caseArray[i][colonne].caseValue == nombre && nombre != 0)
			{
				if(i != ligne)
				{
					valide = false;
				}
			}
		}
    	
    	return valide;
    }
    
    // le nombre a vérifié avec sa position en ligne et en colonne
    public boolean colonneValide(int nombre, int ligne, int colonne)
    {
    	boolean valide = true;
    	
    	for(int i=0; i < totalNbOfColumns; i++)
		{
			if(caseArray[ligne][i].caseValue == nombre && nombre != 0)
			{
				if(i != colonne)
				{
					valide = false;
				}
			}
		}
    	
    	return valide;
    }
    
    // le nombre a vérifié avec sa position en ligne et en colonne
    public boolean blocValide(int nombre, int ligne, int colonne)
    {
    	boolean valide = true;
    	int blocLigne = (int) Math.floor(ligne/3)*3;
		int blocColonne = (int) Math.floor(colonne/3)*3;
		
		for(int i=blocLigne; i < blocLigne+3; i++)
		{
			for(int j=blocColonne; j < blocColonne+3; j++)
			{
				if(caseArray[i][j].caseValue == nombre && nombre != 0)
				{
					if(i != ligne && j != colonne)
					{
						valide = false;
					}
				}
			}
		}
		
		return valide;
    }
    
    public Case[][] getCaseArray()
    {
    	return this.caseArray;
    }

}
