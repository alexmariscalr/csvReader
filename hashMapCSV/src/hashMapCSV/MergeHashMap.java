package hashMapCSV;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MergeHashMap {

	public MergeHashMap() {

	}
	
	public static Map<String, String[]> mergeMaps (Map<String, String[]> map1, Map<String, String[]> map2) {
		Map<String, String[]> mergedMap = new HashMap<>();
		String newEntry[] = new String[6];
		for (String key1: map1.keySet()) {
			String number1 = map1.get(key1)[3];
			for (String key2: map2.keySet() ) {
				String number2 = map2.get(key2)[2];
				if (number1 == number2) {
					 newEntry = Arrays.copyOf(map1.get(key1), map1.get(key1).length + map2.get(key2).length-1);
					 //Quito el telefono de uno de los arrays
					 String[] sinTelefono = Arrays.copyOf(map2.get(key2), map2.get(key2).length-1);
					 System.arraycopy(sinTelefono, 0, newEntry, map1.get(key1).length, map2.get(key2).length-1);
					 mergedMap.put(key1, newEntry);
				}
			}
		}
		
		
		
		return mergedMap;
	}

}
