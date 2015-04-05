package HTTPFile.Interfaces;

import java.util.Date;
import java.util.List;

import HTTPFile.Classes.AccessLog;

public interface ILogSearcher {
    int binarySearch(Date key, List<AccessLog> list, float left, float right);
}