package nn_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import nn_test.interfaces.ISearcher;

public class Searcher implements ISearcher {
	
	Index index = new Index();
	
	public class Record {
		long date;
		String name;
	}
	
	public Searcher() {
		
	}

	@Override
	public void refresh(String[] classNames, long[] modificationDates) {
		
		List<Record> list = new ArrayList<Record>();
		
		if(classNames == null || modificationDates == null) {
			return;
		}
		
		for(int i = 0; i < classNames.length; i++) {
			Record r = new Record();
			r.name = classNames[i];
			r.date = modificationDates[i];
			list.add(r);
		}
		
		classNames = null;
		modificationDates = null;
		
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
		index.refresh(list);
	}

	@Override
	public String[] guess(String start) {
		int max = 12;
		if(start == null) {
			start = "";
		}
		return index.getObjects(start, max);
	}

}
