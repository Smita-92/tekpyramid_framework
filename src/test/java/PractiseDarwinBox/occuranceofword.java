package PractiseDarwinBox;

import java.util.LinkedHashMap;

public class occuranceofword {

	public static void main(String[] args) {
		String d="my name is xyz";
		String d1[]=d.split(" ");
		LinkedHashMap<String, Integer> map=new LinkedHashMap();
		for(int i=0;i<d1.length;i++) {
			String ch=d1[i];
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			}else
				map.put(ch, 1);
		}
		System.out.print(map);
	}

}
