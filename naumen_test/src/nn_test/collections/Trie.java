package nn_test.collections;

import java.util.LinkedList;
import java.util.List;

public abstract class Trie<T> {
	
	private class MTrieNode extends TrieNode<T>{

		@Override
		protected boolean objEq(T obj1, T obj2) {
			// TODO Auto-generated method stub
			return Trie.this.objEq(obj1, obj2);
		}
	}
	
	int max = 12;
	
	TrieNode<T> root = new MTrieNode();
	
	abstract public boolean objEq(T obj1, T obj2);
	
	public TrieNode<T> put(String s, T obj) {
		TrieNode<T> v = root;
		for (char ch : s.toLowerCase().toCharArray()) {
			
			v.addObject(obj, ch);
			if (!v.children.containsKey(ch)) {
				v.children.put(ch, new MTrieNode());
			}
			v = v.children.get(ch);			
		}
		v.addObject(obj, '$');
		v.leaf = true;
		v.leafValue = obj;
		return v;
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
	
	public TrieNode<T> findNode(String s) {
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
	
	public T getBestObject(String s) {
		TrieNode<T> tn = findNode(s);
		if(tn!=null) {
			return tn.getObject(0);
		} else {
			return null;
		}
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
	
	public void clear() {
		root.clear();
	}
	
}
