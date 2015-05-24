package nn_test.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TrieNode<T> {
	
	public final static int MAX = 12;
	
	final Map<Character, TrieNode<T>> children = new TreeMap<Character, TrieNode<T>>();
	
    boolean leaf;
    
    private List<T> objects = new LinkedList<T>();
    
    public List<String> getKeys(final int max) {
    	int n = max;
    	List<String> res = new LinkedList<String>();  
    	
    	if(children.size() == 0){
    		res.add("");
    		return res;
    	}
    	
    	if(n == 0) {
    		return res;
    	}
    	if(leaf) {
    		res.add("");
    		n--;
    	}
    	
    	for(Entry<Character, TrieNode<T>> ch: children.entrySet()) {
    		if(n == 0) {
    			break;
    		}  		
    		List<String> temp = ch.getValue().getKeys(n);
    		for(String s: temp) {
    			res.add(ch.getKey() + s);
    			n--;
    		}
    	}
    	return res;
    }
    
    static int S =0;
    
    //Добавляем сначала старые, а потом новые
    //В узле всегда хранятся ссылки на MAX или меньше подходящих объектов
    public void addObject(T obj) {
    	S++;
    	System.out.println(S);
    	/*objects.add(obj);
    	if(objects.size() > MAX) {
    		objects = objects.subList(objects.size()-MAX-1, objects.size()-1);
    	}*/
    	if(objects.size() >= MAX) {
    		objects.remove(MAX-1);
    	}
    	objects.add(0, obj);
    }
    
    public List<T> getObjects(final int max) {
    	if(max >= objects.size()) {
    		return objects;
    	} else {
    		return objects.subList(objects.size()-max-1, objects.size()-1);
    	}
    }
    
    public void clear() {
    	children.clear();
    	objects.clear();
    	leaf = false;
    }

}
