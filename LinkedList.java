// LinkedList.java

public class LinkedList {

	private ListNode listHead;
	private ListNode last;
	private int length;
	
	// default constructor
	public LinkedList(){
	   listHead = new ListNode();
	   last  = listHead;
	   length = 0;
	}
	
	public ListNode getHead(){
	   return listHead;
	}
	
	public int getLength() {
		return length;
	}

	public void append(int d) {
		ListNode newNode = new ListNode(d);
		last.next = newNode;
		last = newNode;
		length++;
	} // method append(String)

	public void append(int d, ListNode afterNode){
	   ListNode newNode = new ListNode(d);
	   newNode.next = afterNode.next;
	   afterNode.next = newNode;
	   length++;  
	} // method append(String, ListNode)
	
	public void prepend(int d) {
		ListNode newNode = new ListNode(d);
		newNode.next = listHead.next;
		listHead.next = newNode;
		if(length==0)
		   last = newNode;
		length++;
	} // method append(String)

	public String toString() {
		ListNode p = listHead.next;
		String returnString = "";
		while (p != null) {
			returnString += p.data + " ";
			p = p.next;
		}
		return returnString;
	}

	public boolean equals(Object other) {
		if (other == null || getClass() != other.getClass()
				|| length != ((LinkedList) other).length)
			return false;

		ListNode nodeThis = listHead;
		ListNode nodeOther = ((LinkedList) other).listHead;
		while (nodeThis != null) {
			// Since the two linked lists are the same length,
			// they should reach null on the same iteration.

			if (nodeThis.data != nodeOther.data)
				return false;

			nodeThis = nodeThis.next;
			nodeOther = nodeOther.next;
		} // while

		return true;
	} // method equals

} // class LinkedList

