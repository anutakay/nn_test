package nn_test.collections;

import java.util.Map;
import java.util.TreeMap;

public class TrieNode {
	Map<Character, TrieNode> children = new TreeMap<Character, TrieNode>();
    boolean leaf;
}
