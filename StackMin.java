import java.util.Stack;

/**
 * How would you design a stack which, in addition to push and pop, has a function min which returns the minimum
 * element? Push, pop, and min should all operate in O(1) time.
 */
public class StackMin {
    
    private Stack<Integer> mainstack = new Stack<>();
    private Stack<Integer> minstack = new Stack<>();
    
    public StackMin() {
        
    }
    
    public void push(Integer item) {
        mainstack.push(item);
        if(minstack.isEmpty()){
            minstack.push(item);
        } else {
            if(minstack.peek() >= item){
                minstack.push(item);
            }
        }
    }
    
    public int pop() {
        if(mainstack.isEmpty()){
            return -1;
        } else {
            if(mainstack.peek() == minstack.peek()){
                minstack.pop();
            }
            return mainstack.pop();
        }
    }
    
    public int min() {
        if(minstack.isEmpty()){
            return -1;
        }
        return minstack.peek();
    }
    
    public static void main(String[] args) {
        StackMin sm = new StackMin();
        
        
        
        
        
        
        sm.push(6);
        System.out.println("Min after pushing 6 = " + sm.min());
        sm.push(7);
        System.out.println("Min after pushing 2 = " + sm.min());
        sm.push(3);
        System.out.println("Min after pushing 3 = " + sm.min());
        sm.push(4);
        System.out.println("Min after pushing 4 = " + sm.min());
        sm.push(5);
        System.out.println("Min after pushing 5 = " + sm.min());
        sm.push(2);
        System.out.println("Min after pushing 2 = " + sm.min());
        
        System.out.println("\n Now popping....!");
        System.out.println("Min after popping " + sm.pop() + " = " + sm.min());
        System.out.println("Min after popping " + sm.pop() + " = " + sm.min());
        System.out.println("Min after popping " + sm.pop() + " = " + sm.min());
        System.out.println("Min after popping " + sm.pop() + " = " + sm.min());
        System.out.println("Min after popping " + sm.pop() + " = " + sm.min());
        System.out.println("Min after popping " + sm.pop() + " = " + sm.min());
        System.out.println("Min after popping " + sm.pop() + " = " + sm.min());
        System.out.println("Min after popping " + sm.pop() + " = " + sm.min());
    }
    
}
