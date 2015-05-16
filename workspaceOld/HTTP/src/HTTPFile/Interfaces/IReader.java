package HTTPFile.Interfaces;

import java.io.BufferedReader;

public interface IReader
{
    String GetStrings(int readFrom, int rowsToRead);

	String GetString(BufferedReader in);
}