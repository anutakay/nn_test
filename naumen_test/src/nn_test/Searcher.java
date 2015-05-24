package nn_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import nn_test.collections.Trie;
import nn_test.interfaces.ISearcher;

public class Searcher implements ISearcher {
	
	List<Record> list = new ArrayList<Record>(); 
	final Trie trie = new Trie();
	
	public class Record {
		long date;
		String name;
	}
	
	public Searcher() {
		
	}

	@Override
	public void refresh(String[] classNames, long[] modificationDates) {
		
		clear();
		
		if(classNames == null || modificationDates == null) {
			return;
		}
		
		for(int i = 0; i < classNames.length; i++) {
			Record r = new Record();
			r.name = classNames[i];
			r.date = modificationDates[i];
			list.add(r);
		}
		
		Collections.sort(list, new Comparator<Record>() {

			@Override
			public int compare(Record r1, Record r2) {
				int dd = (int) (r2.date - r1.date);
				if(dd == 0) {
					return r2.name.compareTo(r1.name);
				}
				else {
					return dd;
				}
			}});
		list.forEach( r -> trie.put(r.name.toLowerCase() , r));
	}
	
	private void clear() {
		list.clear();
		trie.clear();
	}

	@Override
	public String[] guess(String start) {
		int n = 12;
		if(start == null) {
			return null;
		}
		Record[] res = trie.getObjects(start, n);
		String[] r = new String[res.length]; 
		for(int i = 0; i < res.length; i++) {
			if(res[i] != null) {
				r[i] = res[i].name;
			} else {
				r[i] = null;
			}
		}
		return r;
	}

}
