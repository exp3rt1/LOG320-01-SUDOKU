import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LectureFichier 
{
	private FileReader fichier = null;
	
	public LectureFichier(String nomFichier) throws FileNotFoundException
	{
		this.fichier = new FileReader(nomFichier);
	}
	
	public int[][] lecture()
	{
		// Lit et vérifie si le fichier est du bon format
		BufferedReader br = new BufferedReader(this.fichier);
		String ligne = "";
		int[][] table = new int [9][9];
		
		try
		{
			String chiffre = "";
			for(int i=0; i < 9; i++)
			{				
				ligne = br.readLine();
				if(ligne.length() > 9)
				{
					throw new FormatException("Mauvais format");
				}
				
				for(int j=0; j < 9; j++)
				{
					chiffre = "" + ligne.charAt(j);
					try
					{
						table[i][j] = Integer.parseInt(chiffre);
					}
					catch(NumberFormatException nfe)
					{
						table[i][j] = 0;
					}
				}
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		} 
		catch (FormatException e) 
		{
			return null;
		}
		
		return table;
	}
	
	// retourne le tableau, si le format ou la table est valide
	public Case[][] verifierTableValide()
	{
		// Vérifie s'il n'y a pas de chiffre qui se répète dans une ligne ou colonne ou une zone
		int[][] table = this.lecture();
		
		if(table != null)
		{			
			for(int i=0; i < 9; i++)
			{
				for(int j=0; j < 9; j++)
				{
					if(!this.estValide(table, i, j, table[i][j]))
					{
						return null;
					}
				}
			}
			return remplirTable(table);
		}
		else
		{
			return null;
		}
	}
	
	public Case[][] remplirTable(int[][] table)
	{
		Case[][] cases = new Case[table.length][table.length];
		for (int i = 0; i < table.length; i++) 
		{
			for (int j = 0; j < table.length; j++) 
			{
				cases[i][j] = new Case(table[i][j]);
				
				if(cases[i][j].caseValue != 0)
					cases[i][j].setDefaultValue(true);
			}
		}
		
		return cases;
	}
	
	public boolean estValide(int[][] table, int x, int y, int nombre)
	{
		boolean valide = true;
		
		for(int i=0; i < 9; i++)
		{
			if(table[x][i] == nombre && nombre != 0)
			{
				if(i != y)
				{
					valide = false;
				}
			}
		}
		
		for(int i=0; i < 9; i++)
		{
			if(table[i][y] == nombre && nombre != 0)
			{
				if(i != x)
				{
					valide = false;
				}
			}
		}
		
		int blocLigne = (int) Math.floor(x/3)*3;
		int blocColonne = (int) Math.floor(y/3)*3;
		
		for(int i=blocLigne; i < blocLigne+3; i++)
		{
			for(int j=blocColonne; j < blocColonne+3; j++)
			{
				if(table[i][j] == nombre && nombre != 0)
				{
					if(i != x && j != y)
					{
						valide = false;
					}
				}
			}
		}
		
		return valide;
	}
}