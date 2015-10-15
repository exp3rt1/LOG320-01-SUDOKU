
public class Table {
	private int totalNbOfLines, totalNbOfColumns;
	private int maxLength = 3;
	private Case[][] caseArray;

	public Table(Case[][] caseArray) {
		totalNbOfLines=9;
		totalNbOfColumns=9;
		this.caseArray = caseArray;
	}
	
    
    public void disableHints(int line, int column, int hint){
    	Block block = this.getBlock(line, column);
    	for(int i=0; i != totalNbOfLines; ++i){
    		for(int j=0; j !=totalNbOfColumns; ++j){
    			if((i == line || j == column) 
    			        && (line < block.getLineStart() || block.getLineEnd() > line)
    			        && (column < block.getColumnStart() || block.getColumnEnd() > column))
    				this.getCase(i,j).disableHint(hint);
    		}
    	}
    	
    	disableBlockHints(block, hint);
    }
    
    public void disableBlockHints(Block block, int hint){
    	for(int i=block.getLineStart(); i != block.getLineEnd(); ++i){
    	    for(int j=block.getColumnStart(); j !=block.getColumnEnd(); ++j)
    	        this.getCase(i, j).disableHint(hint);
    	}
    }
    
    public void enableHints(int line, int column, int hint){
        Block block = this.getBlock(line, column);
        for(int i=0; i != totalNbOfLines; ++i){
            for(int j=0; j !=totalNbOfColumns; ++j){
                if((i == line || j == column) 
                        && (line < block.getLineStart() || block.getLineEnd() > line)
                        && (column < block.getColumnStart() || block.getColumnEnd() > column))
                    this.getCase(i,j).enableHint(hint);
            }
        }
        
        enableBlockHints(block, hint);
    }
    
    private void enableBlockHints(Block block, int hint){
        for(int i=block.getLineStart(); i != block.getLineEnd(); ++i){
            for(int j=block.getColumnStart(); j !=block.getColumnEnd(); ++j)
                this.getCase(i, j).enableHint(hint);
        }
    }
    
    
    public Case getCase(int line, int column){
    	return caseArray[line][column];
    }
    
    public Block getBlock(int line, int column){
        int blockLine = (int) Math.floor(line/3) * 3;
        int blockColumn = (int) Math.floor(column/3) * 3;
    	
    	Block block = new Block(blockLine,blockLine+2,blockColumn, blockColumn+2);
    	return block;
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
    	
    	for(int i=0; i < 9; i++)
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
    	
    	for(int i=0; i < 9; i++)
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
