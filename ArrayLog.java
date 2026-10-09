
/**
 * This ArrayLog object represents a Log ADT implemented as
 * a generic data type array using the EnhancedLogInterface.
 * 
 * @author  
 * @version 
 */
@SuppressWarnings("unchecked")  // eliminates compiler warnings from cast below

public class ArrayLog<T> implements EnhancedLogInterface<T>
{
    // Instance variables
    private T[] log;
    private String name;
    private int size;
    
    // Create a new String array with a capacity of 4 elements
    // and assign values to instance variables.
    public ArrayLog(String name)
    {
        // cannot create a generic array object, so has to be cast
        // from an Object back into the generic in order to compile
        this.log = (T[])new Object[4];
        this.name=name;
        this.size=0;
    }

    // Returns the name of this StringLog.
    public String getName()
    {
        return this.name;
    }

    // Returns the logical size of this StringLog.
    public int size()
    {
        return this.size;
    }
    
    // Returns true if this list contains no elements.
    public boolean isEmpty()
    {
        
            if(size==0)
            {
                return true;
            }
            else
            {
                return false;
            }
    }
    
    // Returns true if this list is completely full.
    public boolean isFull()
    {
        if(size==this.log.length)
        {
            return true;
        }
        else
        {
            return false;
        }
        
        
    }

    // Appends the specified element to the end of this list.
    public void add(T element)
    {
        if (size==this.log.length)
        {
            doubleLength();
        }
        this.log[size]=element;
        this.size++;
        
    }
  
    // Returns the element at the specified position in this list.
    public T get(int index)
    {   
        return this.log[index];
    }
    
    // Returns the index of the first occurance of the specified element
    // in this list, or -1 if this list does not contain the element.
    public int indexOf(T element)
    {
       for (int i = 0; i < size; i++)
        {
            if (log[i].equals(element))
            {
                return i;
            }
        }
        return -1;
    }
    
    // Returns true if this list contains the specified element.
    public boolean contains(T element)
    {
        return indexOf(element) != -1;
    }
    
    // Returns a formatted string representation of this StringLog.
    public String toString()
    {
        String result = "Log: " + name + "\n";
        for (int i = 0; i < size; i++)
        {
            result += (i + 1) + ". " + log[i] + "\n";
        }
        return result;
    }
    
    // Replaces the element at the specified position in this list
    // with the specified element.  Returns what was at that location
    public T set(int index, T element)
    {
        T old = this.log[index];
        this.log[index] = element;
        return old;
    }
    
    // Inserts the specified element at the specified position in this list.
    public void add(int index, T element)
    {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == this.log.length)
        {
            doubleLength();
        }
        T[] tempArray = (T[]) new Object[this.log.length];
        for (int i = 0; i < size; i++)
        {
            tempArray[i] = this.log[i];
        }
        for (int i = size; i > index; i--)
        {
            tempArray[i] = tempArray[i - 1];
        }
        tempArray[index] = element;
        this.log = tempArray;
        this.size++;
    }
    
    // Removes the element at the specified position in this list, and
    // returns the element that was removed.  Any unused array elements
    // are set to null.
    public T remove(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T old = this.log[index];
        T[] tempArray = (T[]) new Object[this.log.length];
        int newIndex = 0;
        for (int i = 0; i < size; i++)
        {
            if (i != index)
            {
                tempArray[newIndex] = this.log[i];
                newIndex++;
            }
        }
        this.log = tempArray;
        this.size--;
        for (int i = this.size; i < this.log.length; i++)
        {
            this.log[i] = null;
        }
        int quarterOfMemory = (this.log.length) / 4;
        if (size < quarterOfMemory)
        {
            halfLength();
        }
        return old; 
     
    }
    
    // Removes the first occurance of the specified element from this
    // list, if it is present.  Returns true if element was found (and 
    // removed), false otherwise.
    public boolean remove(T element)
    {
        int index = indexOf(element);
        if (index != -1)
        {
            remove(index);
            return true;
        }
        return false;
    }
    
    // Removes all of the elements from this list.
    public void clear()
    {
        for(int i = 0; i<this.log.length; i++)
        {
            this.log[i]=null;
        }
        this.size=0;
    }

    public void doubleLength()
    {
        int length = log.length;
        T[] tempArray = (T[]) new Object[length*2];
        for(int i = 0; i<this.log.length; i++)
        {
            tempArray[i]=this.log[i];
        }
        this.log=tempArray; 
    }
    public void halfLength()
    {
        int length = this.log.length;
        T[] tempArray = (T[]) new Object[length/2];
        for(int i = 0; i<this.size; i++)
        {
            tempArray[i]=this.log[i];
        }
        this.log=tempArray; 
    }
}
