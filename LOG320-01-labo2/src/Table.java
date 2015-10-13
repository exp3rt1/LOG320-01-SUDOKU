
public class Table {
	private int totalNbOfLines, totalNbOfColumns;
	private int maxLength = 3;
    Block[][] blockArray = new Block[maxLength][maxLength];

	public Table() {
		totalNbOfLines=9;
		totalNbOfColumns=9;
	}
	
    public void removeHints(int line, int column, int hint){
    	for(int i=0; i != totalNbOfLines; ++i){
    		for(int j=0; j !=totalNbOfColumns; ++j){
    			if(i == line || j == column)
    				this.getCase(i,j).removeHint(hint);
    		}
    	}
    }
    
    public Case getCase(int line, int column){
    	int blockLine = (line+1) % 3;
    	int blockColumn = (column+1) % 3;
    	
    	Block block = blockArray[blockLine][blockColumn];
    	return block.getCase(blockLine, blockColumn);
    }
    
    public Block getBlock(int line, int column){
    	int blockLine = (line+1) % 3;
    	int blockColumn = (column+1) % 3;
    	
    	Block block = blockArray[blockLine][blockColumn];
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
			if(blockArray[i][colonne] == nombre && nombre != 0)
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
			if(blockArray[ligne][i] == nombre && nombre != 0)
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
				if(blockArray[i][j] == nombre && nombre != 0)
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

}
