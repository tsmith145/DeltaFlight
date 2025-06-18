package CodingPractice;

public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= {1,5,8,9,10};
		
		int max=0;
		int secondMax=0;
		
		for(int i =0;i<arr.length;i++) {
			
			
			
			
			if(arr[i]>max) {
				secondMax=max;
				max=arr[i];
			} else if(arr[i]>secondMax) {
				secondMax = arr[i];
			}
				
			
		}

		System.out.print(secondMax);
		
	}

}
