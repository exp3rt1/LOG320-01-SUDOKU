
public class Table 
{
	private int totalNbOfLines, totalNbOfColumns;
	private Case[][] caseArray;

	public Table(Case[][] caseArray)
	{
		totalNbOfLines = 9;
		totalNbOfColumns = 9;
		this.caseArray = caseArray;
	}
	
    
    public boolean disableHints(int line, int column, int hint)
    {
    	Block block1, block2;
    	Case c;
    	int ligne, colonne, value;
    	boolean valide = true;
    	
    	block1 = this.getBlock(line, column);
    	
    	// Ligne (de haut en bas)
    	for (int i = 0; i < totalNbOfLines; i++) 
    	{
			// Ligne
    		if(i != line)
    		{
	    		valide = this.disableHintLineColumn(i, column, hint, block1, false);
    		}
    		
    		// Colonne
    		if(i != column)
    		{
    			valide = this.disableHintLineColumn(line, i, hint, block1, false);
    		}
    		
    		// Block
    		ligne = block1.getLineStart() + (int)Math.floor(i/3);
    		colonne = block1.getColumnStart() + (i%3);
    		c = this.getCase(ligne, colonne);
    		
    		if((column != colonne) && (line != ligne))
    		{
	    		if(!c.getIsDefaultValue())
	    		{
	    			if(c.disableHint(hint))
	    			{
	    				if(c.caseValue != 0)
	    				{
	    					if(valide)
	    					{
	    						valide = this.disableHints(ligne, colonne, c.caseValue);
	    						
	    						if(!valide)
	    		    				this.enableHints(ligne, colonne, c.caseValue);
	    					}
	    				}
	    			}
	    			else
	    			{
	    				valide = false;
	    			}
	    		}
    		}
		}
    	
    	return valide;
    }
    
    public boolean disableHintLineColumn(int line, int column, int hint, Block block1, boolean v)
    {
    	Block block2 = this.getBlock(line,column);
		Case c = this.getCase(line, column);
		boolean valide = v;
		
		if(!c.getIsDefaultValue())
		{
    		if(!(block1.getLineStart() == block2.getLineStart() && block1.getColumnStart() == block2.getColumnStart()))
    		{
    			if(c.disableHint(hint))
    			{
    				if(c.caseValue != 0)
    				{
    					if(valide)
    					{
    						valide = this.disableHints(line, column, c.caseValue);
    						
    						if(!valide)
    		    				this.enableHints(line, column, c.caseValue);
    						
    						return valide;
    					}    					
    				}
    				
    				return true;
    			}
    			else
    			{
    				return false;
    			}
    		}
		}
		
		return true;
    }
    
    public void enableHints(int line, int column, int hint)
    {
    	
    	Block block1, block2;
    	int ligne, colonne, value;
    	Case c;
    	
    	block1 = this.getBlock(line, column);
    	
    	// Ligne (de haut en bas)
    	for (int i = 0; i < totalNbOfLines; i++) 
    	{
    		// Ligne
    		if(i != line)
    			this.enableHintLineColumn(i, column, hint, block1);
    		
    		// Colonne
    		if(i != column)
    			this.enableHintLineColumn(line, i, hint, block1);
    		
    		// Block
    		ligne = block1.getLineStart() + (int)Math.floor(i/3);
    		colonne = block1.getColumnStart() + (i%3);
    		c = this.getCase(block1.getLineStart() + ((int)Math.floor(i/3)), block1.getColumnStart() + (i%3));
    		value = c.caseValue;
    		
    		if(!c.getIsDefaultValue())
    		{
	    		if(column != colonne && line != ligne)
		    		if(value == 0)
		    			if(c.enableHint(hint) == true)
		    			{
		    				this.enableHints(ligne, colonne, value);
		    				c.caseValue = 0;
		    			}
    		}
		}
    }
    
    public void enableHintLineColumn(int line, int column, int hint, Block block1)
    {
    	Block block2 = this.getBlock(line,column);
    	Case c = this.getCase(line, column);
    	int value = c.caseValue;
    	
    	if(!c.getIsDefaultValue())
		{
			if(value == 0)
	    		if(!(block1.getLineStart() == block2.getLineStart() && block1.getColumnStart() == block2.getColumnStart()))
	    			if(c.enableHint(hint) == true)
	    			{
	    				this.enableHints(line, column, value);
	    				c.caseValue = 0;
	    			}
		}
    }
    
    public Case getCase(int line, int column)
    {
    	return caseArray[line][column];
    }
    
    public Block getBlock(int line, int column)
    {
        int blockLine = (int) Math.floor(line/3) * 3;
        int blockColumn = (int) Math.floor(column/3) * 3;
    	
    	return new Block(blockLine, blockLine+3, blockColumn, blockColumn+3);
    }
    
    public boolean caseValide(int nombre, int ligne, int colonne)
    {
    	if(this.blocValide(nombre, ligne, colonne))
    	{
    		if(this.colonneValide(nombre, ligne, colonne))
    		{
	    		if(this.ligneValide(nombre, ligne, colonne))
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
