package nn_test.collections;


import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class TrieNodeTest {
	
	@Test
	public void getKeysTest() {
		Trie<String> trie = new Trie<String>();
        trie.put("hello", "hello");
        trie.put("house", "house");
        trie.put("cat", "cat");
        trie.put("a", "a");
        
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
		Trie<String> trie = new Trie<String>();
        trie.put("hello", "hello");
        trie.put("house", "house");
        trie.put("cat", "cat");
        trie.put("a", "a");
        
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
	
	@Test
	public void getKeysForStartTest1() {
		Trie<String> trie = new Trie<String>();
        trie.put("hello", "hello");
        trie.put("house", "house");
        trie.put("h", "h");
        trie.put("he", "he");
        trie.put("hk", "hk");
        
        LinkedList<String> list = new LinkedList<String>();
        list.add("h");
        list.add("he");
        list.add("hello");
        list.add("hk");
        list.add("house");
        
        assertEquals(list, trie.get("h", 13));
	}
	
	@Test
	public void getObjectsForStartTest() {
		Trie<String> trie = new Trie<String>();
        trie.put("hello", "hello");
        trie.put("house", "house");
        trie.put("cat", "cat");
        trie.put("a", "a");
        
      LinkedList<String> list = new LinkedList<String>();
        assertEquals(list, trie.getObjects("h", 0));
        assertEquals(list, trie.getObjects("t", 0));
        assertEquals(list, trie.getObjects("hen", 0));
        list.add("hello");
        assertEquals(list, trie.getObjects("h", 1));
        assertEquals(list, trie.getObjects("he", 1));
        assertEquals(list, trie.getObjects("hello", 1));
        assertEquals(list, trie.getObjects("Hello", 1));
        assertEquals(list, trie.getObjects("HELLO", 1));
        list.add("house");
        assertEquals(list, trie.getObjects("h", 2));
        assertEquals(list, trie.getObjects("h", 3));
	}
	
	@Test
	public void getObjectsForStartTest1() {
		Trie<String> trie = new Trie<String>();
        trie.put("h", "h");
        trie.put("he", "he");
        trie.put("hello", "hello");
        trie.put("hk", "hk");
        trie.put("house", "house");
        
        
        LinkedList<String> list = new LinkedList<String>();
        list.add("h");
        list.add("he");
        list.add("hello");
        list.add("hk");
        list.add("house");
        
        System.out.println(trie.getObjects("h", 13));
        
        assertEquals(list, trie.getObjects("h", 13));
	}

}
