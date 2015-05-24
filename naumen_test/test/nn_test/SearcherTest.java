package nn_test;

import java.util.Arrays;

import nn_test.interfaces.ISearcher;

import org.junit.Test;

public class SearcherTest {

	@Test
	public void testInterfaseExist() {
		ISearcher searcher = new Searcher();
		searcher.refresh(null, null);
		searcher.guess(null);
	}
	
	@Test
	public void test1() {
		
		long[] a1 = {5, 2, 2, 3, 4};
		String[] a2 = {"a", "as", "ab", "b", "c"};
		
		ISearcher searcher = new Searcher();
		searcher.refresh(a2, a1);
		//System.out.println(Arrays.toString(searcher.guess("a")));
	}
	
}
