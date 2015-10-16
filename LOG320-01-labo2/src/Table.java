
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
	
    
    public void disableHints(int line, int column, int hint)
    {
    	Block block1, block2;
    	
    	block1 = this.getBlock(line, column);
    	
    	// Ligne (de haut en bas)
    	for (int i = 0; i < totalNbOfLines; i++) 
    	{
    		block2 = this.getBlock(i,column);
    		
    		// if(this.getCase(i, column).caseValue == 0 && i != line)
    		if(!(block1.getLineStart() == block2.getLineStart() && block1.getColumnStart() == block2.getColumnStart()))
    			this.getCase(i,column).disableHint(hint);
		}
    	
    	// colonne (de gauche à droite)
    	for (int i = 0; i < totalNbOfColumns; i++) 
    	{
    		block2 = this.getBlock(line,i);
    		
    		// if(this.getCase(line, i).caseValue == 0 && i != column)
    		if(!(block1.getLineStart() == block2.getLineStart() && block1.getColumnStart() == block2.getColumnStart()))
    			this.getCase(line,i).disableHint(hint);
		}
    	
    	disableBlockHints(block1, line, column, hint);
    }
    
    public void disableBlockHints(Block block, int line, int column, int hint)
    {
    	for(int i=block.getLineStart(); i < block.getLineEnd(); ++i)
    	{
    	    for(int j=block.getColumnStart(); j < block.getColumnEnd(); ++j)
    	    {
    	    	// if(this.getCase(i, j).caseValue == 0 && (i != line && j != column))
    	        this.getCase(i, j).disableHint(hint);
    	    }
    	}
    }
    
    public void enableHints(int line, int column, int hint)
    {
    	
    	Block block1, block2;
    	
    	block1 = this.getBlock(line, column);
    	
    	// Ligne (de haut en bas)
    	for (int i = 0; i < totalNbOfLines; i++) 
    	{
    		block2 = this.getBlock(i,column);
    		
    		// if(this.getCase(i, column).caseValue == 0 && i != line)
    		if(!(block1.getLineStart() == block2.getLineStart() && block1.getColumnStart() == block2.getColumnStart()))
    			this.getCase(i,column).enableHint(hint);
		}
    	
    	// colonne (de gauche à droite)
    	for (int i = 0; i < totalNbOfColumns; i++) 
    	{
    		block2 = this.getBlock(line,i);
    		
    		// if(this.getCase(line, i).caseValue == 0 && i != column)
    		if(!(block1.getLineStart() == block2.getLineStart() && block1.getColumnStart() == block2.getColumnStart()))
    			this.getCase(line,i).enableHint(hint);
		}
        
        enableBlockHints(block1, line, column, hint);
    }
    
    private void enableBlockHints(Block block, int line, int column, int hint)
    {
        for(int i=block.getLineStart(); i != block.getLineEnd(); ++i)
        {
            for(int j=block.getColumnStart(); j != block.getColumnEnd(); ++j)
            {
            	// if(this.getCase(i, j).caseValue == 0 && (i != line && j != column))
            	this.getCase(i, j).enableHint(hint);
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
