package HTTPFile;

import java.io.FileNotFoundException;

import HTTPFile.Classes.LogFileProcessor;


public class Main
{
	public static void main(String[] args) throws FileNotFoundException
    {
		LogFileProcessor httpParser = new LogFileProcessor();
        httpParser.process(args[0], args[1], args[2], args[3]);
    }
}
