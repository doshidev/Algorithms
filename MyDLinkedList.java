/**
 * Singly Linked List
 * Created by Devang on 03-Jan-17.
 */
public class MyDLinkedList<E> {
    
    Node<E> header;
    
    public MyDLinkedList() {
        header = null;
    }
    
    
    public void addLast(E data) {
        Node newNode = new Node(data);
        if (header == null) {
            header = newNode;
            return;
        }
        Node currentNode = header;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        newNode.previous = currentNode;
        newNode.next = null;
    }
    
    public void addFirst(E data) {
        Node newNode = new Node(data);
        if (header == null) {
            header = newNode;
            newNode.next = null;
        } else {
            header.previous = newNode;
            newNode.next = header;
            header = newNode;
        }
    }
    
    public void remove(E key) {
        if (header == null) {
            return;
        }
        
        if (header.data.equals(key)) {
            header = header.next;
            return;
        }
        
        Node currentNode = header;
        while (!(currentNode.data.equals(key)) && !(currentNode.next == null)) {
            if (currentNode.next.data.equals(key)) {
                currentNode.next = currentNode.next.next;
                return;
            }
            currentNode = currentNode.next;
        }
    }
    
    public void insertAfter(E key, E data){
        if (header == null) {
            return;
        }
        
        Node newNode = new Node(data);
        Node currentNode = header;
        
        while (currentNode.next != null){
            if(currentNode.data.equals(key)){
                newNode.previous = currentNode;
                newNode.next = currentNode.next;
                currentNode.next = newNode;
                currentNode.next.previous = newNode;
                return;
            }
            currentNode = currentNode.next;
        }
    }
    
    public void insertBefore(E key, E data){
        if (header == null) {
            return;
        }
        
        //If inserting before header
        if(header.data.equals(key)){
            addFirst(data);
            return;
        }
        
        Node newNode = new Node(data);
        Node currentNode = header;
        
        //Else iterate till end
        while (currentNode.next != null){
            if(currentNode.data.equals(key)){
                newNode.previous = currentNode.previous;
                newNode.next = currentNode;
                currentNode.previous = newNode;
                return;
            }
            currentNode = currentNode.next;
        }
    }
    
    public String toString() {
        Node currentItem = header;
        String output = "[";
        int cnt = 0;
        while (currentItem.next != null) {
            if (cnt != 0)
                output += ", ";
            output += currentItem.data;
            cnt++;
            currentItem = currentItem.next;
        }
        if (cnt != 0)
            output += ", ";
        output += currentItem.data;
        output += "]";
        return output;
    }
    
    protected class Node<E> {
        protected E data;
        protected Node<E> previous;
        protected Node<E> next;
        
        protected Node(E data) {
            this.data = data;
        }
    }
    
    public static void main(String[] args) {
        MyLinkedList list1 = new MyLinkedList();
        list1.addLast("Hello");
        list1.addLast("World");
        list1.addLast("!");
        System.out.println(list1);
        list1.remove("!");
        System.out.println(list1);
        list1.addFirst("!");
        System.out.println(list1);
        list1.insertAfter("Hello", "Everyone");
        System.out.println(list1);
        list1.insertBefore("Hello", 125);
        System.out.println(list1);
    }
}
