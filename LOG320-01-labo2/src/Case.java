import java.util.ArrayList;


public class Case {
    public ArrayList<Integer> possibilities = new ArrayList<Integer>();
    public int value;
    
    public Case(int value){
        this.value = value;
    }
    
    public Case(int value, ArrayList<Integer> possibilities){
        this.value = value;
        this.possibilities = possibilities;
    }
    
    public boolean equals(Case o){
        if(this.value == o.value) 
            return true;
        return false;
    }
}
