
public class Driver extends SpreadSheetManager{
    
    public static void main(){
        
    int iout = 0;
    String sout = "";
    boolean bout = false;
    
    Names[0] = "Sheet1";
    Names[1] = "Sheet2";
    Names[2] = "Sheet3";
        
    System.out.println("Adding 17 Sheets (First 3 are intialised by default thus total 20): ");
    for(int i=0;i<17;i++){
        add();
    }
    display();
    
    System.out.println("Removing a sheet using the Name: ");
    iout = remove("Sheet10");
    if(iout==-1){
         System.out.println("Sheet Does Not Exist or it is the only Sheet in the Workbook! Task Ended.");
    }
    else{
         System.out.println("The Sheet Has Been Deleted Succesfully from Index: "+iout);
    }
    
    System.out.println("Removing a sheet that does not exist using the Name: ");
    iout = remove("Sheet200");
    if(iout==-1){
         System.out.println("Sheet Does Not Exist or it is the only Sheet in the Workbook! Task Ended.");
    }
    else{
         System.out.println("The Sheet Has Been Deleted Succesfully from Index: "+iout);
    }
    
    System.out.println("Removing a sheet using index: ");
    sout = remove(5);
    if(sout==null){
          System.out.println("Sheet Does Not Exist or it is the only Sheet in the Workbook! Task Ended.");
    }
    else{
          System.out.println("The Sheet: "+sout+" Has Been Deleted Succesfully.");
    }
    
    System.out.println("Removing a sheet that does not exist using the index: ");
    sout = remove(30);
    if(sout==null){
          System.out.println("Sheet Does Not Exist or it is the only Sheet in the Workbook! Task Ended.");
    }
    else{
          System.out.println("The Sheet: "+sout+" Has Been Deleted Succesfully.");
    }
    
    display();
    
    System.out.println("Moving a sheet that does not exist using the Name in the backward direction and before: ");
    iout = move("Sheet36","Sheet2",true);
    if(iout==-1){
         System.out.println ("Sheet(s) Does/Do Not Exist or The Two Names were The Same! Task Ended.");
    }
    else{
         System.out.println("Sheet Has Been Moved Successfully to Index: "+iout); 
    }
    
    System.out.println("Moving a sheet in the forward direction using the Name and before: ");
    iout = move("Sheet2","Sheet7",true);
    if(iout==-1){
         System.out.println ("Sheet(s) Does/Do Not Exist or The Two Names were The Same! Task Ended.");
    }
    else{
         System.out.println("Sheet Has Been Moved Successfully to Index: "+iout); 
    }
    
    System.out.println("Moving a sheet in the backward direction using the Name and after: ");
    iout = move("Sheet9","Sheet1",false);
    if(iout==-1){
         System.out.println ("Sheet(s) Does/Do Not Exist or The Two Names were The Same! Task Ended.");
    }
    else{
         System.out.println("Sheet Has Been Moved Successfully to Index: "+iout); 
    }
    
    System.out.println("Moving a sheet in the forwardward direction using the indices and after: ");
    sout = move(4,11,false);
    if(sout==null){
         System.out.println("Sheet(s) Does/Do Not Exist or The Two Indices were equal! Task Ended.");
    }
    else{
         System.out.println("The Sheet "+sout+" Has Been Moved Successfully.");
    } 
    
    display();
    
    System.out.println("Moving a sheet to the end, that does not exist, using the Name: ");
    iout = moveToEnd("Sheet236");
    if(iout==-1){
         System.out.println("Sheet Does Not Exist or is Already at The End! Task Ended.");
    }
    else{
         System.out.println("Sheet Has Been Moved To The End Successfully from Index: "+iout);
    }
    
    System.out.println("Moving a sheet to the end using the Name: ");
    iout = moveToEnd("Sheet8");
    if(iout==-1){
         System.out.println("Sheet Does Not Exist or is Already at The End! Task Ended.");
    }
    else{
         System.out.println("Sheet Has Been Moved To The End Successfully from Index: "+iout);
    }
    
    display();
    
    System.out.println("Moving a sheet to the end, that is already at the end, using the index: ");
    sout = moveToEnd(17);
    if(sout==null){
         System.out.println("Sheet Does Not Exist or is Already at The End! Task Ended.");
    }
    else{
         System.out.println("The Sheet: "+sout+" Has Been Moved To The End Successfully.");
    }
    
    System.out.println("Moving a sheet to the end using the index: ");
    sout = moveToEnd(6);
    if(sout==null){
         System.out.println("Sheet Does Not Exist or is Already at The End! Task Ended.");
    }
    else{
         System.out.println("The Sheet: "+sout+" Has Been Moved To The End Successfully.");
    }
    
    display();
    
    System.out.println("Renaming a sheet to an already existing name: ");
    iout = rename("Sheet15","Sheet16");
    if(iout==-1){
         System.out.println("Sheet Does Not Exist or New Name is already in use. Task Ended.");
    }
    else{
         System.out.println("Sheet Renamed Succesfully!");
         System.out.println("The New Sheetname is: "+Names[iout]+" At Index: "+iout);
    }
    
    System.out.println("Renaming a sheet to Limerick: ");
    iout = rename("Sheet15","Limerick");
    if(iout==-1){
         System.out.println("Sheet Does Not Exist or New Name is already in use.  Task Terminated.");
    }
    else{
         System.out.println("Sheet Renamed Succesfully!");
         System.out.println("The New Sheetname is: "+Names[iout]+" At Index: "+iout);
    }
    
    display();
    
    System.out.println("Getting the index of a sheet using name: ");
    iout = index("Sheet16");
    if(iout!=-1){
         System.out.println("The Sheet Index is: "+iout);
    }
    else{
         System.out.println ("Sheet Does Not Exist! Task Ended."); 
    }
    
    System.out.println("Getting the name of a sheet using index: ");
    sout = sheetName(12);
    if(sout==null){
         System.out.println ("Sheet Does Not Exist! Task Ended.");
    }
    else{
         System.out.println("The Name of the Sheet is: "+sout); 
    }
    
    for(int i=0;i<256;i++){
          add();
    }
    iout = length();
    System.out.println("The Total Number of Sheets Are: "+iout);
    
    System.out.println("Adding 256 sheets and testing the upper limit: ");
    bout = add();
    if(bout){
         System.out.println ("New Sheet Added: "+(I)+") "+Names[I]);
    }
    else{
         System.out.println("Max Number of Sheets Reached! Task Ended.");
    }
    

    }
    
    
}
