public class Node <T>{
    T data; 
    Node<T> next;
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    public Node <T> getNext() {
        return next;
    }
    public T getData() {
        return data;
    }
    public void setLink(Node<T> other) {
        this.next = other;
    }
    public String toString() {
        return ""+data;
    }
    public void printList() {
        Node temp = this;
        while(temp!= null)
        {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }

    }
}
