package nn_test.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import nn_test.Searcher.Record;

public class TrieNode {
	
	public final static int MAX = 12;
	
	final Map<Character, TrieNode> children = new TreeMap<Character, TrieNode>();
	
    boolean leaf;
    
    private Record[] objects = new Record[MAX];
    
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
    	
    	for(Entry<Character, TrieNode> ch: children.entrySet()) {
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
    
    //Добавляем сначала старые, а потом новые
    //В узле всегда хранятся ссылки на MAX или меньше подходящих объектов
    public void addObject(Record obj) {
    	/*objects.add(obj);
    	if(objects.size() > MAX) {
    		objects = objects.subList(objects.size()-MAX-1, objects.size()-1);
    	}*/
    	for(int i = MAX-1; i > 0; i--) {
    		objects[i] = objects[i-1];
    	}
    	objects[0] = obj;

    	
    }
    
    public Record[] getObjects(final int max) {
    	return objects;
    }
    
    public void clear() {
    	children.clear();
    	for(int i = 0; i< MAX; i++) {
    		objects[i] = null;
    	}
    	leaf = false;
    }

}
