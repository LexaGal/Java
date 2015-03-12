package HTTPFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;


public class HTTPProcessor
{
	public static void main(String[] args) throws FileNotFoundException
    {
        String dataBasePath = args[0];
        int starterPosition = Integer.parseInt(args[1]);
        int rowsAmount = Integer.parseInt(args[2]);
        String outBasePath = args[3];
        
        Reader textReader = new Reader(dataBasePath);
        List<AccessLog> logs = new Vector<AccessLog>();
        String[] requiredStrings = textReader.readStrings(starterPosition, rowsAmount).split("\n");
        
        for (String str : requiredStrings)
        {
        	logs.add(new AccessLog(str));
        	Writer.write(outBasePath, new AccessLog(str).toString());
        	System.out.println(new AccessLog(str).toString());
        }
               
       
    }
}
