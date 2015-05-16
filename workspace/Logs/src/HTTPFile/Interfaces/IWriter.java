package HTTPFile.Interfaces;

import java.util.List;

public interface IWriter
{
    <Type> void write(String fileName, List<Type> text);
}