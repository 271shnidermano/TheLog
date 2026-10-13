public class LearningLinks {
    public static void main(String[] args) {
       Node one = new Node(20);
       //System.out.println(one);

       /*Node two = new Node(33);
       one.set(two);
       System.out.println(one.getNext());   
       Node three = new Node(1);
       two.set(three);
       System.out.println(one.getNext().getNext());
*/
        one.setLink(new Node(33));
        one.getNext().setLink(new Node(1));
        //System.out.println(one.getNext().getNext());    
        
        //printing list
        Node temp = one;
        temp.printList();
        System.out.println(" ");
        //adding to back of list
        temp = one;
        while(temp.getNext()!= null)
        {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
        
        temp.setLink(new Node(5));
        temp.printList();
        System.out.println(" "); 
        //adding to front of list + printing
        Node adder = new Node(4);
        adder.setLink(one);
        Node temp2 = adder;
        temp2.printList();

        Node temp3 = adder;
        while(temp3.getNext()!= null)
        {
            temp3 = temp3.getNext();
        }
        temp3.setLink(null);
    }
}
