package CodingPractice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class DFSJava {
	
	
	
	
	List<List<Vertex>> verteces;
	Deque<Vertex> stack = new ArrayDeque<>();
	public void traverseMap(Vertex firstnode) {
		
		
		stack.push(firstnode);
		for(List<Vertex> v: verteces) {
			while(!stack.isEmpty()) {
				Vertex current = stack.pop();
				
				/*
				 * if(!current.isVisited) { //mark current as visited //reverse the order of the
				 * nieghbors //push the niieghbors }
				 */
				//topNode.isvisited
				//topNode.goThroughNiegbors
			}
		}
	}
	
	

}
