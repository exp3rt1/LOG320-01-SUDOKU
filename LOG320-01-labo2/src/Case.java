import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;


public class Case 
{
	public HashMap<Integer, Integer> hintHashTable = new HashMap<Integer, Integer>();
    public int caseValue;
    
    public Case(int value)
    {
        this.caseValue = value;
    }
    
    public HashMap<Integer, Integer> getIndice(Ligne ligne, Colonne colonne, Block block)
    {
    	hintHashTable.clear();
    	
    	for (int i = 1; i < ligne.getIndice().size()+1; i++) 
    	{
    		if(ligne.getIndice().get(i) == 0)
    		{
    			if(colonne.getIndice().get(i) == 0)
    			{
    				if(block.getIndice().get(i) == 0)
        			{
    					hintHashTable.put(i, 0);
        			}
    			}
    		}
		}
    	
        return hintHashTable;
    }
}
