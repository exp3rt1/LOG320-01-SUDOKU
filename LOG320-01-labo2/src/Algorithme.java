import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class Algorithme 
{
	private Table table = null;
	private boolean reussi = false;
	private int noeud = 0;
	
	public Algorithme(Case[][] cases)
	{
		this.table = new Table(cases);
	}
	
	public Case[][] algorithme()
	{
		// Le temps commence ici
		this.cleanupHints();
		this.resoudreSudoku(0,0);
		
		if(!this.reussi)
		{
			// Si ca vient ici, le sudoku est invalid
			return null;
		}
		else
		{
			System.out.print(this.noeud);
			// une solution est possible
			// Le temps termine ici
			return this.table.getCaseArray();
		}
	}
	
	public void resoudreSudoku(int ligne, int colonne)
	{
		noeud++;
		Case tableCase = table.getCase(ligne, colonne);
		
		// Si la case a d�j� une valeur, donc le nombre d'indice est � 0
		if(tableCase.caseValue != 0)
		{
			if(colonne == 8)
			{
				if(ligne != 8)
				{
					this.resoudreSudoku(ligne+1, 0);
				}
				else
				{
					this.reussi = true;
				}
			}
			else
			{
				this.resoudreSudoku(ligne, colonne+1);
			}
		}
		else
		{
		
			Iterator<Map.Entry<Integer, Integer>> iterateur = tableCase.hintHashTable.entrySet().iterator();
			
			while(iterateur.hasNext() && !this.reussi)
			{
				// Met la valeur dans le tableau
				Entry<Integer,Integer> entree = iterateur.next();
				if(entree.getValue() == 0)
				{
					tableCase.caseValue = entree.getKey();
					this.afficheTable();
					
					// si la case mise est valide
					// if(table.caseValide(tableCase.caseValue, ligne, colonne))
					// {
						// enlever les indices semblables � celui qui vient d'etre ins�rer sur la ligne, colonnes, et block
					if(this.table.disableHints(ligne, colonne, tableCase.caseValue))
					{		
							this.afficheTable();
							if(colonne == 8)
							{
								if(ligne != 8)
								{
									this.resoudreSudoku(ligne+1, 0);
								}
								else
								{
									// dernier
									this.reussi = true;
								}
							}
							else
							{
								this.resoudreSudoku(ligne, colonne+1);
							}
					}
					
					if(!this.reussi)
						this.putHintsBack(ligne, colonne, tableCase.caseValue);
				}
			}
			
		}
	}

	
	public void cleanupHints()
	{
		Case currentCase;
		
		for(int i = 0; i < 9; i++)//lig
		{
			for(int j = 0; j < 9; j++)//col
			{
				currentCase = this.table.getCase(i, j);
				
				if (currentCase.getIsDefaultValue())//if case is empty
				{ 
					if(!table.disableHints(i, j, currentCase.caseValue))
					{
						this.putHintsBack(i, j, currentCase.caseValue);
					}
				}
			}
		}
	}
	
	/**
	 * Remet les hints par rapport � la case s�lectionner
	 * Met la valeur de la case a 0
	 * @param line
	 * @param column
	 */
	public void putHintsBack(int line, int column, int hint)
	{
	    table.enableHints(line, column, hint);
	    table.getCase(line, column).caseValue = 0;
	}
	
	public void afficheTable()
	{
		for (int i = 0; i < this.table.getCaseArray().length; i++) 
		{
			for (int j = 0; j < this.table.getCaseArray().length; j++)
			{
				System.out.print(this.table.getCase(i, j).caseValue);
			}
			
			System.out.print("\n");
		}
		
		System.out.print("\n");
	}
}

