package HTTPFile.Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import HTTPFile.Interfaces.ILogFileProcessor;
import HTTPFile.Interfaces.ILogSearcher;
import HTTPFile.Interfaces.IParserForLog;
import HTTPFile.Interfaces.IReader;
import HTTPFile.Interfaces.IReportCreator;
import HTTPFile.Interfaces.IReporter;
import HTTPFile.Interfaces.IUtf8Converter;
import HTTPFile.Interfaces.IWriter;

public class LogFileProcessor implements ILogFileProcessor
{
	IParserForLog parser;
    IWriter logWriter;
    ILogSearcher logSearcher;
	
    List<AccessLog> Logs;

    public LogFileProcessor(IWriter logWriter, IParserForLog parser, ILogSearcher logSearcher) {
        this.logWriter = logWriter;
        this.parser = parser;
        this.logSearcher = logSearcher;
	}
	
    public List<AccessLog> getLogs(){
         return this.Logs;
     }
    
    @Override
    public ReportData process(String DataBasePath, String StarterPosition, String RowsAmount, String OutBasePath, String ReportPath, String ReportNumber) throws IOException {
        	   	
        Logs = new Vector<AccessLog>();
     
	    String dataBasePath = DataBasePath;
	    String reportPath = ReportPath;
	    int starterPosition = Integer.parseInt(StarterPosition) + 1;
	    int rowsAmount = Integer.parseInt(RowsAmount) - 1;
	    String outBasePath = OutBasePath;
	    
	    IReader textReader = new Reader(dataBasePath);
	    String[] RequiredStrings = textReader.GetStrings(starterPosition, rowsAmount).split("\n");
	    List<String> logStrings = new Vector<String>();
	    	        
	    int count = 0;
	    BufferedReader in = new BufferedReader(new FileReader(dataBasePath));
        //while (count - starterPosition != rowsAmount)
        //{
          //  count++;
          //  logStrings.add(textReader.GetString(in));
        //}
               
	    //UTF-8 { 
	    
	    //IUtf8Converter utf8Converter = new Utf8Converter();		
		//utf8Converter.writeBinary(RequiredStrings, "B:\\UTF8.dat");	
		//List<String> strings = utf8Converter.readBinary("B:\\UTF8.dat");
	    
	    //} UTF-8 
	    
	    for (String str : RequiredStrings)
	    {
	    	Logs.add(parser.getAccessLog(str));
	    }
	    	    
	    File file = new File(outBasePath);
	    file.delete();     
	    file = new File(reportPath);
	    file.delete();     
	    
	    file = new File(outBasePath);
	    
        
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
        	for(AccessLog str : Logs)
            { 
    	    	logWriter.write(out, str);
            }
    	}
        finally
        {
            out.close();
        }
          
        	
        IReporter Reporter = new Reporter(logSearcher, logWriter);
        int reportNumber = Integer.parseInt(ReportNumber);
        
        AccessLog first = (AccessLog) Logs.toArray()[0];
        String[] strs = first.getTimestamp().toString().split(" ");
        int firstDate = Integer.parseInt(strs[2]);
        
        AccessLog last = (AccessLog) Logs.toArray()[Logs.size() - 1];
        strs = last.getTimestamp().toString().split(" ");
        int lastDate = Integer.parseInt(strs[2]);
        
        return new ReportData(firstDate, lastDate, 5, Logs, reportPath, reportNumber);
    }
       
    	
}