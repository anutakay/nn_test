package nn_test;

import nn_test.interfaces.ISearcher;

import org.junit.Test;

public class SearcherTest {

	@Test
	public void testInterfaseExist() {
		ISearcher searcher = new Searcher();
		searcher.refresh(null, null);
		searcher.guess(null);
	}
	
}
