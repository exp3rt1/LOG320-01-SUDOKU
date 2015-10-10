import java.util.ArrayList;


public class Block {
        private int maxLength = 3;
        Case[][] caseArray = new Case[maxLength][maxLength];
        
        public void fillBlock(int i, int j, Case value){
            if(i < maxLength && maxLength > j)
            	caseArray[i][j] = value;
        }
        
        public void fillBlock(Case[][] block){
            if(block.length == caseArray.length)
            	caseArray = block;
        }
        
        public boolean validBlock(){
            ArrayList<Integer> values = new ArrayList<Integer>();
            for(int i=0; i != maxLength; ++i){
                for(int j=0; j != maxLength; ++j){
                    values.add((caseArray[i][j]).caseValue);
                }
            }
            for(int i=0; i != values.size(); ++i){
                for(int j=0; j != values.size(); ++j){
                    if(i != j){
                        if(values.get(i) == values.get(j))
                            return false;
                    }
                }
            }
            
            return true;
        }
        
        public Case getCase(int line, int column){
        	return caseArray[line][column];
        }

}
