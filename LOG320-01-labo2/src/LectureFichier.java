import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LectureFichier 
{
	private FileReader fichier = null;
	
	public LectureFichier(String nomFichier) throws FileNotFoundException
	{
		this.fichier = new FileReader("sudoku1.sud");
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
					System.out.print("mauvais");
					throw new FormatException();
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
	
	public boolean verifierTableValide()
	{
		// Vérifie s'il n'y a pas de chiffre qui se répète dans une ligne ou colonne ou une zone
		int[][] table = this.lecture();
		
		if(table != null)
		{
			for(int i=0; i < 9; i++)
			{
				for(int j=0; j < 9; j++)
				{
					for(int k=i+1; k < 9; k++)
					{
						if(k == 9)
						{
							k = 0;
						}
						else if(k == i)
						{
							break;
						}
						else if(table[i][k] == table[i][j])
						{
							return false;
						}
					}
					
					for(int k=j+1; k < 9; k++)
					{
						if(k == 9)
						{
							k = 0;
						}
						else if(k == j)
						{
							break;
						}
						else if(table[i][k] == table[i][j])
						{
							System.out.print("meme");
							return false;
						}
					}
					
					System.out.print(table[i][j]);
				}
				System.out.print("\n");
			}
			return true;
		}
		else
		{
			return false;
		}
	}
}