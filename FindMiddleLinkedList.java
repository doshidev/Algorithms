import java.util.Iterator;
import java.util.LinkedList;

/**
 * This program finds the middle node of a singly LinkedList<AnyDataType>
 * Created by Devang on 11-Jan-17.
 */
public class FindMiddleLinkedList {
    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<>();
        myList.add("a");
        myList.add("b");
        myList.add("c");
        myList.add("d");
        myList.add("e");
        myList.add("f");
        myList.add("g");
        myList.add("h");
        myList.add("i");
        System.out.println(myList);
        
        System.out.println(findMiddle(myList));
    }
    
    private static Object findMiddle(LinkedList myList){
        Iterator slowPointer = myList.iterator();
        Iterator fastPointer = myList.iterator();
        
        while(fastPointer.hasNext()){
            
            fastPointer.next();
            
            if(fastPointer.hasNext()){
                fastPointer.next();
                slowPointer.next();
            }
        }
        return slowPointer.next();
    }
}