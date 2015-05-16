package HTTPFile.Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import HTTPFile.Interfaces.IWriter;

public class Writer implements IWriter
{
    public <Type> void write(String fileName, List<Type> text) 
    {
        File file = new File(fileName);

        try
        {
            if (!file.exists()) 
            {
                file.createNewFile();
            }
            
            FileWriter fileWriter;
            fileWriter = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter out;
            out = new BufferedWriter(fileWriter);

            try
            {
               int count = 0;	
               
        	   for(Type str : text)
               {
	                count ++;
	                try
	                {
	                	out.append("\n " + String.valueOf(count) + ") " + str.toString());
	                }
	                catch(Exception exception)
	                {
	                	System.out.println(exception.getMessage());
	                	continue;
	                }
               }
        	}
            
            finally
            {
                out.close();
            }
        } 
        catch (IOException e)
        {
            throw new RuntimeException(e);
       }
    }

}