package nn_test;

import nn_test.interfaces.ISearcher;

public class Searcher implements ISearcher {

	@Override
	public void refresh(String[] classNames, long[] modificationDates) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] guess(String start) {
		// TODO Auto-generated method stub
		String[] array = new String[12];
		for(String s: array) {
			s = "";
		}
		return array;
	}

}
