package PractiseDarwinBox;

import java.util.HashMap;

public class countOfCharacters {

	public static void main(String[] args) {
		String d="bbgghhjhtfcccc";
		HashMap<Character, Integer> map=new HashMap();
		int count=1;
		for(int i=0;i<d.length();i++) {
			char ch=d.charAt(i);
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
				
			}
			else
				map.put(ch, 1);
			
			
		}
		System.out.println(map);

	}

}
