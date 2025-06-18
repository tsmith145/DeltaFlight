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
				left = map1.get(ss.charAt(right))+1;
			}else {
				map1.put(ss.charAt(right), right);
			}
			
			longestString=right-left+1;
		}
		System.out.print(longestString);
 
	}

}
