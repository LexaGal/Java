package HTTPFile.Classes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import HTTPFile.Interfaces.IUtf8Converter;

public class Utf8Converter implements IUtf8Converter {

	public void writeBinary(String[] strings, String path)
	{
		FileOutputStream fos = null;
	    DataOutputStream dos = null;
		
		try
		{
		    	  
			// create file output stream
	        fos = new FileOutputStream(path);
	          
	        // create data output stream
	        dos = new DataOutputStream(fos);
	          
	        // for each  string in string buffer
	        for(String j:strings)
	        {
	           // write string encoded as modified UTF-8
	           dos.writeUTF(j);
	        }
	          
	        // force data to the underlying file output stream
	        dos.flush();
			
			if(fos!=null)
	           fos.close();
	        if(dos!=null)
	           dos.close();
		}
		
		catch (FileNotFoundException ex){
		}
		
		catch (IOException ex) {
		}
	}
	
	public List<String> readBinary(String path)
	{
		InputStream is = null;
	    DataInputStream dis = null;
	    List<String> strings = new Vector<String>();
				
	    try
		{
		
		    // create file input stream
	        is = new FileInputStream(path);
	        
	        // create new data input stream
	        dis = new DataInputStream(is);
	        
	        // available stream to be read
	        while(dis.available() > 0)
	        {
	           // reads characters encoded with modified UTF-8
	           String s = dis.readUTF();
	           
	           strings.add(s);
	         
	        }
	        
	        if(is!=null)
	            is.close();
	        if(dis!=null)
	           dis.close();
		}
		
		catch (FileNotFoundException ex){
		}
		
		catch (IOException ex) {
		}
	    
		return strings;
	}

}