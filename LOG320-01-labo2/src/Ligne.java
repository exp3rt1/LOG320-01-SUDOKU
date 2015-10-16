import java.util.Hashtable;


public class Ligne 
{
	private Hashtable<Integer, Integer> indiceTable = new Hashtable<Integer, Integer>();
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
     * Réduit le nombre de disable de l'indice jusqu'à 0
     * @param hint
     */
    public void enableHint(int hint)
    {
    	this.indiceTable.put(hint, 0);
    }
    
    /**
     * Permet au hint de la case d'être désactivé selon le nombre de fois appelé
     * @param hint
     */
    public void disableHint(int hint)
    {
        this.indiceTable.remove(hint);
    }
    
    public Hashtable<Integer, Integer> getIndice()
    {
    	return this.indiceTable;
    }
}
