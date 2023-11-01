public class DoublyList{
    public Node head;
    public Node tail;

    /* First Constructor:
     * Creates a linked list using the values from the given array. head will refer
     * to the Node that contains the element from a[0]
     */
    public DoublyList(Object [] a){
        head = new Node(null, null, null);
        tail = head;

        for(int i = 0; i<a.length; i++){
            Node node = new Node(a[i], null, null);
            tail.next = node;
            node.prev=tail;
            tail=tail.next;
        }
        tail.next=head; // Making it circular
        head.prev=tail;
    }

    /* Second Constructor:
     * Sets the value of head. head will refer
     * to the given LinkedList
     */
    public DoublyList(Node h){
        head = h;
    }

    /* Counts the number of Nodes in the list */
    public int countNode(){
        int count = 0;
        Node n = head.next;
        while(n!=head){
            count+=1;
            n = n.next;
        }
        return count; // please remove this line!
    }

    /* prints the elements in the list */
    public void forwardPrint(){
        for(Node n = head.next; n!=head; n = n.next){
            if(n.next==head) System.out.print(n.element+".");
            else System.out.print(n.element+", ");
        }
        System.out.println();
    }

    public void backwardPrint(){
        for(Node n = head.prev; n!=head; n = n.prev){
            if(n.prev==head) System.out.print(n.element+".");
            else System.out.print(n.element+", ");
        }
        System.out.println();
    }


    // returns the reference of the Node at the given index. For invalid index return null.
    public Node nodeAt(int idx){
        if(idx<0) return null;
        int i = 0;
        for(Node n = head.next; n!=head; n = n.next) {
            if(i == idx) return n;
            i++;
        }
        return null; // please remove this line!
    }



    /* returns the index of the Node containing the given element.
     if the element does not exist in the List, return -1.
     */
    public int indexOf(Object elem){
        int index = 0;
        for(Node n = head.next; n!=head; n = n.next){
            if(n.element==elem) return index;
            index+=1;
        }
        return -1; // please remove this line!
    }



    /* inserts Node containing the given element at the given index
     * Check validity of index.
     */
    public void insert(Object elem, int idx){
        if(idx<0) System.out.println("Enter valid index.");
        int count = 0;
        Node h = head.next;
        while(h!=head){
            count+=1;
            h = h.next;
        }
        int i = 0;
        Node newNode = new Node(elem,null,null);
        for(Node n = head.next; n!=head; n = n.next){
            if(i==idx){
                newNode.next = n;
                newNode.prev = n.prev;
                n.prev.next = newNode;
                n.prev = newNode;
            }
            else if(n.next==head.next){
                newNode.next = head;
                newNode.prev = n;
                n.next = newNode;
                head.prev = newNode;
            }
            i++;
        }
    }




    /* removes Node at the given index. returns element of the removed node.
     * Check validity of index. return null if index is invalid.
     */
    public Object remove(int index){
        int i = 0;
        Node n = head.next;
        while(n!=head){
            if(i==index){
                Node p = n.prev;
                Node q = n.next;
                p.next = q;
                q.prev = p;
                n.next = n.prev = null;
                return n.element;
            }
            i++;
            n = n.next;
        }
        return null; // please remove this line!
    }



}