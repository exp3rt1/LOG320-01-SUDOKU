import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class Algorithme 
{
	private Table table = null;
	private boolean reussi = false;
	
	public Algorithme(Case[][] cases)
	{
		this.table = new Table(cases);
	}
	
	public void algorithme()
	{
		// Le temps commence ici
		this.cleanupHints();
		this.resoudreSudoku(0,0);
		
		if(!this.reussi)
		{
			// Si ca vient ici, le sudoku est invalid
			
		}
		else
		{
			// une solution est possible
			// Le temps termine ici
		}
	}
	
	public void resoudreSudoku(int ligne, int colonne)
	{
		Case tableCase = table.getCase(ligne, colonne);
		
		// Si la case a déjà une valeur, donc le nombre d'indice est à 0
		if(tableCase.caseValue != 0)
		{
			if(colonne == 8)
			{
				if(ligne != 8)
				{
					this.resoudreSudoku(ligne++, 0);
				}
				else
				{
					this.reussi = true;
				}
			}
			else
			{
				this.resoudreSudoku(ligne, colonne++);
			}
		}
		
		Iterator<Map.Entry<Integer, Integer>> iterateur = tableCase.hintHashTable.entrySet().iterator();
		
		while(iterateur.hasNext())
		{
			if(!this.reussi)
			{
				// Met la valeur dans le tableau
				Entry<Integer,Integer> entree = iterateur.next();
				if(entree.getValue() == 0)
					tableCase.caseValue = iterateur.next().getKey();
				
				// enlever les indices semblables à celui qui vient d'etre insérer sur la ligne, colonnes, et block
				this.table.disableHints(ligne, colonne, tableCase.caseValue);
				
				// si la case mise est valide
				if(!table.caseValide(tableCase.caseValue, ligne, colonne))
				{
					if(colonne == 8)
					{
						if(ligne != 8)
						{
							// derniere
							this.resoudreSudoku(ligne+1, 0);
							// Remettre les hints enlevés
						}
						else
						{
							this.reussi = true;
						}
					}
					else
					{
						this.resoudreSudoku(ligne, colonne+1);
						// Remettre les hints enlevés
					}
				}
			}			
		}
	}

	
	public void cleanupHints()
	{
		Case currentCase;
		int compareValue;
		Block currentBlock;
		
		for(int j = 0; j<9; j++)//col
		{
			for(int i = 0; i<9; i++)//lig
			{
				currentCase = this.table.getCase(i, j);
				
				if (currentCase.caseValue > 0)//if case is empty
				{ 
					table.disableHints(i, j, currentCase.caseValue);
				}
			}
		}
	}
	
	/**
	 * Remet les hints par rapport à la case sélectionner
	 * Met la valeur de la case a 0
	 * @param line
	 * @param column
	 */
	public void putHintsBack(int line, int column){
	    table.enableHints(line, column, table.getCase(line, column).caseValue);
	    table.getCase(line, column).caseValue = 0;
	}
}

