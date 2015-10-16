import java.util.ArrayList;
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
	
	public Case[][] algorithme()
	{
		// Le temps commence ici
		// this.cleanupHints();
		this.resoudreSudoku(0,0);
		
		if(!this.reussi)
		{
			// Si ca vient ici, le sudoku est invalid
			return null;
		}
		else
		{
			// une solution est possible
			// Le temps termine ici
			return this.table.getCaseArray();
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
		
			// Iterator<Map.Entry<Integer, Integer>> iterateur = this.table.getIndicesCase(tableCase, ligne, colonne).entrySet().iterator();
			ArrayList<Integer> liste = this.table.getIndicesCase(tableCase, ligne, colonne);
			Entry<Integer,Integer> entree;
			
			//while(iterateur.hasNext() && !this.reussi)
			//{
			for (int i = 0; i < liste.size() && !this.reussi; i++) 
			{
				// Met la valeur dans le tableau
				// entree = iterateur.next();
				//if(entree.getValue() == 0)
				
					tableCase.caseValue = liste.get(i);
					
					// si la case mise est valide
					if(table.caseValide(tableCase.caseValue, ligne, colonne))
					{
						// enlever les indices semblables à celui qui vient d'etre insérer sur la ligne, colonnes, et block
						this.table.disableHints(ligne, colonne, tableCase.caseValue);
						
						if(colonne == 8)
						{
							if(ligne != 8)
							{
								this.resoudreSudoku(ligne+1, 0);
								
								// Remettre les hints enlevés
								if(!this.reussi)
									this.putHintsBack(ligne, colonne, tableCase.caseValue);
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
							// Remettre les hints enleves
							if(!this.reussi)
								this.putHintsBack(ligne, colonne, tableCase.caseValue);
						}
					}
					else
					{
						tableCase.caseValue = 0;
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

