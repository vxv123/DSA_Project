import java.io.*;
 import java.lang.Math.*;

class Driver{

   static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));


   public static void main(String[] args) throws IOException{
   
      //TODO set up the restaurant before opening
      String input = "";
      /*
      FullTables, EmptyNoPets, EmptyPets, PartiesInLine
      */
      ListArrayBasedPlus<Table> FullTables = new ListArrayBasedPlus<Table>();
      ListArrayBasedPlus<Table> EmptyNoPets = new ListArrayBasedPlus<Table>();
      ListArrayBasedPlus<Table> EmptyPets = new ListArrayBasedPlus<Table>();
      ListArrayBasedPlus<Party> PartiesInLine = new ListArrayBasedPlus<Party>();

      
      
      String menu = "0.  Close the restaurant.\n1.   Customer party enters the restaurant.\n"+
      "2.   Customer party is seated and served.\n3.   Customer party leaves the restaurant.\n"+
      "4.   Add a table.\n5.   Remove a table.\n6.   Display available tables.\n"+
      "7.   Display info about waiting customer parties.\n8.   Display info about customer parties being served.";
      
      
      System.out.println(menu);
      int temp_size;//Prevents repeated method calls for every loop evaluation
      String output;//Collects relevant output and waits to perform file I/O once
      while(!input.equals("0")){
         System.out.println("Please make your menu selection now: ");
         input = stdin.readLine().trim();
         System.out.println(input);//echoed input
         switch(input){
            case "0"://0.  Close the restaurant.
               break;
            case "1"://Customer party enters the restaurant.
            case "2"://Customer party is seated and served.
            case "3"://Customer party leaves the restaurant.
            case "4"://Add a table.
            case "5"://Remove a table.
            case "6"://Display available tables.
               System.out.println("Current available tables:");
               if(EmptyNoPets.isEmpty() && EmptyPets.isEmpty()){
                  System.out.println("There are no available tables left.");
               }else{
                  output = "";
                  //Section information is maintained by which collection the Table is in, not as a data field, so we manually append
                  temp_size = EmptyNoPets.size();
                  for(int i = 0; i < temp_size; i++){
                     output += EmptyNoPets.get(i).toString() + "\nSection: No Pets\n";
                  }
                  temp_size = EmptyPets.size();
                  for(int i = 0; i < temp_size; i++){
                     output += EmptyPets.get(i).toString() + "\nSection: Pets\n";
                  }
                  System.out.println(output);
               }
               break;
            case "7"://Display info about waiting customer parties.
               //We can use the toString method of the collection, as it directly aggregates the desired objects
               System.out.println("The following parties are waiting to be served:");
               if(PartiesInLine.isEmpty()){
                  System.out.println("No parties are currently waiting to be served.");
               }else{
                  System.out.println(PartiesInLine.toString());
               }
               break;
            case "8"://Display info about customer parties being served.
               System.out.println("Parties currently served:");
               //traverse FullTables, get party, party.toString()
               temp_size = FullTables.size();
               if(temp_size > 0){
                  output = "";
                  for(int i = 0; i < temp_size; i++){
                     output += FullTables.get(i).getParty().toString() + "\n";
                  }
               }else{
                  output = "No parties are currently being served.";
               }
               System.out.println(output);
               break;
            default:
               System.out.println("Invalid menu selection; please try again.");
               break;
         }
      }
      System.out.println("The restaurant is closing...");
   }
   
}