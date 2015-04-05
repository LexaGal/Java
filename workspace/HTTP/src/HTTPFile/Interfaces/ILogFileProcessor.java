package HTTPFile.Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import HTTPFile.Classes.AccessLog;
import HTTPFile.Classes.ReportData;

public interface ILogFileProcessor
{
	List<AccessLog> getLogs();
	ReportData process(String DataBasePath, String StarterPosition, String RowsAmount, String OutBasePath, String ReportPath, String ReportNumber) throws FileNotFoundException, IOException;
}