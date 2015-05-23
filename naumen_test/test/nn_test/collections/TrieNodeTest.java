package nn_test.collections;


import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class TrieNodeTest {
	
	@Test
	public void getKeysTest() {
		Trie trie = new Trie();
        trie.put("hello");
        trie.put("house");
        trie.put("cat");
        trie.put("a");
        
        LinkedList<String> list = new LinkedList<String>();
        list.add("a");
        list.add("cat");
        list.add("hello");
        
        assertEquals(list, trie.get(3));
	}

}
