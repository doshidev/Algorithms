/**
 * Created by Devang on 29-Dec-16.
 */
public class QueueTwoStacks<E> {
  protected MyStack<E> in = new MyStack<>();
  protected MyStack<E> out = new MyStack<>();
  int size;
  
  public QueueTwoStacks() {
    size = 0;
  }
  
  public void enqueue(E item) {
    in.push(item);
    size++;
  }
  
  public E dequeue() {
    if (size == 0)
      return null;
    if (out.isEmpty())
      fill();
    size--;
    return out.pop();
  }
  
  protected void fill() {
    while (!in.isEmpty()) {
      out.push(in.pop());
    }
  }
  
  public int size() {
    return size;
  }
  
  public Boolean isEmpty() {
    if (size == 0)
      return true;
    return false;
  }
  
  public E front() {
    if (size == 0)
      return null;
    if (out.isEmpty())
      fill();
    return out.peek();
  }
  
  @Override
  public String toString() {
    if (size == 0)
      return null;
    if (!in.isEmpty() && !out.isEmpty()) {
      MyStack<E> temp = new MyStack<>();
      while (!in.isEmpty()) {
        temp.push(in.pop());
      }
      while (!out.isEmpty()) {
        in.push(out.pop());
      }
      
      while (!temp.isEmpty()) {
        in.push(temp.pop());
      }
    } else if (!out.isEmpty()) {
      while (!out.isEmpty()) {
        in.push(out.pop());
      }
    }
    return in.toString();
  }
  
  public static void main(String[] args) {
    //Integer
    QueueTwoStacks<Integer> q1 = new QueueTwoStacks<>();
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
    QueueTwoStacks<String> q2 = new QueueTwoStacks<>();
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
