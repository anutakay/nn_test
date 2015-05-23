package nn_test.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TrieNode {
	
	final Map<Character, TrieNode> children = new TreeMap<Character, TrieNode>();
	
    boolean leaf;
    
    public List<String> getKeys(final int max) {
    	int n = max;
    	List<String> res = new LinkedList<String>();  
    	
    	if(children.size() == 0){
    		res.add("");
    		return res;
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

}
