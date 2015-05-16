package HTTPFile.Classes;

import HTTPFile.Interfaces.IParserForLog;


public class ParserForLog implements IParserForLog
{
    @Override
    public AccessLog getAccessLog(String str)
    {
         AccessLog buffer = new AccessLog(str);
 
         String[] buffers = str.split("\"");
         buffer.setRequest(buffers[1]);
         String[] secondPart = buffers[0].split("- ");
         buffer.setLocalHost(secondPart[0].trim());
         buffer.setTimestamp(secondPart[2]);
         secondPart = buffers[2].split(" ");
         buffer.setReplyCode(Integer.parseInt(secondPart[1]));
         try {
             buffer.setReplyBytes(Integer.parseInt(secondPart[2]));
         }
         catch (NumberFormatException ex) {
             buffer.setReplyBytes(0);
         }
		 return buffer;
    }
}