
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

}
