package nn_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import nn_test.collections.Trie;
import nn_test.interfaces.ISearcher;

public class Searcher implements ISearcher {
	
	List<Entry<Long, Trie>> list; 
	
	public Searcher() {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void refresh(String[] classNames, long[] modificationDates) {
		
		if(classNames == null || modificationDates == null) {
			return;
		}
		
		Map<Long, Trie> map = new HashMap<Long, Trie>();
		for(int i = 0; i < modificationDates.length; i++) {
			long date = modificationDates[i];
			if(!map.containsKey(date)) {
				map.put(date, new Trie());
			}
			Trie trie = map.get(date);
			trie.put(classNames[i]);
		}
		list = new ArrayList<Entry<Long, Trie>>(map.entrySet());
		Collections.sort(list, new Comparator<Entry<Long, Trie>>() {

			@Override
			public int compare(Entry<Long, Trie> arg0, Entry<Long, Trie> arg1) {
				return (int) (arg1.getKey()-arg0.getKey());
			}});
	}

	@Override
	public String[] guess(String start) {
		List<String> res = new LinkedList<String>();
		int n = 12;
		if(start == null) {
			return null;
		}
		for(Entry<Long, Trie> e: list) {
			List<String> temp = e.getValue().get(start, n);
			res.addAll(temp);
			n = n - temp.size();
		}
		String array[] = new String[res.size()];
		return res.toArray(array);
	}

}
