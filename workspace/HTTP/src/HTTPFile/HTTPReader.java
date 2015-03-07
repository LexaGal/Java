package HTTPFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;


public class HTTPReader
{
	public static void main(String[] args) throws FileNotFoundException
    {
        String dataBasePath = args[0];
        String outBasePath = args[3];
        int starterPosition = Integer.parseInt(args[1]);
        int rowsAmount = Integer.parseInt(args[2]);
        int c = 0;
        
        ReaderWriter textReader = new ReaderWriter(dataBasePath);
        ReaderWriter textWriter = new ReaderWriter(outBasePath);
        List<AccessLog> logs = new Vector<AccessLog>();
        String[] requiredStrings = textReader.readStrings(starterPosition, rowsAmount).split("\n");
        
        for (String str : requiredStrings)
        {
        	//System.out.print(str + '\n');
            logs.add(new AccessLog(str));
            c++;
        }
        
        textWriter.writeStrings(requiredStrings);
       
    }
}
