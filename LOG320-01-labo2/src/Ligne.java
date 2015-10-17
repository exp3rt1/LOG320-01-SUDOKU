import java.util.HashMap;
import java.util.Hashtable;


public class Ligne 
{
	private HashMap<Integer, Integer> indiceTable = new HashMap<Integer, Integer>();
	private int longueur = 9;
	
	public Ligne()
	{
		this.initialiseIndiceTable();
	}
	
	public void initialiseIndiceTable()
	{
		for (int i = this.longueur; i > 0; i--) 
		{
			this.indiceTable.put(i, 0);
		}
	}
	
	/**
     * R�duit le nombre de disable de l'indice jusqu'� 0
     * @param hint
     */
    public void enableHint(int hint)
    {
    	this.indiceTable.put(hint, 0);
    }
    
    /**
     * Permet au hint de la case d'�tre d�sactiv� selon le nombre de fois appel�
     * @param hint
     */
    public void disableHint(int hint)
    {
        this.indiceTable.put(hint, 1);
    }
    
    public HashMap<Integer, Integer> getIndice()
    {
    	return this.indiceTable;
    }
}
