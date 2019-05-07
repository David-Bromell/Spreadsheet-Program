

//Importing utility files for Scanner
import java.util.*;

public class SpreadSheetManager{
    
    //Global variables that will be accessible to all methods.
    public static String[] Names = new String[256]; //Names is global since all methods will read and write to the same array of sheets.
    public static int N = 4, I = 0; //N is initialised outside add() otherwise every time add() is called, it will get re-initialised to 3. I is used by many methods to store length. 
    
    public static void main(){
    
      /* 
         Variable Declaration and Initialisation
         1) A variable 'input' of type Scanner is declared to get user input.
         2) Integer Variables: a) ch = choice: for switch cases.
                               b) indexf = index from: stores and carries index to methods requiring it.
                               c) indext = index to: stores and carries index to methods requiring it.
                               d) temp = for Before or After choice.
                               e) iout = integer output: to store integer values returned by methods.
         3) String Variables:  a) inNamef = input Name from: stores and carries Name to methods requiring it.
                               b) inNamet = input Name to: stores and carries Name to methods requiring it.  
                               c) sout = string output: to store String values returned by methods.
         4) Boolean Variables: a) before: to check whether the 'from' sheet has to be moved before or after the 'to' sheet.
                               b) bout = boolean output: to store boolean value returned by methods. 
      */
      Scanner input = new Scanner(System.in);
      int ch = 0, indexf = 0, indext = 0, temp = 0, iout = 0; // ch moade global temporarily
      String inNamef = "", inNamet = "", sout = "";
      boolean before = false, bout = false;
    
      //Initialising the first three sheets as default 'Sheet1', 'Sheet2' and 'Sheet3'. 
      Names[0] = "Sheet1";
      Names[1] = "Sheet2";
      Names[2] = "Sheet3";
 
      //Do-While loop to print menu and accept user input until asked to exit program.
      do{
        System.out.print("\n");//Skips a line every time the menu is printed. 
        System.out.println("Which task would you like to perform? [Enter Integer Choice] ");
        //The menu with integer values as choice for input.
        System.out.println("1) Add New Sheet");
        System.out.println("2) Delete Sheet [Using Name]");
        System.out.println("3) Delete Sheet [Using Index]");
        System.out.println("4) Move Sheet [Using Names]");
        System.out.println("5) Move Sheet [Using Indices]");
        System.out.println("6) Move Sheet To End [Using Name]");
        System.out.println("7) Move Sheet To End [Using Index]");
        System.out.println("8) Rename Sheet");
        System.out.println("9) Get Index of Sheet");
        System.out.println("10) Get Sheet Name [Using Index]");
        System.out.println("11) Display List of Names");
        System.out.println("12) Get Current Number of Sheets");
        System.out.println("13) Exit Manager");
        
        //Variable ch used to accept user input.
        ch = input.nextInt();
        
        //The switch cases for the menu of tasks to be performed. Each case acts according to it's respective task.
        switch (ch){
        
          case 1: { 
                    bout = add(); // Add method is called and it's returned value is stored in bout. 
                    
                    //if-else statement to check the returned value and print the appropriate output. 
                    if(bout){
                       System.out.println ("New Sheet Added: "+(I)+") "+Names[I]);
                    }
                    else{
                       System.out.println("Max Number of Sheets Reached! Task Ended.");
                    }
                    break;
                  }
        
          case 2: {
                    System.out.println("Enter the name of the sheet: ");
                    inNamef = input.next(); //User inputs the name of the sheet to be deleted.
                    
                    iout = remove(inNamef); //remove method called with the sheetname passed as a parameter. Value returned by remove is stored in iout. 
                    
                    //if-else statement to check the returned value and print the appropriate output. 
                    if(iout==-1){
                       System.out.println("Sheet Does Not Exist or it is the only Sheet in the Workbook! Task Ended.");
                    }
                    else{
                       System.out.println("The Sheet Has Been Deleted Succesfully from Index: "+iout);
                    }
                    break;
                  } 
                
          case 3: {
                    System.out.println("Enter the index of the Sheet: ");
                    indexf = input.nextInt(); //User inputs the index of the sheet to be deleted.
                    
                    sout = remove(indexf); //remove method called with the sheet index passed as a parameter. Value returned by remove is stored in sout.
                    
                    //if-else statement to check the returned value and print the appropriate output. 
                    if(sout==null){
                       System.out.println("Sheet Does Not Exist or it is the only Sheet in the Workbook! Task Ended.");
                    }
                    else{
                       System.out.println("The Sheet: "+sout+" Has Been Deleted Succesfully.");
                    }
                    break;
                  }
                
          case 4: {
                    System.out.println("Enter the name of the sheets (from,to): ");
                    inNamef = input.next(); //User inputs the name of the 'from' sheet to be moved.
                    inNamet = input.next(); //User inputs the name of the 'to' sheet where from is to be moved to.
                    System.out.println("Enter '1' for Before or '2' for After: ");
                    temp = input.nextInt(); //User inputs the value to indicate before or after the 'to' sheet.
                    
                    //if-else statement to check the value in temp and set the boolean variable before as 'true' or 'false'.
                    if(temp==1){
                       before = true;
                    }
                    else if(temp==2){
                       before = false;
                    }
                    else{
                       System.out.println("Invalid Input! Task Ended."); //if the user enters any other value apart from 1 and 2, the program throws this error and ends the task. 
                       break;
                    }
                
                    iout = move(inNamef, inNamet, before); //move method called with the sheet names and before passed as parameters. Value returned by move is stored in iout.
                    
                    //if-else statement to check the returned value and print the appropriate output.
                    if(iout==-1){
                       System.out.println ("Sheet(s) Does/Do Not Exist or The Two Names were The Same! Task Ended.");
                    }
                    else{
                       System.out.println("Sheet Has Been Moved Successfully to Index: "+iout); 
                    }                  
                    break;
                  }
                
          case 5: {
            
                    System.out.println("Enter the index of the sheets (from,to): ");
                    indexf = input.nextInt(); //User inputs the index of the 'from' sheet to be moved.
                    indext = input.nextInt(); //User inputs the index of the 'to' sheet where 'from' is to be moved to.
                    System.out.println("Enter '1' for Before or '2' for After: ");
                    temp = input.nextInt(); //User inputs the value to indicate before or after the 'to' sheet.
                    
                    //if-else statement to check the value in temp and set the boolean variable before as 'true' or 'false'.
                    if(temp==1){
                       before = true;
                    }
                    else if(temp==2){
                       before = false;
                    }
                    else{
                       System.out.println("Invalid Input! Task Ended.");
                    }
                    
                    sout = move(indexf, indext, before); //move method called with the sheet indices and before passed as parameters. Value returned by move is stored in sout.
                    
                    //if-else statement to check the returned value and print the appropriate output.
                    if(sout==null){
                       System.out.println("Sheet(s) Does/Do Not Exist or The Two Indices were equal! Task Ended.");
                    }
                    else{
                       System.out.println("The Sheet "+sout+" Has Been Moved Successfully.");
                    }                   
                    break;
                  }
                
          case 6: {
                    System.out.println("Enter the name of the sheet: ");
                    inNamef = input.next(); //User inputs sheetname
                    
                    iout = moveToEnd(inNamef); //moveToEnd method called and the rdeturned value is stored in iout
                    
                    //if-else statement to check the returned value and print the appropriate output.
                    if(iout==-1){
                       System.out.println("Sheet Does Not Exist or is Already at The End! Task Ended.");
                    }
                    else{
                       System.out.println("Sheet Has Been Moved To The End Successfully from Index: "+iout);
                    }                  
                    break;
                  }
                
          case 7: {
                    System.out.println("Enter the index of the sheet: ");
                    indexf = input.nextInt(); //User inputs sheet Index
                    
                    sout = moveToEnd(indexf); //moveToEnd method called and the rdeturned value is stored in sout
                    
                    //if-else statement to check the returned value and print the appropriate output.
                    if(sout==null){
                       System.out.println("Sheet Does Not Exist or is Already at The End! Task Ended.");
                    }
                    else{
                       System.out.println("The Sheet: "+sout+" Has Been Moved To The End Successfully.");
                    }                 
                    break;
                  }
                
          case 8: {
                    System.out.println("Enter current name of sheet: ");
                    inNamef = input.next(); //User inputs sheetname
                    System.out.println("Enter new name of sheet: ");
                    inNamet = input.next(); //User inputs sheetname
                    
                    iout = rename(inNamef,inNamet); //rename method called and returned value stored in iout
                     
                    //if-else statement to check the returned value and print the appropriate output.
                    if(iout==-1){
                       System.out.println("Sheet Does Not Exist or New Name is already in use! Task Ended.");
                    }
                    else{
                       System.out.println("Sheet Renamed Succesfully!");
                       System.out.println("The New Sheetname is: "+Names[iout]+" At Index: "+iout);
                    }                  
                    break;
                  }
                
          case 9: {
                    System.out.println("Enter the name of the sheet: ");
                    inNamef = input.next(); //User inputs sheetname
                    
                    iout = index(inNamef); //index method called and returned value is stored in iout
                    
                    //if-else statement to check the returned value and print the appropriate output.
                    if(iout!=-1){
                       System.out.println("The Sheet Index is: "+iout);
                    }
                    else{
                       System.out.println ("Sheet Does Not Exist! Task Ended."); 
                    }
                  
                    break;
                  }
                
          case 10:{ 
                    System.out.println("Enter the index of the sheet: ");
                    indexf = input.nextInt(); //User inputs sheet Index
                    
                    sout = sheetName(indexf); //sheetName method called and returned value is stored in sout
                    
                    //if-else statement to check the returned value and print the appropriate output.
                    if(sout==null){
                       System.out.println ("Sheet Does Not Exist! Task Ended.");
                    }
                    else{
                       System.out.println("The Name of the Sheet is: "+sout); 
                    }                  
                    break;
                  }
                 
          case 11:{ 
                    display(); //Display method called
                    break;
                  }
        
          case 12:{ 
                    iout = length(); //length method called and returned value is stored in iout
                  
                    System.out.println("The Total Number of Sheets Are: "+iout); //Printing the number of sheets in the workbook                 
                    break;
                  }
                 
        }
      }while(ch<13); //Condition check for while loop
      
      //if-else statement to check the value of ch and print the appropriate output.
      if(ch==13){
          System.out.println("Thank You for using our Spreadsheet Manager.");
      }
      else if(ch>13){
          System.out.println("Invalid input! Program Terminated.");
      }
    
    }
    
