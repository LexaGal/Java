package HTTPFile.Interfaces;

import HTTPFile.Classes.AccessLog;

public interface IParserForLog
{
    AccessLog getAccessLog(String str);
}