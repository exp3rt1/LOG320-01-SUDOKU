import java.util.ArrayList;


public class Block {
        private int maxLength = 3;
        Case[][] blockArray = new Case[maxLength][maxLength];
        
        public void fillBlock(int i, int j, Case value){
            if(i < maxLength && maxLength > j)
                blockArray[i][j] = value;
        }
        
        public void fillBlock(Case[][] block){
            if(block.length == blockArray.length)
                blockArray = block;
        }
        
        public boolean validBlock(){
            ArrayList<Integer> values = new ArrayList<Integer>();
            for(int i=0; i != maxLength; ++i){
                for(int j=0; j != maxLength; ++j){
                    values.add((blockArray[i][j]).value);
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

}
