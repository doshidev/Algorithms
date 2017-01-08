import java.util.*;

import static java.lang.Character.isDigit;

/**
 * Created by Devang on 06-Jan-17.
 */
public class Expression {
    public static void main(String[] args){
        ArrayList<String> exp = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter parenthesized numeric expression:?");
        String input = s.nextLine();
        
        StringTokenizer st = new StringTokenizer(input);
        
        while(st.hasMoreElements()){
            exp.add(st.nextToken());
        }
        System.out.println("Inflix: " + exp);
    
        evaluate(exp);
    }
    
    private static void evaluate(ArrayList<String> exp){
        Stack<String> myStack = new Stack<>();
        LinkedList<String> numbers = new LinkedList<>();
        Map<String, Integer> order = new LinkedHashMap<>();
        order.put("-", 1);
        order.put("+", 2);
        order.put("*", 3);
        order.put("/", 4);
        order.put("^", 5);
        order.put("(", 0);
        order.put(")", 0);
        
        for (String e: exp) {
            if (e.equals(")")){
              while(!myStack.peek().equals("(")){
                  numbers.add(myStack.pop());
              }
              myStack.pop();
            }
            else if(e.equals("(")){
                myStack.push(e);
            }
            else if(isNumeric(e)){
                numbers.add(e);
            } else {
                if(myStack.isEmpty()){
                    myStack.push(e);
                } else {
                    if(order.get(myStack.peek()) > order.get(e) ){
                        numbers.add(myStack.pop());
                        myStack.push(e);
                    } else {
                        myStack.push(e);
                    }
                }
            }
        }
        
        while(!myStack.isEmpty()){
            numbers.add(myStack.pop());
        }
        System.out.println("RPN: " + numbers);
        
        
        //Calculate
        while(!numbers.isEmpty()){
            if(isNumeric(numbers.peekFirst())){
                myStack.push(numbers.remove());
            } else {
                String right = myStack.pop();
                String left = myStack.pop();
                String operator = numbers.remove();
                Double result = calc(operator, right, left);
                myStack.push(result.toString());
                
            }
        }
        System.out.println(myStack.peek());
    }
    
    private static double calc(String exp, String right, String left){
        double result = 0.0;
        double a = Double.parseDouble(left);
        double b = Double.parseDouble(right);
        
        switch (exp.toCharArray()[0]){
            case '+':
                result = a + b;
                break;
            case '-':
                result =  a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result =  a / b;
                break;
            case '^':
                result =  Math.pow(a,b);
                break;
        }
        return result;
    }
    
    private static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
    
    
}

