/**
 * Singly Linked List
 * Created by Devang on 03-Jan-17.
 */
public class MyLinkedList<E> {
    
    Node<E> head;
    Node<E> tail;
    int size;
    
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    
    public void addLast(E data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    public void addFirst(E data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    
    public void remove(E key) {
        if (head == null) {
            return;
        }
        
        if (head.data.equals(key)) {
            head = head.next;
            if(head.next == null){
                tail = null;
            }
        } else {
            Node currentNode = head;
            while (currentNode.next != null){
                if (currentNode.next.data.equals(key)) {
                    currentNode.next = currentNode.next.next;
                    if(currentNode.next == null){
                        tail = currentNode;
                    }
                    break;
                }
                currentNode = currentNode.next;
            }
        }
        size--;
    }
    
    public void insertAfter(E key, E data){
        if (head == null) {
            return;
        }
        Node newNode = new Node(data);
        Node currentNode = head;
        
        while (currentNode != null){
            if(currentNode.data.equals(key)){
                newNode.next = currentNode.next;
                currentNode.next = newNode;
                if(newNode.next == null){
                    tail = newNode;
                }
                size++;
                return;
            }
            currentNode = currentNode.next;
        }
    }
    
    public void insertBefore(E key, E data){
        if (head == null) {
            return;
        }
        
        //If inserting before head
        if(head.data.equals(key)){
            addFirst(data);
            size++;
            return;
        }
    
        Node newNode = new Node(data);
        Node currentNode = head;
        
        //Else iterate till end
        while (currentNode.next != null){
            if(currentNode.next.data.equals(key)){
                newNode.next = currentNode.next;
                currentNode.next = newNode;
                size++;
                return;
            }
            currentNode = currentNode.next;
        }
    }
    
    public String toString() {
        Node currentItem = head;
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
        System.out.println("tail: " + list1.tail.data);
        list1.remove("!");
        System.out.println("tail: " + list1.tail.data);
        System.out.println(list1);
        list1.addFirst("!");
        System.out.println(list1);
        System.out.println("Size: " + list1.size);
        list1.insertAfter("Hello", "Everyone");
        System.out.println(list1);
        list1.insertBefore("Hello", 125);
        list1.remove("World");
        System.out.println(list1);
        System.out.println("tail: " + list1.tail.data);
        System.out.println("Size: " + list1.size);
    }
}
