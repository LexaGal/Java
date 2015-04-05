package HTTPFile;

import java.io.FileNotFoundException;
import java.io.IOException;

import HTTPFile.Classes.LogFileProcessor;
import HTTPFile.Classes.LogSearcher;
import HTTPFile.Classes.ParserForLog;
import HTTPFile.Classes.ReportData;
import HTTPFile.Classes.ReportResult;
import HTTPFile.Classes.Reporter;
import HTTPFile.Classes.Writer;
import HTTPFile.Interfaces.ILogFileProcessor;
import HTTPFile.Interfaces.ILogSearcher;
import HTTPFile.Interfaces.IParserForLog;
import HTTPFile.Interfaces.IWriter;


public class Main
{
	public static void main(String[] args) throws IOException
    {
		IParserForLog parser = new ParserForLog();
        IWriter writer = new Writer();
        ILogSearcher logSearcher = new LogSearcher();
        ILogFileProcessor processor = new LogFileProcessor(writer, parser, logSearcher);

        ReportData rd = processor.process(args[0], args[1], args[2], args[3], args[4], args[5]);
        Reporter reporter = new Reporter(logSearcher, writer);
        
        ReportResult rr = reporter.Create(rd);
    }
}
