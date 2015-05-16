package Threads;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class Loader implements Runnable
{
	private String path;
	private int count = 0;
	private int nLines;
	private int startPos;
	BufferedReader in;
	BlockingQueue<String> queueLines;
				
	public Loader(String p, int s, int n, BlockingQueue<String> lines) throws IOException
	{
		path = p;
		nLines = n;
		startPos = s;
		in = new BufferedReader(new FileReader(path));
		queueLines = lines;
	}
				
	@Override
	public void run()
	{
		try {
				String line;
				
				while (count < startPos)
				{
					count++;
					readLine();
				}
				
				while (count >= startPos && count <= (startPos + nLines) && (line = readLine()) != null) 
				{
					queueLines.put(line);
					count++;
				}
										
			} 
			catch (InterruptedException ex)
			{
				ex.printStackTrace();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
	
	}
	
	public String readLine() throws IOException
	{
		return in.readLine();
	}
}