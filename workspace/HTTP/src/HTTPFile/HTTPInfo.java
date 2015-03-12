package HTTPFile;

public class HTTPInfo 
{
	private String Host; 
	
	private String Time;
	
	private String Request;
	
	private int Reply;
	
	private int Bytes;
	
	public HTTPInfo(String host, String time, String request, int reply, int bytes)
	{
		Host = host;
		Time = time;
		Request = request;
		Reply = reply;
		Bytes = bytes;
	}

}
