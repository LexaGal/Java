package HTTPFile.Interfaces;

import java.io.IOException;

public interface IReportCreator<ReportData, ReportResult> {

	public ReportResult Create(ReportData data) throws IOException;
	
}
