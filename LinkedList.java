public class LinkedList<T> implements List<T>
{
    Node head;

    @Override
    public void add(T item)
    {
        if (head == null)
        {
            head = new Node(item);
            return;
        }
        Node current = new Node(item);
        current.next = head;
    }

    @Override
    public void add(int pos, T item)
    {
        if (head == null)
        {
            head = new Node(item);
            return;
        }
        else
         {
             if (pos == 0)
             {
                 Node current = new Node(item);
                 current.next = head.next;
                 head = current;
             }
             else if (pos > 0)
             {
                 Node c = head;
                 Node temp = new Node(item);
                 int i = 0;
                 while (i < pos-1 && c != null)
                 {
                     c = c.next;
                     i++;
                 }
                 temp.next = c.next;
                 c.next = temp;
             }
        }

    }

    @Override
    public T get(int pos) //throws Exception
    {
        if (head == null)
        {
            throw new IndexOutOfBoundsException("Try Again");
        }
        Node current = head;
        int i = 0;
        while (i < pos)
        {
            current = current.next;
            i++;
        }
        return (T) current.data;
    }

    @Override
    public T remove(int pos) //throws Exception
    {
        if (head == null)
        {
            throw new IndexOutOfBoundsException();
        }
        Node temp;
        Node current = head;
        int i = 0;
        while (i < pos && current != null)
        {
            current = current.next;
            i++;
        }
//        System.out.println(current.data);
        temp = current;
        current = current.next;
        if (size() == 1)
        {
            head = null;
        }
//        current.next = current.next.next;
//        System.out.println();

        return (T) temp.data;
    }

    @Override
    public int size()
    {
        int i = 0;
        Node current = head;
        while (current != null)
        {
            current = current.next;
            i++;
        }
        return i;
    }
}
