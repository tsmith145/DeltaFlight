package CodingPractice;

import java.util.HashMap;

public class FindOccurances {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		
		int []array = {3,5,5,1,5,0,3};
		
		for (int i =0; i<array.length;i++) {
			
			map.put(array[i], map.getOrDefault(array[i], 0)+1);
		}
		
		
	for (int i =0; i<array.length;i++) {
			
			System.out.println("The number "+array[i]+" shows up "+ map.get(array[i])+" times");
		} 

	}

}
