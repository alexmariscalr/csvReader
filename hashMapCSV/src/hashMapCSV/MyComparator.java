package hashMapCSV;

import java.util.Comparator;
import java.util.Map;

public class MyComparator implements Comparator<String> {
	private final Map<String, String[]> map;

	public MyComparator(Map<String, String[]> map) {
		// TODO Auto-generated constructor stub
		this.map = map;
	}
	
	public int compare(String s1, String s2) {
		return map.get(s1)[2].compareTo(map.get(s2)[2]);
	}


}
