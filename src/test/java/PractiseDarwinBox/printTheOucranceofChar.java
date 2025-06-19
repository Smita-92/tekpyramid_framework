package PractiseDarwinBox;

import java.util.HashMap;
import java.util.Map.Entry;

public class printTheOucranceofChar {

	public static void main(String[] args) {
		String h = "jdhhhhfbj";
		String g = "hbdddchdbjj";
		HashMap<Character, Integer> map = new HashMap();
		HashMap<Character, Integer> map1 = new HashMap();
		for (int i = 0; i < h.length(); i++) {
			char ch = h.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);

			} else
				map.put(ch, 1);
		}
		for (int j = 0; j < g.length(); j++) {
			char ch1 = g.charAt(j);
			if (map1.containsKey(ch1)) {
				map1.put(ch1, map1.get(ch1) + 1);

			} else
				map1.put(ch1, 1);
		}
//for(Entry<Character, Integer> entry:map.entrySet()){
//	char key = entry.getKey();
//	if(map1.containsKey(key)) {
//		

		
		
		//		if(entry.getValue()>map1.get(key)) {
//			System.out.println("String"+ key+"=="+entry.getValue());
//			
//		}else
//			System.out.println("String 2"+key +"=="+entry.getValue());
//	}
//}
//}
		for (Entry<Character, Integer> entry : map.entrySet()) {
			char key = entry.getKey();
			if (map1.containsKey(key)) {
				if (entry.getValue() > map1.get(key)) {
					System.out.println("String  " + key + "===" + entry.getValue());
				} else
					System.out.println("String1  " + key + "===" + entry.getValue());
			}
		}

	}
}
