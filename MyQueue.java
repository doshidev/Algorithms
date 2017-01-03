import java.util.ArrayList;

/**
 * Implementation of a Queue using an ArrayList
 * Created by Devang on 29-Dec-16.
 */
public class MyQueue<E> {
  
  private ArrayList<E> myList = new ArrayList<>();
  
  public MyQueue() {
    
  }
  
  public void enqueue(E item) {
    myList.add(item);
  }
  
  public E dequeue() {
    if (myList.size() == 0)
      return null;
    return myList.remove(0);
  }
  
  public int size() {
    return myList.size();
  }
  
  public boolean isEmpty() {
    return myList.isEmpty();
  }
  
  public E front() {
    if (myList.size() == 0)
      return null;
    return myList.get(0);
  }
  
  @Override
  public String toString() {
    return myList.toString();
  }
  
  public static void main(String[] args) {
    //Integer
    MyQueue<Integer> q1 = new MyQueue<>();
    System.out.println("Dequeue: " + q1.dequeue());
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
    MyQueue<String> q2 = new MyQueue<>();
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
