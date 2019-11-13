package calculator;
import java.util.*;
public class OpndStack extends Stack
{
    public static final int maxSize = 8;
    private int[] data;
    private int count;
    public int value;
    public OpndStack(){this(maxSize);}
    public OpndStack(int size)
    {
        if(size<1) size = maxSize;
        data = new int[size];
        count = 0;
    }
    public boolean isEmpty()
    {
        return count == 0;
    }
    public int size() {return count;}
    public int cal()
    {
        int opnd = 0;
        for (int i = 0; i<count; i++)
        {
            opnd += data[i] * Math.pow(10,(count-i-1));
        }
        return opnd;
    }
    public void push(int item)
    {
        if(count == data.length)
        {
            int[] newData = new int[2*data.length];
            for (int i = 0; i<data.length; i++) newData[i] = data[i];
            data = newData;
        }
        data[count++] = item;
    }
    public Object pop() throws IllegalStateException
    {
        if(count == 0)
            throw new IllegalStateException("Stack underflow");
        return data[--count];
    }
}
