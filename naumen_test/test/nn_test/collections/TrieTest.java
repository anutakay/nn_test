package nn_test.collections;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TrieTest {
	
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
	
	final Map<Integer, String> levelSpacesMap = new HashMap<Integer, String>();
	
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
	
	@Test
	public void HelloTest() {
	      /*  Trie trie = new Trie();
	        trie.put("hello", "hello");        
	        trie.put("house", "house");
	        trie.put("hell", "hell");
	        trie.put("world", "world");
	        assertTrue(trie.find("hello"));
	        assertTrue(trie.find("hell"));
	        assertTrue(trie.find("house"));
	        assertTrue(trie.find("world"));
	        assertTrue(trie.find("h"));

	        assertFalse(trie.find("a"));*/
	}

}
