
public class main {
	static Table table = new Table();
	
	public static void main(String[] args) {
		
		new SudokuUI();
		// TODO: table removeHints des éléments non null sorti du fichier
	}
	
	
	
	public void algorithme()
	{
		recursif1(0,0);
	}
	
	//TODO: a revoir, je vais regarder plus en détail mardi
	public void recursif(Table table, int i, int j, Case tableCase)
	{
		i=0;
		j=0;
		int k=0;
		
		if(!table.getBlock(i,j).validBlock())
			return;
		
		tableCase = table.getCase(i, j);
		
		while(k != tableCase.hintArray.length)
		{
			if(tableCase.hintArray[k] != null)
			{
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
	
	
	//TODO: a revoir
	public void recursif1(int ligne, int colonne)
	{
		Case tableCase = table.getCase(ligne, colonne);
		
		// Arraylist?
		for(int i=0; i < tableCase.hintArray.length; i++)
		{
			// vérifie si il y a pas d'erreur causé par des case avant
			if(!table.getBlock(ligne,colonne).validBlock())
				return;
			
			// Met la valeur dans le tableau
			tableCase.caseValue = tableCase.hintArray[i];
			
			// enlever les indices semblables à celui qui vient d'etre insérer sur la ligne, colonnes, et block
		
			if(colonne == 8)
			{
				recursif1(ligne++, 0);
			}
			else
			{
				recursif1(ligne, colonne++);
			}
		}
	}
}
