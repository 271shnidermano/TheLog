
/**
 * This LinkedLog object represents a Log ADT implemented as
 * a LinkedList using the EnhancedLogInterface.
 * 
 * @author 
 * @version 
 */
public class LinkedLog<T> implements EnhancedLogInterface<T>
{
    private LLNode<T> log;
    private String name;
    private int size;

    public LinkedLog(String TheName)
    {
        name = TheName;
        size=0;
    }
    
    // returns the name of this StringLog
    public String getName()
    {
        return name;
    }

    // returns the logical size of this StringLog
    public int size()
    {
        return size;
    }
    
    // returns true if this list contains no elements
    public boolean isEmpty()
    {
        if(log==null)
        {
            return true;
        }
        return false;
    }
    
    // returns true if this list is completely full
    public boolean isFull()
    {
        return false;
    }

    // appends the specified element to the end of this list
    public void add(T element)
    {
       if(log!=null)
        { 
            LLNode<T> temp = log;
            while(temp.getLink() != null)
            {
                temp = temp.getLink();
            }
            temp.setLink(new LLNode<T>(element));
            this.size=size+1;
        }
        else{
        log = new LLNode<T> (element);
        this.size=size+1;
        }
    }
  
    // returns the element at the specified position in this list
   public T get(int index)
    {
        LLNode<T> temp = log;
        int count = 0;

        while (temp != null)
        {
            if (count == index)
                return temp.getInfo();

            temp = temp.getLink();
            count++;
        }
        return null;
    }
    
    // returns the index of the first occurance of the specified element
    // in this list, or -1 if this list does not contain the element
    public int indexOf(T element)
    {
        LLNode<T> temp = log;
        int count = 0;

        while (temp != null)
        {
            if (temp.getInfo().equals(element))
                return count;

            temp = temp.getLink();
            count++;
        }
        return -1;
    }
    // returns true if this list contains the specified element
    public boolean contains(T element)
    {
        return indexOf(element)!=-1;

    //    if (indexOf(element)==-1)
    //    {
    //     return false;
    //    }
    //    return true;
    }
    
    // returns a formatted string representation of this StringLog
    public String toString()
    {
        String result = "Log: " + name + "\n";
        LLNode<T> curNode = log;
        int count = 0;
    
        while (curNode != null)
        {
            count++;
            result += count + ". " + curNode.getInfo() + "\n";
            curNode = curNode.getLink();
        }
    return result;
    }
    
    // replaces the element at the specified position in this list
    // with the specified element
   public T set(int index, T element)
    {
        LLNode<T> temp = log;
        int count = 0;

        while (temp != null)
        {
            if (count == index)
            {
                T oldElement = temp.getInfo();
                temp.setInfo(element);
                return oldElement;
            }

            temp = temp.getLink();
            count++;
        }
        return null;
    }
    
    // inserts the specified element at the specified position in this list
    public void add(int index, T element)
    {
        LLNode<T> inserting = new LLNode<>(element);
        if (index == 0) {
            inserting.setLink(log);
            log = inserting;
            size++;
        } else {
            LLNode<T> previous = log;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.getLink();
            }
            inserting.setLink(previous.getLink());
            previous.setLink(inserting);
            size++;
        }
    }
    
    // removes the element at the specified position in this list
   public T remove(int index)
    {
        if (log == null || index < 0 || index >= size)
            return null;

        LLNode<T> current = log;

        if (index == 0)
        {
            log = log.getLink();
        }
        else
        {
            LLNode<T> previous = log;

            for (int i = 0; i < index - 1; i++)
            {
                previous = previous.getLink();
            }

            current = previous.getLink();
            previous.setLink(current.getLink());
        }

        size--;
        return current.getInfo();
    }
    
    // removes the first occurance of the specified element from this
    // list, if it is present
    public boolean remove(T element)
    {
        int index = indexOf(element);

        if (index == -1)
            return false;

        remove(index);
        return true;
    }
        
    // removes all of the elements from this list
    public void clear()
    {
        log = null;
        size=0;
    }
}
