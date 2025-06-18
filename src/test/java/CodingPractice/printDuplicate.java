package CodingPractice;

import java.util.HashMap;

public class printDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "timothy";
		char[] ch = s.toCharArray();
		HashMap <Character,Integer> map = new HashMap();
		
		for(Character c: ch) {
			if (map.containsKey(c)) {
				System.out.print("Character  "+c+" is a duplicate" );
			}else {
				map.put(c, 1);
				
				
			}
		}

	}

}
