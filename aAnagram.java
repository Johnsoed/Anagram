package anagram;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.util.Set;
public class aAnagram {

	public static void main(String[] args) {
		TreeMap<String, ArrayList<String>> map = new TreeMap<String, ArrayList<String>>();
		
		try {
			Scanner s = new Scanner(new File("words.txt"));	
			while (s.hasNextLine()) {
			String word = s.nextLine(); 

			char[] sortArray = word.toCharArray();
			int count = word.length();

			Arrays.sort(sortArray);
			String w = new String(sortArray);

			if (map.containsKey(w)) {
				ArrayList al = map.get(w);
				al.add(word);
				map.put(w, al);
			}
				else {
				ArrayList<String> al = new ArrayList<String>();
				al.add(word);
				map.put(w,al);
				}
			}
		} catch (Exception e) {
			System.out.print("something went wrong");
		}
		
		Set mapSet = map.entrySet();
		Iterator iterator = mapSet.iterator();
		ArrayList<String> max = new ArrayList<String>();
		max = null;
		String maxKey = "";
		int maxSize = 0;
	      while(iterator.hasNext()) {
	          Map.Entry currentEntry = (Map.Entry)iterator.next();
	    	  ArrayList<String> currentList = 
	    			  (ArrayList<String>) currentEntry.getValue();
	    	  if (max == null || currentList.size() > max.size()) {
	    		  max = currentList;
	    		   maxKey = (String) currentEntry.getKey();
	    		   maxSize = currentList.size();
	    	  }
	      }
	      System.out.println(maxKey);
	      System.out.println(max.toString());
	      System.out.println("the size of max is: " + maxSize);
		
	}

}

