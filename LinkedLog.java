
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

    public LinkedLog(String name)
    {
    }
    
    // returns the name of this StringLog
    public String getName()
    {
        return name;
    }

    // returns the logical size of this StringLog
    public int size()
    {
        if(log == null)
            return -1;
        int size = 0;
        LLNode<T> temp = this.log;
        while(temp.getLink() != null)
        {
            size++;
            temp = temp.getLink();
        }
        return size+1;
    }
    
    // returns true if this list contains no elements
    public boolean isEmpty()
    {
        return log.getInfo() == null;
    }
    
    // returns true if this list is completely full
    public boolean isFull()
    {
        return false;
    }

    // appends the specified element to the end of this list
    public void add(T element)
    {
        LLNode<T> temp = this.log;
        while(temp.getLink() != null)
        {
            temp = temp.getLink();
        }
        temp.setLink(new LLNode<T>(element));
    }
  
    // returns the element at the specified position in this list
    public T get(int index)
    {
        LLNode<T> temp = this.log;
        int size = 0;
        while(temp.getLink() != null)
        {
            if (size == index)
                return temp.getInfo();
            temp = temp.getLink();
        }
        return null;
    }
    
    // returns the index of the first occurance of the specified element
    // in this list, or -1 if this list does not contain the element
    public int indexOf(T element)
    {
        LLNode<T> temp = this.log;
        int size = 0;
        while(temp.getLink() != null)
        {
            if (temp.getInfo().equals(element))
                return size;
            temp = temp.getLink();
            size++;
        }
        return -1;
    }
    
    // returns true if this list contains the specified element
    public boolean contains(T element)
    {
        return false;
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
        
        ((LLNode<T>) get(index)).setInfo(element);
        return element;
    }
    
    // inserts the specified element at the specified position in this list
    public void add(int index, T element)
    {
        LLNode<T> inserting = new LLNode<>(element);
        if (index == 0) {
            inserting.setLink(log);
            log = inserting;
        } else {
            LLNode<T> previous = log;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.getLink();
            }
            inserting.setLink(previous.getLink());
            previous.setLink(inserting);
        }
    }
    
    // removes the element at the specified position in this list
    public T remove(int index)
    {
        if (index == 0) {
            LLNode<T> second = new LLNode<>(get(2));
            log.setLink(second);
        } else {
            LLNode<T> previous = log;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.getLink();
            }
            LLNode<T> current = previous.getLink();
            previous.setLink(current.getLink());
        }
        return null;
    }
    
    // removes the first occurance of the specified element from this
    // list, if it is present
    public boolean remove(T element)
    {
        int index = indexOf(element);
        if (index != -1) 
            return false; 
        else{
            remove(index);
            return true;
        }

    }
        
    // removes all of the elements from this list
    public void clear()
    {
        log = null;
    }
}
