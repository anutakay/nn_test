package nn_test.collections;

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
}
