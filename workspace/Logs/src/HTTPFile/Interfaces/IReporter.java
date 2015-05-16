package HTTPFile.Interfaces;

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;

import HTTPFile.Classes.AccessLog;

public interface IReporter {
	
    List<Entry<String, Integer>> MostOften(int starterData, int finalData, int amount, List<AccessLog> Logs, String ReportPath);

    int SumAnswers(int starterDate, int finalDate, List<AccessLog> Logs, String ReportPath) throws IOException;

    int MaxBytesPerAnswer(int starterDate, int finalDate, List<AccessLog> Logs, String ReportPath) throws IOException;
}