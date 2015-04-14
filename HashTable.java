import java.io.*;

public class HashTable {
      
      LinkedList[] ary;
      int size;

       HashTable(){
           size = 1;
           ary = new LinkedList[size];
           ary[0] = new LinkedList();
       }//default constructor

       HashTable(int s){
           size = s;
           ary = new LinkedList[size];
           for(int i=0; i<size; i++)
               ary[i] = new LinkedList();
       }//constructor

       LinkedList[] getTable(){
           return ary;
       }

       void print(){
           LinkedList list;
           ListNode walker;
           for(int i=0; i<size; i++){
               list  = ary[i];
               walker = list.getHead();
               System.out.println("Index " + i + ": ");
               while(walker.getNext()!=null){
                  System.out.println(walker.getNext().getData() + ", ");
                   walker = walker.getNext();
               }
               System.out.println();
           }
       }//print whole table

       void print(int index){
           LinkedList list = ary[index];
           ListNode walker = list.getHead();
           System.out.println("Index " + index + ": ");
           while(walker.getNext()!=null){
               System.out.print(walker.getNext().getData() + " ");
               walker = walker.getNext();
           }
           System.out.println();
       }//print single bucket
 }


