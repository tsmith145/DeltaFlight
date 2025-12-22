package CodingPractice;

import java.util.HashMap;

public class longestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String ss = "serdsgrpoyxszs";
		
		int longestString=0;
		
		HashMap<Character,Integer> map1 =new HashMap();
		
		for (int left=0, right=0; right<ss.length();right++) {
			
			
			if(map1.containsKey(ss.charAt(right)) && map1.get(ss.charAt(right)) >= left ) {
				//if the map already has this character and the char is past the left pointer move the left pointer up
				// the reason why we move the left pointer up is because this is a repeating character ...
				// if the map already has it and its past the left pointer 
				// moving the left pointer up gets cleans the repeater character out of the sliding window
				left = map1.get(ss.charAt(right))+1;
			}else {
				map1.put(ss.charAt(right), right);
			}
			
			longestString=right-left+1;
		}
		System.out.print(longestString);
 
	}

}
