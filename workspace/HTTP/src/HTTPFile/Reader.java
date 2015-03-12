package HTTPFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
  	
	public class Reader
	{
	    private String path;

	    public Reader(String fileName) throws FileNotFoundException
	    {
	        exists(fileName);
	        this.path = fileName;
	    }

	    private void exists(String fileName) throws FileNotFoundException
	    {
	        File dataBase = new File(fileName);
	        if (!dataBase.exists())
	        {
	            throw new FileNotFoundException(dataBase.getName());
	        }
	    }

	    public String readStrings(int readFrom, int rowsToRead)
	    {
	        StringBuilder list = new StringBuilder();

	        try
	        {
	            BufferedReader in = new BufferedReader(new FileReader(this.path));
	            
	            try
	            {
	                String bufferLine;
	                int count = 0;
	                while ((bufferLine = in.readLine()) != null && count - readFrom != rowsToRead)
	                {
	                    count++;
	                    if (count >= readFrom)
	                    {
	                        list.append(bufferLine);
	                        list.append('\n');
	                    }
	                }
	            }
	            finally
	            {
	                in.close();
	            }
	        }
	        catch (IOException e)
	        {
	            throw new RuntimeException(e);
	            
	        }
	        return list.toString();
	    } 
	}

