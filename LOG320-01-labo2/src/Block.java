import java.util.ArrayList;
import java.util.Hashtable;


public class Block 
{
        private int lineStart;
        private int lineEnd;
        private int columnStart;
        private int columnEnd;
        private Hashtable<Integer, Integer> indiceTable = new Hashtable<Integer, Integer>();
    	private int longueur = 9;
    	
    	public Block()
    	{
    		this.initialiseIndiceTable();
    	}
        
        public Block(int lineStart, int lineEnd, int columnStart, int columnEnd)
        {
            this.lineStart = lineStart;
            this.lineEnd = lineEnd;
            this.columnStart = columnStart;
            this.columnEnd = columnEnd;
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
        
        public int getLineStart() {
            return lineStart;
        }

        public void setLineStart(int lineStart) {
            this.lineStart = lineStart;
        }

        public int getLineEnd() {
            return lineEnd;
        }

        public void setLineEnd(int lineEnd) {
            this.lineEnd = lineEnd;
        }

        public int getColumnStart() {
            return columnStart;
        }

        public void setColumnStart(int columnStart) {
            this.columnStart = columnStart;
        }

        public int getColumnEnd() {
            return columnEnd;
        }

        public void setColumnEnd(int columnEnd) {
            this.columnEnd = columnEnd;
        }
/*
        
        
        Case[][] caseArray = new Case[maxLength][maxLength];
        
        public void fillBlock(int i, int j, Case value){
            if(i < maxLength && maxLength > j)
            	caseArray[i][j] = value;
        }
        
        public void fillBlock(Case[][] blockCase){
            if(blockCase.length == caseArray.length)
            	caseArray = blockCase;
        }
        
        //TODO: a revoir
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
*/
}
