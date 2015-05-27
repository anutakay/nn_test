package nn_test;

import java.util.List;

import nn_test.Searcher.Record;
import nn_test.collections.Trie;
import nn_test.collections.TrieNode;

public class Index {
	
	List<Record> list;
	
	Trie<Integer> trie = new Trie<Integer>(){

		@Override
		public boolean objEq(Integer obj1, Integer obj2) {
			
			Record r1 = list.get(obj1),
					r2 = list.get(obj2);
			
			if(r1 == null || r2 == null) {
				//?? в принципе не должно сюда заходить
				return false;
			}
			return r1.date == r2.date;
		}
		
	};
	
	public void refresh(final List<Record> data) {
		//data.forEach(d -> System.out.println(d.date + "\t" + d.name));
		trie.clear();
		list = data;
		for(int i = 0; i < list.size(); i++) {
			trie.put(list.get(i).name.toLowerCase().getBytes(), i);
		}
	}
	
	public String[] getObjects(String start, int max) {
		String[] res = new String[max];
		int i = 0;
		TrieNode<Integer> tn = trie.findNode(start);
		if(tn == null) {
			return res;
		}
		Integer a;
		for(int j =0; j<max; j++) {
		  a = tn.getObject(j);
			if(a == null) {
				//не нашлось подходящего по алфавиту ключа
				return res;
			}
			String temp = list.get(a).name;
			do {
				//System.out.println(temp +" "+ list.get(a).date);
				
				res[i] = temp;
				i++;
				a--;
				if(a < 0){
					break;
				}
				temp = list.get(a).name;
			} while(temp.toLowerCase().startsWith(start) && i<max);
			if(a >= list.size()) {
				//список всех классов закончился
				return res;
			}
			if(i >= max) {
				//12 элементов найдено
				return res;
			}
		}
		return res;
	}


}
