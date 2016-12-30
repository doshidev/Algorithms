import java.util.ArrayList;
import java.util.Stack;

/**
 * My implementation of basic stack using ArrayList
 * Created by Devang on 29-Dec-16.
 */
public class MyStack<E> {
    private ArrayList<E> myList = new ArrayList<>();

    public MyStack(){

    }

    public void push(E item){
        myList.add(item);
    }

    public E pop() {
        if (myList.size() > 0)
            return myList.remove(myList.size()-1);
        return null;
    }

    public E peek() {
        if (myList.size() > 0)
            return myList.get(myList.size()-1);
        return null;
    }

    public Boolean isEmpty() {
        return myList.isEmpty();
    }

    public int size() {
        return myList.size();
    }

    @Override
    public String toString() {
        return myList.toString();
    }
    public static void main (String[] args){
        /* Integer */
        MyStack<Integer> s1 = new MyStack<>();
        s1.pop();
        System.out.println("IsEmpty: " + s1.isEmpty());
        s1.push(1);
        System.out.println(s1);
        s1.push(5);
        s1.push(11);
        s1.push(8);
        s1.push(2);
        System.out.println(s1);
        System.out.println("Pop: " + s1.pop());
        System.out.println("Pop: " + s1.pop());
        System.out.println("Peek : " + s1.peek());
        System.out.println("Size: " + s1.size());
        System.out.println();

        /* String */
        MyStack<String> s2 = new MyStack<>();
        s2.push("Algorithm Design");
        s2.push("Java Software Solution");
        s2.push("Cracking the Technical Interview");
        System.out.println(s2);
        System.out.println("Pop: " + s2.pop());
        System.out.println("Peek: " + s2.peek());
        System.out.println("Size: " + s2.size());
        System.out.println("IsEmpty: " + s2.isEmpty());
        System.out.println();


        /* Built in */
        Stack<Integer> s3 = new Stack<>();
        s3.push(5);
        s3.push(7);
        s3.push(1);
        s3.push(3);
        System.out.println(s3);
        System.out.println("Pop: " + s3.pop());
        System.out.println("Peek: " + s3.peek());
    }
}