    //Add Method: Type Boolean
    public static boolean add() {
      //Variable Declaration and Initialisation
      boolean task = true;
      I = length(); //Number of names in list stored in I by calling the Length() method

      //If workbook is full, set return value as false else add a new sheet to the list.
      if(I==256){ 
           task = false; 
        }
      else{ 
        Names[I] = "Sheet" + N; //New sheet with Name as "Sheet" concatenated with the value of N. 
        N++; //Incrementing N for the name of the next sheet.
      }
    
      return task; //returning the boolean value
      
    }
    
    //remove method of type int using sheetName as argument
    public static int remove(String sheetName){
      //Variable Declaration and Initialisation
      int task = index(sheetName), i = 0;
      i = index(sheetName); //index of sheet stored in i using the index method
      I = length(); //Number of names in list stored in I by calling the Length() method
      
      if(i==-1||I==1){ //If the sheet is not found or the workbook contains only one sheet, set task to -1. 
          task = -1;
      }
      else{ //else remove the sheet and re-arrange the list of names by moving the names back by one position.
          Names[i] = null; //Set the specified sheet to null
              for(int x=i;x<I;x++){
                  if(x==255){ //If x has reached the last element of the list. This step avoids the 'out of bounds exception' caused in the else part when x is 255 and x+1 becomes 256.
                      Names[x] = null; //Make last element null
                      x = I; //Set counter of for loop to stopping condition
                  }
                  else{
                      Names[x] = Names[x+1]; //Moving elements one position behind
                  }
               }
      }
  
      return task; //returning the integer value
    
    }
    
