import java.util.ArrayList;
import java.util.Hashtable;


public class Case 
{
    public Hashtable<Integer, Integer> hintHashTable = new Hashtable<Integer, Integer>();
    private Hashtable<Integer, Integer> indices = new Hashtable<Integer, Integer>();
    public int caseValue;
    private int nbHints = 9;
    private boolean isDefaultValue = false;
    
    public Case(int value)
    {
        this.caseValue = value;
        for(int i=9; i > 0; i--)
        {
            hintHashTable.put(i, 0);
            indices.put(i, 0);
        }
    }
    
    /**
     * Réduit le nombre de disable de l'indice jusqu'à 0
     * @param hint
     */
    public boolean enableHint(int hint)
    {
    	if(hint != 0)
    	{
	    	int value = this.hintHashTable.get(hint);
	    	
	        if(value > 0)
	        {        	
	            this.hintHashTable.put(hint, value-1);
	            
	            if(this.hintHashTable.get(hint) == 0)
	            {
	            	this.indices.put(hint, 0);
	            	return true;
	            }
	        }
    	}
        return false;
    }
    
    /**
     * Permet au hint de la case d'être désactivé selon le nombre de fois appelé
     * @param hint
     */
    public boolean disableHint(int hint)
    {
    	int value = this.hintHashTable.get(hint);
    	
        if(value < 3)
        {        	
        	this.hintHashTable.put(hint, value+1);
        	this.indices.remove(hint);
        	
        	if(this.indices.size() > 1)
        	{
        		return true;
        	}
        	else if(this.indices.size() == 1)
        	{
            	this.caseValue = (int) this.indices.keySet().toArray()[0];
        		return true;
        	}
        	else if(this.indices.size() == 0)
        	{
        		return false;
        	}
        }
        
        return false;
    }
    
    public void setDefaultValue(boolean value)
    {
    	this.isDefaultValue = value;
    }
    
    public boolean getIsDefaultValue()
    {
    	return this.isDefaultValue;
    }
}
