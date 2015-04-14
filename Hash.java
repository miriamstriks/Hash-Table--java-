 //step 0: prepare 
import java.io.*;
import java.util.Scanner;

public class Hash {

   public interface Function{ 
   
       public int hash(int data, int b);
   }

   public static class HashOne implements Function{ 
   
       public int hash(int data, int b){
          return data % b;
       }
    }
       
    public static class HashTwo implements Function{
       
       public int hash(int data, int b){
       int sumOfDigits = 0;
          while (data > 0) {
              sumOfDigits += data % 10;
              data /= 10;
          }
       return sumOfDigits % b;
       }
   }
      
    public static class HashThree implements Function{
       
       public int hash(int data, int b){
          int sumOfAsciis = 0;
          char c;
          while (data > 0) {
              c = (char)(data % 10);
              sumOfAsciis += (int)c;
              data /= 10;
          }
          return sumOfAsciis % b;
       }
   }
       
   public static ListNode findSpot(LinkedList list, int data){
       ListNode walker = list.getHead();
       while(walker.getNext() != null && walker.getNext().getData() <= data)
           if(walker.getNext().getData() == data)
               return null;
           else walker = walker.getNext();
       return walker;
   }

   public static void hashThis(Scanner inFile, HashTable hashTable, int b, Function hashChoice){
       int data, index;
       ListNode spot;
       //step 1: data <-- get an integer from infile 
       while(inFile.hasNextInt()){
           data = inFile.nextInt();
           //step 2: index <-- hashFunction(data, B) 
           index = hashChoice.hash(data,b);

           //step 3: output data and index 
           System.out.println(data + " --> " + index);

           //step 4: spot <-- findSpot(hashTable[index], data) 
           spot = findSpot(hashTable.getTable()[index],data);

           //step 5: if spot == Null, output NO insertion : data already in database, 
           //      else insert new node in between spot and spot's next, 
           //      print linked list (hashTable[index]) 
           if(spot == null)
               System.out.println(data + " already in database");
           else{
               hashTable.getTable()[index].append(data,spot);
               hashTable.print(index);
           }
       }
   }

   public static void main(String args[]){
       
       int bsize, hashChoice;
       String filename = "";
       Scanner inFile;
       Scanner in = new Scanner(System.in);
       //step 1: Bsize <-- ask user
       System.out.print("Enter hash table size: ");
       bsize = in.nextInt();
       //clear input buffer
       in.nextLine();

       //step 2: Dynamically create a hashTable of size Bsize
       HashTable hashTable = new HashTable(bsize);

       //step 3: infile <-- open file 
       System.out.print("Enter file name: ");
       filename = in.nextLine();
       try{
          inFile = new Scanner(new FileReader(filename));
   
          //step 4: whichHash <-- ask user which hash function to use (choice of 1, 2 and 3) 
          do{
              System.out.print("Which hash function would you like to use (1, 2, or 3)? ");
              hashChoice = in.nextInt();
             
              //step 5:   if whichHash == 1 call hashOne (infile, hashTable)
              //      else if whichHash == 2 call hashTwo (infile, hashTable
              //      else if whichHash == 3 call hashThree (infile, hashTable
              //      else repeat step 4 and 5 until get it right 
              switch(hashChoice){
                  case 1:
                      hashThis(inFile, hashTable, bsize, new HashOne());
                      break;
                  case 2:
                      hashThis(inFile, hashTable, bsize, new HashTwo());
                      break;
                  case 3:
                      hashThis(inFile, hashTable, bsize, new HashThree());
                      break;
                  default:
                      System.out.println("Please select 1, 2, or 3. ");
              }
          }while(!(hashChoice == 1 || hashChoice == 2 || hashChoice == 3));
   
          //step 6: print the entire HashTable 
          System.out.println( "   ******************  \nWhole hash table:");
          hashTable.print();
       }catch(FileNotFoundException e){
          System.out.println("File not found.");
       }
      in.close();    
   }
}


