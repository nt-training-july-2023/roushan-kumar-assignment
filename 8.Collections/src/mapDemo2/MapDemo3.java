package mapDemo2;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;



public class MapDemo3 {
	public static void main(String[] args) {
		Map<Integer,String> hashMap = new HashMap<Integer, String>();
		Map<Integer,String> treeMap = new TreeMap<Integer, String>();
		SortedMap<Integer, String> treeMap2 = new TreeMap<Integer, String>();
	    
		
		//curd on HashMap
		addDataHashMap(hashMap,2,"one");
		addDataHashMap(hashMap,3,"Three");
		String val = getDataHashMap(hashMap,1);
		removeDataHashMap(hashMap,1);
		updateDataHashMap(hashMap,2,"TWO");
		
		printMap(hashMap);
		
		//curd on TreeMap
		System.out.println("tree Map");
		addDataTreeMap(treeMap,2,"Bat");
		addDataTreeMap(treeMap,3,"cat");
		getDataTreeMap(treeMap,1);
		removeDataTreeMap(treeMap,1);
		updateDataTreeMap(treeMap,2,"big");
		
		printMap(treeMap);
	}

	private static void updateDataTreeMap(Map<Integer, String> treeMap, int i, String string) {
		treeMap.put(i, string);
		
	}

	private static void removeDataTreeMap(Map<Integer, String> treeMap, int i) {
		treeMap.remove(i);
		
	}

	private static String getDataTreeMap(Map<Integer, String> treeMap, int i) {
		
		return treeMap.get(i);
		
	}

	private static void addDataTreeMap(Map<Integer, String> treeMap, int i, String string) {
		treeMap.put(i, string);
		
	}

	private static void removeDataHashMap(Map<Integer, String> hashMap,int i) {
		hashMap.remove(i);
		
	}

	private static void updateDataHashMap(Map<Integer, String> hashMap,int i, String string) {
		hashMap.put(i, string);
		
	}

	private static String getDataHashMap(Map<Integer, String> hashMap,int i) {
		
		return hashMap.get(i);
	}

	private static void addDataHashMap(Map<Integer, String> hashMap, int i, String string) {
		hashMap.put(i, string);
		
	}

	private static void printMap(Map<?,?> map) {
		
		for(Map.Entry<?, ?> m:map.entrySet())
		{
			System.out.println(m.getKey()+" "+m.getValue());
		}
		
	}

	
}
