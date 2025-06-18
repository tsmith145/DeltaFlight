package CodingPractice;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {2,7,1,8,0,9,4};
		
		int target= 9;

		findTarget(arr,target);
	
	}

	
	public static int findTarget(int[] array, int targ) {
		Arrays.sort(array);
		int left=0;
		int right=array.length-1;
		
		while (left<=right) {
			int midpoint= left + (right-left)/2;
			if (array[midpoint]==targ) {
				System.out.print(" the target is at "+ array[midpoint]);
				return midpoint;
			}
			
			
			
			if (array[midpoint]>targ) {
				right = midpoint-1;
			}else if (array[midpoint]<targ){
				left= midpoint+1;
			}
		}
		return -1;

	}
}
