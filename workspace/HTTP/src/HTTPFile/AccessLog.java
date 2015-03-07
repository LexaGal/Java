package HTTPFile;

public class AccessLog
{

    public String getLocalHost()
    {
        return localHost;
    }

    public void setLocalHost(String localHost)
    {
        this.localHost = localHost;
    }

    public String getTimeStamp()
    {
        return timeStamp;
    }

    public void setTimestamp(String timeStamp)
    {
        this.timeStamp = timeStamp;
    }

    public String getRequest()
    {
        return request;
    }

    public void setRequest(String request)
    {
        this.request = request;
    }

    public int getReplyCode()
    {
        return replyCode;
    }

    public void setReplyCode(int replyCode)
    {
        this.replyCode = replyCode;
    }

    public int getReplyBytes()
    {
        return replyBytes;
    }

    public void setReplyBytes(int replyBytes)
    {
        this.replyBytes = replyBytes;
    }

    private String localHost;
    private String timeStamp;
    private String request;
    private int replyCode;
    private int replyBytes;

    public AccessLog(String str)
    {
    	try
    	{
	        String[] buffer = str.split("\"");
	        this.setRequest(buffer[1]);
	        String[] secongPart = buffer[0].split("- ");
	        this.setLocalHost(secongPart[0]);
	        this.setTimestamp(secongPart[2]);
	        secongPart = buffer[2].split(" ");
	        this.setReplyCode(Integer.parseInt(secongPart[1]));
	        this.setReplyBytes(Integer.parseInt(secongPart[2]));
    	}
    	catch(NumberFormatException e)
    	{
    	}
    }

    public String toString()
    {
        return String.format(" Host: " + getLocalHost() + "\n TimeStamp: " + getTimeStamp() + "\n Request: "
        		+ getRequest() + "\n ReplyCode: " + getReplyCode() + "\n Bytes: " + getReplyBytes());
    }

}