package HTTPFile.Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import HTTPFile.Interfaces.ILogFileProcessor;
import HTTPFile.Interfaces.IParserForLog;
import HTTPFile.Interfaces.IReader;
import HTTPFile.Interfaces.IWriter;

public class LogFileProcessor implements ILogFileProcessor
{

@Override
public  void process(String DataBasePath, String StarterPosition, String RowsAmount, String OutBasePath) throws FileNotFoundException 
{

    List<AccessLog> Logs = new Vector<AccessLog>();

    String dataBasePath = DataBasePath;
    int starterPosition = Integer.parseInt(StarterPosition) + 1;
    int rowsAmount = Integer.parseInt(RowsAmount) - 1;
    String outBasePath = OutBasePath;
    
    IReader textReader = new Reader(dataBasePath);
    String[] RequiredStrings = textReader.GetStrings(starterPosition, rowsAmount).split("\n");
    
    for (String str : RequiredStrings)
    {
        IParserForLog parser = new ParserForLog();
        Logs.add(parser.getAccessLog(str));
    }
    
    File file = new File(outBasePath);
    file.delete();     
      
    for (AccessLog str : Logs)
    {
        IWriter logWriter = new Writer();
        logWriter.write(outBasePath, str.toString());
    }
}
}