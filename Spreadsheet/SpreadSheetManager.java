//Importing utility files for Scanner
import java.util.*;


public class SpreadSheetManager{
    
    //Global variables that will be accessible to all methods.
    public static String[] Names = new String[256]; //Names is global since all methods will read and write to the same array of sheets.
    public static int N = 3, I = 0; //N is initialised outside add() otherwise every time add() is called, it will get re-initialised to 3. I is used by many methods to store length. 
    
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
      int ch = 0, indexf = 0, indext = 0, temp = 0, iout = 0; 
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
    
        ch = input.nextInt();
    
        switch (ch){
        
          case 1: { 
                    bout = add();
                    
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
                    inNamef = input.next();
                    
                    iout = remove(inNamef);
                    
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
                    indexf = input.nextInt();
                    
                    sout = remove(indexf);
                    
                    if(sout.equals(null)){
                       System.out.println("Sheet Does Not Exist or it is the only Sheet in the Workbook! Task Ended.");
                    }
                    else{
                       System.out.println("The Sheet: "+sout+" Has Been Deleted Succesfully.");
                    }
                    break;
                  }
                
          case 4: {
                    System.out.println("Enter the name of the sheets (from,to): ");
                    inNamef = input.next();
                    inNamet = input.next();
                    System.out.println("Enter '1' for Before or '2' for After: ");
                    temp = input.nextInt(); 
                
                    if(temp==1){
                       before = true;
                    }
                    else if(temp==2){
                       before = false;
                    }
                    else{
                       System.out.println("Invalid Input!");
                       break;
                    }
                
                    iout = move(inNamef, inNamet, before);
                  
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
                    indexf = input.nextInt();
                    indext = input.nextInt();
                    System.out.println("Enter '1' for Before or '2' for After: ");
                    temp = input.nextInt(); 
                
                    if(temp==1){
                       before = true;
                    }
                    else if(temp==2){
                       before = false;
                    }
                    else{
                       System.out.println("Invalid Input!");
                    }
                    
                    sout = move(indexf, indext, before);
                  
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
                    inNamef = input.next();
                    
                    iout = moveToEnd(inNamef);
                  
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
                    indexf = input.nextInt();
                    
                    sout = moveToEnd(indexf);
                  
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
                    inNamef = input.next();
                    System.out.println("Enter new name of sheet: ");
                    inNamet = input.next();
                    
                    iout = rename(inNamef,inNamet);
                  
                    if(iout==-1){
                       System.out.println("Sheet Does Not Exist! Task Terminated.");
                    }
                    else{
                       System.out.println("Sheet Renamed Succesfully!");
                       System.out.println("The New Sheetname is: "+Names[iout]+" At Index: "+iout);
                    }                  
                    break;
                  }
                
          case 9: {
                    System.out.println("Enter the name of the sheet: ");
                    inNamef = input.next();
                    
                    iout = index(inNamef);
                  
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
                    indexf = input.nextInt();
                    
                    sout = sheetName(indexf);
                  
                    if(sout.equals(null)){
                       System.out.println ("Sheet Does Not Exist! Task Ended.");
                    }
                    else{
                       System.out.println("The Name of the Sheet is: "+sout); 
                    }                  
                    break;
                  }
                 
          case 11:{ 
                    display();
                    break;
                  }
        
          case 12:{ 
                    iout = length();
                  
                    System.out.println("The Total Number of Sheets Are: "+iout);                  
                    break;
                  }
                 
        }
      }while(ch<13);
    
      if(ch==13){
          System.out.println("Thank You for using our Spreadsheet Manager.");
      }
      else if(ch>13){
          System.out.println("Invalid input! Program Terminated.");
      }
    
    }
    
    public static boolean add() {
    
      boolean task = true;
      I = length();

      if(I==256){
           task = false;
        }
      else{ 
        Names[I] = "Sheet" + (N+1);
        N++;
      }
    
      return task;
      
    }

    public static int remove(String sheetName){
    
      int task = index(sheetName), i = 0;
      i = index(sheetName);
      I = length();
      
      if(i==-1||I==1){
          task = -1;
      }
      else{
          Names[i] = null;
              for(int x=i;x<I;x++){
                  if(x==255){
                      break;
                  }
                  else{
                      Names[x]=Names[x+1];
                  }
               }
      }
  
      return task;
    
    }

    public static String remove(int index){

      String task = Names[index];
      I = length();
      
      if(index>(I-1)||I==1){
          task = null;
      }
      else{
         Names[index] = null;
         
         for(int x=index;x<I;x++){
                if(x==255){
                      break;
                  }
                  else{
                      Names[x]=Names[x+1];
                  }
            }
      }
      
      return task;
      
    }
    
    public static int move(String from,String to, boolean before){
        
      int index1 = -1,  index2 = -1, task = 0;
      String temp = "";
        
      if(from.equals(to)){
          task = -1;
      }
      else{
          index1 = index(from);
          index2 = index(to);
      }
           
      if(index1 == -1 || index2 == -1){ 
          task = -1;
      }
      else{ 
          temp = Names[index1]; 
          if(index1<index2){
                if(before){
                    for(int i=index1;i<index2;i++){
                         Names[i]=Names[i+1]; 
                    }
                    Names[index2-1]=temp;
                    task = (index2-1);
                }
                else{ 
                    for(int i=index1;i<index2;i++){ 
                         Names[i]=Names[i+1];
                    }  
                    Names[index2]=temp;
                    task = index2;
                }
          }
          else{
                if(before){
                    for(int i=index1;i>index2;i--){
                         Names[i]=Names[i-1]; 
                    }
                    Names[index2]=temp;
                    task = index2;
                }
                else{ 
                    for(int i=index1;i>index2;i--){ 
                         Names[i]=Names[i-1];
                    }  
                    Names[index2+1]=temp;
                    task = (index2+1);
                }
                        
          }                        
      }
           
      return task;
          
    }

    public static String move(int from, int to, boolean before){
 
      String task = sheetName(from),temp = "",Name1 = "", Name2 = "";
      int i = 0;

      if(from!=to){
         Name1 = sheetName(from);
         Name2 = sheetName(to);
         if(Name1 == null || Name2 == null){
             task = null;
         }
         else{
             temp = Names[from] ; 
             if(from<to){
                 if(before){
                     for(i=from;i<to;i++){
                           Names[i]=Names[i+1];
                     }
                     Names[to-1]=temp;
                 }
                 else{ 
                     for(i=from;i<to;i++){ 
                           Names[i]=Names[i+1];
                     }  
                     Names[to]=temp;
                 }
             }
             else{
                 if(before){
                     for(i=from;i>to;i--){
                           Names[i]=Names[i-1]; 
                     }
                     Names[to]=temp;
                 }
                 else{ 
                     for(i=from;i>to;i--){ 
                           Names[i]=Names[i-1];
                     }  
                     Names[to+1]=temp;
                 }
             }
        }
      }
      else{
          task = null; 
      }

      return task;
    
    }

    public static String moveToEnd(int from){

      String Name= "", task = Names[from], temp = "";
      I = length();
      if(Name==null||I==1||from==(I-1)){
          task = null;
      }
      else{
          temp = Names[from];
          for(int i=from;i<I;i++){
               if(i==255){
                   Names[i] = temp;
               }
               else{
                   Names[i]=Names[i+1];   
               }
          }
          Names[I-1] = temp;
      }

      return task;
    
    }

    public static int moveToEnd(String from){
    
      int i = 0, k = 0, task = index(from); 
      String Name= "",  temp = "";
     
      i = index(from);
      temp = from;
      I = length();
      
      if(i==-1||I==1||i==(I-1)){
          task = -1;
      }
      else{     
          for(k=i;k<I;k++){
               if(k==255){
                   Names[k] = temp;
               }
               else{
                   Names[k]=Names[k+1]; 
               }
          }
          Names[I-1] = temp;
      }
      
      return task;
      
    }
    
    public static int rename(String currentName, String newName){

      int i = 0, task = 1;

      i = index(currentName);
      
      if(i==-1){
          task = -1;
      }
      else{
          Names[i] = newName;
          task = i;
      }

      return task;
    
    }

    public static int index(String sheetName){
    
      int index = -1;

      I = length();
      
      for(int i=0;i<I;i++){
          if(Names[i].equals(sheetName)){
              index = i;
           }
      }
    
      return index; 
     
    }

    public static String sheetName(int index){
    
      String Name = "";
     
      I = length();
      
      if(index>I){
          Name = null;
      }
      else{
          Name = Names[index];
      }
    
      return Name;
    
    }

    public static void display(){
    
      I = length();
      
      for(int i=0;i<I;i++){
           System.out.println(i+") "+Names[i]);  
      }

    }

    public static int length(){
    
      String Name = null;
      int C = 0;

      for(int i=0;i<256;i++){
           Name = Names[i];
           if(Name==null){
               i=256;
           }
           else{
               C++;
           }
      }
      
      return C;
      
    }

}



