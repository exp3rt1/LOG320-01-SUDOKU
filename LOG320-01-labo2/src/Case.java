import java.util.ArrayList;


public class Case {
    public Integer[] hintArray = new Integer[9];
    public int caseValue;
    
    public Case(int value){
        this.caseValue = value;
    }
    
    public Case(int value, Integer[] hintArray){
        this.caseValue = value;
        this.hintArray = hintArray;
    }
    
    public boolean equals(Case o){
        if(this.caseValue == o.caseValue) 
            return true;
        return false;
    }
    
    public void removeHint(int hint){
    	this.hintArray[hint-1] = null;
    }
}
