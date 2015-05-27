package nn_test.collections;

import java.util.Map;
import java.util.TreeMap;

public abstract class TrieNode<T> {
	
	public final static int MAX = 12;
	
	final Map<Byte, TrieNode<T>> children = new TreeMap<Byte, TrieNode<T>>();
	
	byte[] last = new byte[MAX];
	
    boolean leaf;
    T leafValue;
    
    private T best;
    
    //Добавляем сначала старые, а потом новые
    //В узле всегда хранятся ссылка на самый подходящий объект
    public void addObject(T obj, byte ch) {
    	//добавить. если дата та же самая, что и была, пропускаем, если
		//дата новая - записать букву
    	if(best == null) {
    		
    	}
    	else if(!this.objEq(obj, best)) {
    		addChar(ch);
    	} else {
    		last[0] = (byte)ch;
    	}
    	best = obj;
    }
    
    private void addChar(byte ch) {
    	for(int i = MAX-1; i >= 1; i--) {
    		last[i] = last[i-1];
    	}
    	last[0] = ch;
    }
    
    public T getObject(int d) {
    	if(d == 0) {
    		return best;
    	}
    	if(last[d] == 36) {
    		return leafValue;
    	}
    	return children.get(last[d]).getPrevObj(best);   	
    }
    
    public T getPrevObj(T exclude) {
    	if(!objEq(best, exclude)){
    		return best;
    	}
    	if(leaf && !objEq(leafValue, exclude)) {
    		return leafValue;
    	}
    	if(last[1]==0){
    		return null;
    	}
    	return children.get(last[1]).getPrevObj(best);
    }
    
    public void clear() {
    	children.clear();
    	best = null;
    	leaf = false;
    	leafValue = null;
    }
    
    protected abstract boolean objEq(T obj1, T obj2);

}