    //remove method as type string using sheet index as argument
    public static String remove(int index){
      //Variable Declaration and Initialisation
      String task = Names[index]; //Name of sheet stored in task using the index value passed
      I = length(); //Number of names in list stored in I by calling the Length() method
      
      if(index>=I||I==1){ //If index entered is greater than the last index used, that is if sheet does not exist or if theres only one sheet in the workbook, set task to null.
          task = null;
      }
      else{ //else remove the sheet and re-arrange the list of names by moving the names back by one position.
         Names[index] = null; //Setting the specified sheet to null
         for(int x=index;x<I;x++){
                if(x==255){ //If x has reached the last element of the list. This step avoids the 'out of bounds exception' caused in the else part when x is 255 and x+1 becomes 256.
                      Names[x] = null; //Make last element null
                      x = I; //Set counter of for loop to stopping condition
                  }
                  else{
                      Names[x]=Names[x+1]; //Moving elements one position behind
                  }
            }
      }
      
      return task; //returning the string value
      
    }
    
    //move method as type int using sheetnames and a boolean indicator as arguments
    public static int move(String from,String to, boolean before){
      //Variable Declaration and Initialisation
      int index1 = -1,  index2 = -1, task = 0;
      String temp = "";
        
      if(from.equals(to)){ //If the two names entered are the same, set task to -1. 
          task = -1;
      }
      else{ //else get the index of the sheets passed using the index method
          index1 = index(from);
          index2 = index(to);
      }
           
      if(index1==-1 || index2==-1){ //If one or more sheets do not exist, set task to -1. 
          task = -1;
      }
      else{ //else perform the move task
          temp = Names[index1]; //store the from name in a temporary variable
          if(index1<index2){ //Check for direction of move. If index1 is less than index2 then direction is forward
                if(before){ //If before is true move all sheets back by one position except for 'to' and store the 'from' sheet before 'to'
                    for(int i=index1;i<index2;i++){
                         Names[i]=Names[i+1]; 
                    }
                    Names[index2-1]=temp;
                    task = (index2-1); //Giving task the new sheet index of the moved sheet
                }
                else{ //else move all sheets including 'to' back by one position and store 'from' at the old position of 'to'
                    for(int i=index1;i<index2;i++){ 
                         Names[i]=Names[i+1];
                    }  
                    Names[index2]=temp;
                    task = index2; //Giving task the new sheet index of the moved sheet
                }
          }
          else{ //else the direction of move is backward
                if(before){ //If before is true move all sheets forward including 'to' by one position and store the 'from' sheet at the old position of 'to'
                    for(int i=index1;i>index2;i--){
                         Names[i]=Names[i-1]; 
                    }
                    Names[index2]=temp;
                    task = index2; //Giving task the new sheet index of the moved sheet
                }
                else{ //else move all sheets forward by one position except for 'to' and store the 'from' sheet after 'to'
                    for(int i=index1;i>index2;i--){ 
                         Names[i]=Names[i-1];
                    }  
                    Names[index2+1]=temp;
                    task = (index2+1); //Giving task the new sheet index of the moved sheet
                }
                        
          }                        
      }
           
      return task; //returning the integer value
          
    }
    
