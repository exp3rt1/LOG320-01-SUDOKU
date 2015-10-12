
public class main {
	static Table table = new Table();
	
	public static void main(String[] args) {
		
		new SudokuUI();
		// TODO: table removeHints des éléments non null sorti du fichier
	}
	
	
	
	public void algorithme(){
	    for(int i=0; i != 9; ++i){
	    	for(int j=0; j != 9; ++j){
		    	
		    }
	    }
	}
	
	//TODO: a revoir, je vais regarder plus en détail mardi
	public void recursif(Table table, int i, int j, Case tableCase){
		i=0;
		j=0;
		int k=0;
		
		if(!table.getBlock(i,j).validBlock())
			return;
		
		tableCase = table.getCase(i, j);
		
		while(k != tableCase.hintArray.length){
			if(tableCase.hintArray[k] != null){
				tableCase.caseValue = tableCase.hintArray[k];
				table.removeHints(i,j, tableCase.hintArray[k]);
				break;
			}
			++k;
		}
		
		++i;
		++j;
		
		recursif(table, i, j, tableCase);
	}

}
