package FileHTTP;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HTTPReader
{

	public static void main(String[] args)
	{
		int nStr;
		int n;

		try
		{
		   FileInputStream fstream = new FileInputStream(args[2]);
		   BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		   String strLine;
		   int start = 1;
		   int number = 0;
		   
		   nStr = Integer.parseInt(args[0]);
		   n = Integer.parseInt(args[1]);
		   
		   if (nStr < 0 || n < 0) throw new Exception();
		   
				   
		   /* read log line by line */
		   while ((strLine = br.readLine()) != null)
		   {
			   start ++;
			   			   
			   if (start > nStr)
			   {
				   if (number == n) break;
				   
				   /* parse strLine */
			   	   System.out.println (strLine);
			   	   
			   	   number ++;
			   }
		   }
		   br.close();
		}
			
		catch (Exception e) 
		{
		     System.err.println("Error: " + e.getMessage());
		}
	}
}
