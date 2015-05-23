package nn_test.collections;

import java.util.LinkedList;
import java.util.List;

public class Trie {
	
	final TrieNode root = new TrieNode();
	
	public Trie() {
		
	}
	
	public void put(String s) {
		TrieNode v = root;
		for (char ch : s.toLowerCase().toCharArray()) {
			if (!v.children.containsKey(ch)) {
				v.children.put(ch, new TrieNode());
			}
			v = v.children.get(ch);
		}
		v.leaf = true;
	}
	 
	public boolean find(String s) {
		TrieNode v = root;
		for (char ch : s.toLowerCase().toCharArray()) {
			if (!v.children.containsKey(ch)) {
				return false;
			} else {
				v = v.children.get(ch);
			}
		}
		return true;
	}
	
	private TrieNode findNode(String s) {
		TrieNode v = root;
		for (char ch : s.toLowerCase().toCharArray()) {
			if (!v.children.containsKey(ch)) {
				return null;
			} else {
				v = v.children.get(ch);
			}
		}
		return v;
	}
	
	public List<String> get( final int max ) {
		return root.getKeys(max);
	}
	
	public List<String> get(String start, final int max ) {
		start = start.toLowerCase();
		List<String> res = new LinkedList<String>(); 
		TrieNode n = findNode(start);
		if(n != null) {
			for(String s: n.getKeys(max)) {
				res.add(start + s);
			}
		} 
		return res;
	} 
	
}
