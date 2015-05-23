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
        assertEquals(list, trie.get(0));
        list.add("a");
        assertEquals(list, trie.get(1));
        list.add("cat");
        assertEquals(list, trie.get(2));
        list.add("hello");
        assertEquals(list, trie.get(3));
        list.add("house");
        assertEquals(list, trie.get(4));
        assertEquals(list, trie.get(5));
	}
	
	@Test
	public void getKeysForStartTest() {
		Trie trie = new Trie();
        trie.put("hello");
        trie.put("house");
        trie.put("cat");
        trie.put("a");
        
      LinkedList<String> list = new LinkedList<String>();
        assertEquals(list, trie.get("h", 0));
        assertEquals(list, trie.get("t", 0));
        assertEquals(list, trie.get("hen", 0));
        list.add("hello");
        assertEquals(list, trie.get("h", 1));
        assertEquals(list, trie.get("he", 1));
        assertEquals(list, trie.get("hello", 1));
        assertEquals(list, trie.get("Hello", 1));
        assertEquals(list, trie.get("HELLO", 1));
        list.add("house");
        assertEquals(list, trie.get("h", 2));
        assertEquals(list, trie.get("h", 3));
	}

}