    //move method of type string using sheet indices and a boolean indicator as arguments
    public static String move(int from, int to, boolean before){
      //Variable Declaration and Initialisation
      String task = sheetName(from),temp = "",Name1 = "", Name2 = ""; //task is given the name of the sheet to be moved. It either gets the right name or null.
      int i = 0;

      if(from!=to){ //Check if from and to are not equal. if true get their names using the sheetName method and go ahead
         Name1 = sheetName(from);
         Name2 = sheetName(to);
         if(Name1 == null || Name2 == null){ //If one or both names do not exist, then set task to null. 
             task = null;
         }
         else{ //else perform the move task
             temp = Names[from]; //store the from name in a temporary variable
             if(from<to){ //Check for direction of move. If from is less than to, then direction is forward
                 if(before){ //If before is true move all sheets back by one position except for 'to' and store the 'from' sheet before 'to'
                     for(i=from;i<to;i++){ 
                           Names[i]=Names[i+1];
                     }
                     Names[to-1]=temp;
                 }
                 else{ //else move all sheets including 'to' back by one position and store 'from' at the old position of 'to'
                     for(i=from;i<to;i++){ 
                           Names[i]=Names[i+1];
                     }  
                     Names[to]=temp;
                 }
             }
             else{ //else the direction of move is backward
                 if(before){ //If before is true move all sheets forward including 'to' by one position and store the 'from' sheet at the old position of 'to'
                     for(i=from;i>to;i--){
                           Names[i]=Names[i-1]; 
                     }
                     Names[to]=temp;
                 }
                 else{ //else move all sheets forward by one position except for 'to' and store the 'from' sheet after 'to'
                     for(i=from;i>to;i--){ 
                           Names[i]=Names[i-1];
                     }  
                     Names[to+1]=temp;
                 }
             }
        }
      }
      else{ //else set task to null since from == to.  
          task = null; 
      }

      return task; //returning the string value
    
    }
    
