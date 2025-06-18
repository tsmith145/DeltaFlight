package CodingPractice;

import java.util.HashMap;

public class PrefixSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] array= {1,-1,1,1,1,1};
		int subArrays= mostSubArrays(array,3);
		
		System.out.print(subArrays);
		
		
	}
	
	public static int mostSubArrays(int [] arr, int k) {
		
		int count=0;
		HashMap<Integer, Integer> map = new HashMap();
		//add the prefix sum of the arry
         for(int i=1; i<arr.length-1;i++) {
			arr[i]=+ arr[i]+arr[i-1];
			
			// calculate the difference of the prefix sum -k
			int diff= arr[i]-k;
			
			
			//set the prefix of zero to 1 automatically
			map.put(0, 1);
			
			//check if the difference exist in the hashmap
			
			if(map.containsKey(diff)) {
				//if the diff is in the hashmap then there are 
				// that many more subarrys of k 
				count = count + map.get(diff);
			}else {
				// if diff is not in the map just add 
				// the prefixsum to the map with its number 
				// of occurances as the value 
				map.put(arr[i],map.getOrDefault(arr[i],0));
			}
		}
        return count;
	}

}
