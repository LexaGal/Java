package HTTPFile.Interfaces;

import java.io.BufferedWriter;
import java.io.IOException;

public interface IWriter
{
    <Type> void write(BufferedWriter out, Type text);// throws IOException;
}