    //moveToEnd method of type string using sheet index as argument
    public static String moveToEnd(int from){
      //Variable Declaration and Initialisation
      String Name = Names[from], task = Names[from], temp = ""; //Both Name and task get the name of the sheet to be moved or null. 
      I = length(); //Number of names in list stored in I by calling the Length() method
      
      if(Name==null||I==1||from==(I-1)){ //If Name is null that is sheet does not exist or there is onle one sheet in the workbook or the sheet is alread at the end, then set task to null. 
          task = null;
      }
      else{ //else perform the moveToEnd task
          temp = Names[from]; //Store the sheet name in a temporary variable
          for(int i=from;i<I;i++){
               if(i==255){ //If i has reach the last index of the list then store the sheet name here. This avoids the 'out of bounds exception' caused in the else part when x is 255 and x+1 becomes 256.
                   Names[i] = temp;
               }
               else{ //else move sheet name back by one position
                   Names[i]=Names[i+1];   
               }
          }
          Names[I-1] = temp; //store sheet name at the end of the current list
      }

      return task; //returning the string value
    
    }
    
    //moveToEnd method of type int using sheet name as argument
    public static int moveToEnd(String from){
      //Variable Declaration and Initialisation
      int i = 0, k = 0, task = index(from); //task gets the index of the sheet to be moved using the index method
      String temp = "";
     
      i = index(from); //i gets the index of the sheet to be moved using the index method
      temp = from; //temp stores the name of the sheet
      I = length(); //Number of names in list stored in I by calling the Length() method
      
      if(i==-1||I==1||i==(I-1)){ //If i is -1 that is sheet does not exist or there is only one sheet in the workbook or the sheet is already at the end, set task to -1.
          task = -1;
      }
      else{ //else perform the moveToEnd task
          for(k=i;k<I;k++){
               if(k==255){ //If i has reach the last index of the list then store the sheet name here. This avoids the 'out of bounds exception' caused in the else part when x is 255 and x+1 becomes 256.
                   Names[k] = temp;
               }
               else{ //else move sheet name back by one position
                   Names[k]=Names[k+1]; 
               }
          }
          Names[I-1] = temp; //store sheet name at the end of the current list
      }
      
      return task; //returning the integer value
      
    }
    
    //rename method of type int using sheetnames as arguments
    public static int rename(String currentName, String newName){
      //Variable Declaration and Initialisation
      int i = 0, task = 1,j = 0;
       
      j = index(newName); //j gets the index of the new name from the list if it already exists else -1.
      i = index(currentName); //i gets the index of the sheet to be renamed if it exists else -1. 
      if(j!=-1){ //If new is already being used, set task to -1. 
          task = -1;
      }
      else{ //else go ahead
         if(i==-1){ //If sheet to be renamed does not exist, set task to -1. 
             task = -1;
         }
         else{ //else rename the sheet
             Names[i] = newName; //Sheet gets renamed
             task = i; //task gets the index of the sheet
         }
      }
      return task; //returning the integer value
    
    }
    
    //index method of type int using sheetname as argument
    public static int index(String sheetName){
      //Variable Declaration and Initialisation
      int index = -1; //index is initialised to -1 

      I = length(); //Number of names in list stored in I by calling the Length() method
      
      for(int i=0;i<I;i++){ //Search the list for the name entered
          if(Names[i].equals(sheetName)){ //If name found then store its index in the variable 'index' else index remains -1. 
              index = i;
           }
      }
    
      return index; //returning the integer value
     
    }
    
    //sheetName method of type string using sheet index as argument
    public static String sheetName(int index){
      //Variable Declaration and Initialisation
      String Name = "";
     
      I = length(); //Number of names in list stored in I by calling the Length() method
      
      if(index>=I){ //If the index entered is greater than the last index used then sheet does not exist hence set Name to null.
          Name = null;
      }
      else{ //else store the name from the list into the variable Name
          Name = Names[index];
      }
    
      return Name; //returning the string value
    
    }
    
    //display method of type void
    public static void display(){
    
      I = length(); //Number of names in list stored in I by calling the Length() method
      System.out.println("The stored Sheets are: ");
      for(int i=0;i<I;i++){ //Print all the sheets currently stored in the workbook
           System.out.println(i+") "+Names[i]);  
      }

    }
    
    //length method of type int
    public static int length(){
      //Variable Declaration and Initialisation
      String Name = null;
      int C = 0;

      for(int i=0;i<256;i++){ //Search the array for null and increment counter 'C' until null is found.
           Name = Names[i];
           if(Name==null){ //If null is found
               i=256; //Set i to the stopping condition of the for loop 
           }
           else{ //else
               C++; //increment counter 'C'
           }
      }
      
      return C; //returning the integer value
    }    

}






