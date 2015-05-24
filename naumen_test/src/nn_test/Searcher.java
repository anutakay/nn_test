package nn_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import nn_test.collections.Trie;
import nn_test.interfaces.ISearcher;

public class Searcher implements ISearcher {
	
	List<Record> list = new ArrayList<Record>(); 
	final Trie<Record> trie = new Trie<Record>();
	
	class Record {
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
		List<Record> res = trie.getObjects(start, n);
		ArrayList<String> l = new ArrayList<String>();
		res.forEach(r -> l.add(r.name));
		String[] arr = new String[l.size()];
		return l.toArray(arr);
	}

}
