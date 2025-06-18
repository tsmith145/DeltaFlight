package CodingPractice;

import java.util.HashMap;
import java.util.Stack;

public class MonotonicStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] num = {4,3,1,7,5,8};
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		Stack<Integer> stack = new Stack<>();
		
		for(int n: num) {
			
			if(num[n]> stack.peek()) {
				while(num[n]>stack.peek()) {
					int distance=+1;
					if(stack.size()==1) {
						
						map.put(stack.firstElement(), distance);
						
					}
				}
				stack.push(num[n]);
			}
		}

	}

}
