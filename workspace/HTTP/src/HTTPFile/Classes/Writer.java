package HTTPFile.Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import HTTPFile.Interfaces.IWriter;

public class Writer implements IWriter
{
    public void write(String fileName, String text) 
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
                out.append(text);
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