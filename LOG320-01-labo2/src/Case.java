import java.util.ArrayList;
import java.util.Hashtable;


public class Case {
    public Hashtable<Integer, Integer> hintHashTable = new Hashtable<Integer, Integer>();
    public int caseValue;
    
    public Case(int value)
    {
        this.caseValue = value;
        for(int i=9; i > 0; i--)
        {
            hintHashTable.put(i, 0);
        }
    }
    
    public boolean equals(Case o){
        if(this.caseValue == o.caseValue) 
            return true;
        return false;
    }
    
    /**
     * Réduit le nombre de disable de l'indice jusqu'à 0
     * @param hint
     */
    public void enableHint(int hint)
    {
    	int value = this.hintHashTable.get(hint);
    	
        if(value > 0)
            this.hintHashTable.put(hint, value-1);
    }
    
    /**
     * Permet au hint de la case d'être désactivé selon le nombre de fois appelé
     * @param hint
     */
    public void disableHint(int hint)
    {
    	int value = this.hintHashTable.get(hint);
    	
        if(value < 3)
            this.hintHashTable.put(hint, value+1);
    }
    
    public Integer getNext(int index){
        for(int i=index+1; i <= 9; ++i){
            if(hintHashTable.get(i) != null)
                return hintHashTable.get(i);
        }
        return -1;
    }
}
