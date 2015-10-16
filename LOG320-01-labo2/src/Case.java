import java.util.ArrayList;
import java.util.Hashtable;


public class Case 
{
    private ArrayList<Integer> hintHashTable = new ArrayList();
	// public Hashtable<Integer, Integer> hintHashTable = new Hashtable<Integer, Integer>();
    public int caseValue;
    
    public Case(int value)
    {
        this.caseValue = value;
    }
    
    public ArrayList<Integer> getIndice(Ligne ligne, Colonne colonne, Block block)
    {
    	hintHashTable.clear();
    	
    	for (int i = 1; i < ligne.getIndice().size()+1; i++) 
    	{
    		if(ligne.getIndice().containsKey(i))
    		{
    			if(colonne.getIndice().containsKey(i))
    			{
    				if(block.getIndice().containsKey(i))
        			{
    					hintHashTable.add(i);
        			}
    			}
    		}
		}
    	
        return hintHashTable;
    }
}
