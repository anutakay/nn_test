package test_text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import nn_test.Searcher;

public class Main {
	
	static String filename = "names100000.txt";

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		getDataFromFile(set);    
		//list.forEach(s -> System.out.println(s));
		/*
		String filename2 = "names" + set.size() + ".txt";
		//putDataToFile(filename2, set, s ->  s + "\n");
		
		final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final int N = alphabet.length();
		Random r = new Random();
		
	
		Set<String> temp = new HashSet<String>();
		temp.addAll(set);
		temp.forEach(s -> {
			 	set.add("A" + s);
			 	set.add("Kv" + s);
			 	set.add(s + "s");
			 	set.add(s + "2");
				set.add(alphabet.charAt(r.nextInt(N)) + s);
				set.add(alphabet.charAt(r.nextInt(N)) +
							alphabet.charAt(r.nextInt(N)) + s);
				set.add(alphabet.charAt(r.nextInt(N)) +
						alphabet.charAt(r.nextInt(N)) +
						alphabet.charAt(r.nextInt(N)) + s);
				set.add(s + alphabet.charAt(r.nextInt(N)));
				set.add(s + alphabet.charAt(r.nextInt(N)) +
							alphabet.charAt(r.nextInt(N)));
				set.add(s + alphabet.charAt(r.nextInt(N)) +
						alphabet.charAt(r.nextInt(N)) +
						alphabet.charAt(r.nextInt(N)));
		});
		
		String str;
		while(set.size() < 100000) {
			int n = r.nextInt(32);
			str = "";
			for(int i = 2; i <= n; i++) {
				str = str+alphabet.charAt(r.nextInt(N));
			}
			set.add(str);
		}
		String filename3 = "names" + set.size() + ".txt";
		set.remove("");
		putDataToFile(filename3, set, s ->  s + "\n");
		*/
		test(set, "BootstrapServer");
	}

	private static void test(Set<String> set, String str) {
		String[] names = new String[set.size()];
		long[] dates = new long[set.size()];
		names = set.toArray(names);
		for(int i = 0; i < dates.length; i++) {
			dates[i] = 1;
		}
		Searcher searcher = new Searcher();
		long old = System.currentTimeMillis();
		searcher.refresh(names, dates);
		long a1 = System.currentTimeMillis();
		System.out.println("refresh: " + (a1-old));
		String[] res = searcher.guess(str);
		System.out.println("guess: " + (System.currentTimeMillis()-a1));
		
		System.out.println(Arrays.toString(res));
	}

	private static void putDataToFile(String filename, Set<String> set,  java.util.function.Function<String, String> fun) {
		File file;
		
		file = new File(filename);
		
		try{
			if(!file.exists()) {
				file.createNewFile();
			}
			//PrintWriter обеспечит возможности записи в файл
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	 
	        try {
	            //Записываем текст у файл
	        	set.forEach(s -> {
	        		out.print(fun.apply(s));
	        	});
	        } finally {
	            //После чего мы должны закрыть файл
	            //Иначе файл не запишется
	            out.close();
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void getDataFromFile(Set<String> list) {
		File file = new File(filename);
		try {
			BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
			try {
	            //В цикле построчно считываем файл
	            String s;
	            while ((s = in.readLine()) != null) {
	                list.add(extract(s));      
	            }
	        } finally {
	            //Также не забываем закрыть файл
	            in.close();
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static String extract(final String s) {
		String res = null;
		String[] a = s.split("/");
		res = "" + a[a.length-1].replaceAll(".java", "").replace("_", "");
		return res;
	}
}
