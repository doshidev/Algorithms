/**
 * Implementation of queue using a LinkedList
 * Created by Devang on 04-Jan-17.
 */
public class MyQueueLinkedList<E> {
    private MyLinkedList<E> myList = new MyLinkedList<>();
    
    public MyQueueLinkedList(){
        
    }
    
    public void enqueue(E item){
        myList.addLast(item);
    }
    
    public E dequeue(){
        if (myList.head == null)
            return null;
        E data = myList.head.data;
        myList.remove(data);
        return data;
    }
    
    public int size() {
        return myList.size;
    }
    
    public boolean isEmpty() {
        return (myList.head == null);
    }
    
    public E front() {
        return myList.head.data;
    }
    
    @Override
    public String toString() {
        return myList.toString();
    }
    
    
    public static void main(String[] args) {
        //Integer
        MyQueueLinkedList<Integer> q1 = new MyQueueLinkedList<>();
        // System.out.println("Dequeue: " + q1.dequeue());
        System.out.println("IsEmpty: " + q1.isEmpty());
        q1.enqueue(2);
        q1.enqueue(3);
        q1.enqueue(5);
        q1.enqueue(7);
        q1.enqueue(11);
        q1.enqueue(13);
        System.out.println(q1);
        System.out.println("Size: " + q1.size());
        System.out.println("Dequeue: " + q1.dequeue());
        System.out.println(q1);
        System.out.println("IsEmpty: " + q1.isEmpty());
        System.out.println("Front: " + q1.front());
        System.out.println();
        
        //String
        MyQueueLinkedList<String> q2 = new MyQueueLinkedList<>();
        q2.enqueue("Virat Kohli");
        q2.enqueue("Yuvraj Singh");
        q2.enqueue("Mahendra Singh Dhoni");
        q2.enqueue("Ravindra Jadeja");
        q2.enqueue("Rohit Sharma");
        q2.enqueue("Umesh Yadav");
        System.out.println(q2);
        System.out.println("Dequeue: " + q2.dequeue());
        System.out.println("Dequeue: " + q2.dequeue());
        System.out.println(q2);
        System.out.println("Size: " + q2.size());
        System.out.println("IsEmpty: " + q2.isEmpty());
        System.out.println("Front: " + q2.front());
        System.out.println();
    }
    
}
