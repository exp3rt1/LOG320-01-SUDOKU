
public class Table {
	private int totalNbOfLines, totalNbOfColumns;
	private int maxLength = 3;
	private Case[][] caseArray;

	public Table(Case[][] caseArray) {
		totalNbOfLines=9;
		totalNbOfColumns=9;
		caseArray = caseArray;
	}
	
    public void removeHints(int line, int column, int hint){
        this.getBlock(line, column);
    	for(int i=0; i != totalNbOfLines; ++i){
    		for(int j=0; j !=totalNbOfColumns; ++j){
    			if(i == line || j == column)
    				this.getCase(i,j).removeHint(hint);
    		}
    	}
    	//TODO: this.getBlock(line, column).removeHints(hint);
    }
    
    public void removeBlockHints(Block block){
      //TODO: block
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

}
