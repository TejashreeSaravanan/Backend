import java.io.*;
import java.lang.String;
import java.util.*;
import org.json.JSONObject; 
public class BR 
{
 static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 public void Insert( ) throws IOException
 {
   Scanner in = new Scanner (System.in);
  System.out.println("Enter the country: ");
	String country=in.next();
	System.out.println("Enter the region: ");
	String region=in.next();
	System.out.println("Enter the college name : ");
	String  college=in.nextLine();
	System.out.println("Enter the department: ");
	String dept=in.nextLine();     
  JSONObject obj= new JSONObject(); 
  obj.put("country",country);    
  obj.put("region",region);    
  obj.put("college_name",college);
  obj.put("department",dept);
  PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("BR.txt",true)));
  pw.print(obj);
  System.out.println("Details added successfully.");
  pw.close();
 }
public void delete() throws IOException
{
 PrintWriter pw = new PrintWriter("output.txt"); 
 BufferedReader br2 = new BufferedReader(new FileReader("delete.txt");  
 String line2 = br2.readLine(); 
 HashSet<String> hs = new HashSet<String>(); 
 while(line2 != null) 
  { 
    hs.add(line2); 
    line2 = br2.readLine(); 
  } 
 BufferedReader br1 = new BufferedReader(new FileReader("BR.txt")); 
 String line1 = br1.readLine(); 
 while(line1 != null) 
 {
  if(!hs.contains(line1)) 
      pw.println(line1); 
      line1 = br1.readLine(); 
  } 
          
pw.flush(); 
br1.close(); 
br2.close(); 
pw.close(); 
System.out.println("deletion successful");          
}
public static void main(String args[]) throws IOException
{
  BR in = new BR();
  in.Insert();
  in.delete();
} 
}
