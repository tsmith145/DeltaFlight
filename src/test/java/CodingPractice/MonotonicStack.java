package CodingPractice;

import java.util.HashMap;
import java.util.Stack;

import org.apache.commons.lang3.ArrayUtils;

public class MonotonicStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] num = {4,3,1,7,5,8};
		int newArray [] = new int[num.length];
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i =0 ;i<num.length;i++) {
			
			if(!stack.isEmpty() && num[i]> stack.peek()) {
				while(!stack.isEmpty()) {
					
					//get the opostinon of the top of the stack in an int
					//basically what position is the the number stack.peek in the num array
					int indexTop = ArrayUtils.indexOf(num, stack.peek());
					
					//newArray[indexTop] is where we are going to put the number that represents 
					// the distance between the next number greater than it and its self positon wise 
					// for example if indexTop is 7 we are going to put 2 in the 3 positon of the newArray
					// 7 is in the 3 positon in the num array and 8 is 2 positions away from it 
					newArray[indexTop]=i-indexTop;
					
					// now that we pop the stack indexTop will be a new number\
					// if I is greater than the new top of the stack the distance this number and 
					// the top of the stack will be put in a new position on the newArray
					stack.pop();				
					
					
//					if(stack.size()==1) {
//						
//						map.put(stack.firstElement(), distance);
//						
//					}
				}
				
				
				
			} else if (stack.isEmpty() || num[i]<stack.peek()) {
				stack.push(num[i]);
			}
			
		}
		
		for(int i=0; i<newArray.length;i++) {

			System.out.print(newArray[i]);
		}

	}

}
