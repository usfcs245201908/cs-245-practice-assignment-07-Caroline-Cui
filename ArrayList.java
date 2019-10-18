//import java.util.Arrays;
import java.util.*;

public class ArrayList<T> implements List<T>
{
    public T[] arr;
    public int size = 0;

    public ArrayList()
    {
        arr = (T[]) new Objects[10];
//        size = 0;
    }

    public void resize()
    {
        arr = Arrays.copyOfRange(arr, 0, arr.length*2);
    }

    @Override
    public void add(T item)
    {
        if (arr.length == size)
        {
            resize();
        }
//        System.arraycopy(arr, 0, arr, 1, size-1);
        arr[size++] = item;
//        size++;
    }

    @Override
    public void add(int pos, T item)  {

        if (size == arr.length)
        {
            resize();
        }
        for (int i = size; i > pos; i--)
        {
            arr[i] = arr[i-1];
        }
        arr[pos] = item;
        ++size;
    }

    @Override
    public T get(int pos) //throws Exception
    {
        if (pos >= size || pos < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        return arr[pos];
    }

    @Override
    public T remove(int pos) //throws Exception
    {
        if (pos >= size || pos < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        T rv = arr[pos];
        int a = size - pos - 1;
        System.arraycopy(arr, pos+1, arr, pos, a);
        --size;
//        arr[size] = null;
        return rv;
    }

    @Override
    public int size()
    {
        return size;
    }
}
