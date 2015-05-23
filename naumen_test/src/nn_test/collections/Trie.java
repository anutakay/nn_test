package nn_test.collections;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	
	final TrieNode root = new TrieNode();
	
	final Map<Integer, String> levelSpacesMap = new HashMap<Integer,String>();
	
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
	     
	String getSpace(int level) {
		String result = levelSpacesMap.get(level);        
		if (result == null) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < level; i++) {
				sb.append(" ");
			}
			result = sb.toString();
			levelSpacesMap.put(level, result);
		}
		return result;
	}

	public void printSorted(TrieNode node) {
		printSorted(node, 0);
	}
	
	private void printSorted(TrieNode node, int level) {
		for (Character ch : node.children.keySet()) {
			System.out.println(getSpace(level) + ch);
			printSorted(node.children.get(ch), level + 1);
		}
		if (node.leaf) {
			System.out.println();
		}
	}
}
