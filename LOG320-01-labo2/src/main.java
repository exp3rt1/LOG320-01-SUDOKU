import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class main {
	static Table table = new Table();
	
	public static void main(String[] args) {
		
		new SudokuUI();
		// TODO: table removeHints des �l�ments non null sorti du fichier
	}
	
	
	
	public void algorithme()
	{
		recursif1(0,0);
		
		// Si ca vient ici, le sudoku est invalid
	}
	
	//TODO: a revoir, je vais regarder plus en d�tail mardi
	/*public void recursif(Table table, int i, int j, Case tableCase)
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
	}*/
	
	
	//TODO: a revoir
	public void recursif1(int ligne, int colonne)
	{
		Case tableCase = table.getCase(ligne, colonne);
		
		// Si la case a d�j� une valeur, donc le nombre d'indice est � 0
		if(tableCase.caseValue == 0)
		{
			if(colonne == 8)
			{
				if(ligne != 8)
				{
					colonne = 0;
					tableCase = table.getCase(ligne++, colonne);
				}
			}
			else
			{
				tableCase = table.getCase(ligne, colonne++);
			}
		}
		
		//Enumeration<Integer> cle = tableCase.hintHashTable.keys();
		Iterator<Map.Entry<Integer, Integer>> iterateur = tableCase.hintHashTable.entrySet().iterator();
		
		// Arraylist?
		while(iterateur.hasNext())
		{		
			// Met la valeur dans le tableau
			tableCase.caseValue = iterateur.next().getKey();
			
			// enlever les indices semblables � celui qui vient d'etre ins�rer sur la ligne, colonnes, et block
			
			// si la case mise est valide
			if(!table.getBlock(ligne,colonne).validBlock())
			{
				if(colonne == 8)
				{
					if(ligne != 8)
					{
						// derniere
						recursif1(ligne+1, 0);
					}
				}
				else
				{
					recursif1(ligne, colonne+1);
				}
			}
			
			
		}
	}
}
