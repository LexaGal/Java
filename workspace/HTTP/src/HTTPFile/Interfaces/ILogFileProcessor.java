package HTTPFile.Interfaces;

import java.io.FileNotFoundException;

public interface ILogFileProcessor
{
    void process(String DataBasePath, String StarterPosition, String RowsAmount, String OutBasePath) throws FileNotFoundException;
}