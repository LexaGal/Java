package HTTPFile.Interfaces;

import java.util.List;

public interface IUtf8Converter {
	
	List<String> readBinary(String path);
	void writeBinary(String[] strings, String path); 
}
