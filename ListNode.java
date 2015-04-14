// ListNode.java

public class ListNode
{
   public int data;
   public ListNode next;

   public ListNode(){
      data = 0;
      next = null;
     
   }//default constructor
   
   public ListNode(int d)
   {
      data = d;
      next = null;
   }  // constructor
   
   public int getData(){
      return data;
   }
   public ListNode getNext(){
      return next;
   }
}  // class ListNode

