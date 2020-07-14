package testScreen;
import java.util.LinkedList;

public class friendGraph {
	
	//declare integer to represent total number of friends/names in array.
	private int friend;
	
	//initalizes LinkedList to track friend connections.
	LinkedList<Integer> list[];
	
	
	//initializes graph of friends of particular size.
	@SuppressWarnings("unchecked")
	public friendGraph(int friend) {
		this.friend = friend;
		list = new LinkedList[friend];
		for (int i = 0; i < friend ; i++) {  //loop to aggregate the LinkedList with subsequent elements.
			list[i] = new LinkedList<>();
		}
	}
	
	//method to declare an edge between 2 friends
	//takes the index of the two friends' locations in the array and connects them via their values in the Linked list.
	public void addEdge(int f1, int f2) {
		list[f2].addFirst(f1);
		list[f1].addLast(f2); //adds back edge for reverse relationship between friends.
	}
	
	//method to initialize all the original friendships on the network.
	//when user first joins network, they'll see these original friendships on other's profiles.
	public void origFriend() {
		this.addEdge(0, 1);
		this.addEdge(2, 3);
		this.addEdge(1, 3);
		
	}
	
	

}
