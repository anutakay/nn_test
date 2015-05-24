package nn_test.collections;

import java.util.LinkedList;
import java.util.List;

public class Trie<T> {
	
	int size = 0;
	
	final TrieNode<T> root = new TrieNode<T>();
	
	public Trie() {
		
	}
	
	public void put(String s, T obj) {
		TrieNode<T> v = root;
		for (char ch : s.toLowerCase().toCharArray()) {
			v.addObject(obj);
			if (!v.children.containsKey(ch)) {
				v.children.put(ch, new TrieNode<T>());
			}
			v = v.children.get(ch);
		}
		v.leaf = true;
		v.addObject(obj);
	}
	 
	public boolean find(String s) {
		TrieNode<T> v = root;
		for (char ch : s.toLowerCase().toCharArray()) {
			if (!v.children.containsKey(ch)) {
				return false;
			} else {
				v = v.children.get(ch);
			}
		}
		return true;
	}
	
	private TrieNode<T> findNode(String s) {
		TrieNode<T> v = root;
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
		TrieNode<T> n = findNode(start);
		if(n != null) {
			for(String s: n.getKeys(max)) {
				res.add(start + s);
			}
		} 
		return res;
	} 
	
	public List<T> getObjects(final String start, final int max) {
		TrieNode<T> n = findNode(start.toLowerCase());
		if(n == null) {
			return new LinkedList<T>();
		}
		return n.getObjects(max);
	}
	
	public void clear() {
		root.clear();
	}
	
}
