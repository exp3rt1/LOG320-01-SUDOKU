import java.util.ArrayList;
import java.util.Hashtable;


public class Case {
    public Hashtable<Integer, Integer> hintHashTable = new Hashtable<Integer, Integer>();
    public int caseValue;
    
    public Case(int value){
        this.caseValue = value;
    }
    
    public Case(int value, Hashtable<Integer, Integer> hintHashTable){
        this.caseValue = value;
        
        this.hintHashTable = hintHashTable;
    }
    
    public boolean equals(Case o){
        if(this.caseValue == o.caseValue) 
            return true;
        return false;
    }
    
    public void removeHint(int hint){
    	this.hintHashTable.remove(hint);
    }
    
    public void disableHint(int hint){
    	this.hintHashTable.put(hint, 1);
    }
    
    public Integer getNext(int index){
        for(int i=index+1; i <= 9; ++i){
            if(hintHashTable.get(i) != null)
                return hintHashTable.get(i);
        }
        return -1;
    }
}
