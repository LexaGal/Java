package HTTPFile.Classes;

import HTTPFile.Interfaces.IParserForLog;


public class ParserForLog implements IParserForLog
{
    @Override
    public AccessLog getAccessLog(String str)
    {
         AccessLog buffer;
         String[] buffers;
         String[] secondPart;
         
         try
         {
        	 buffer = new AccessLog(str);
	         buffers = str.split("\"");
	         buffer.setRequest(buffers[1]);
	         secondPart = buffers[0].split("- ");
	         buffer.setLocalHost(secondPart[0].trim());
	         buffer.setTimestamp(secondPart[2]);
	         secondPart = buffers[2].split(" ");
	         buffer.setReplyCode(Integer.parseInt(secondPart[1]));
	     }
         catch(Exception nfe1)
         {
        	 return null;
         }              
         
         try {
             buffer.setReplyBytes(Integer.parseInt(secondPart[2]));
         }
         catch (NumberFormatException nfe2) {
        	 buffer.setReplyBytes(0);
        	 
         }
		 return buffer;
    }
}