/**
 * Created by Devang on 27-Dec-16.
 */
public class Naive {
    public static void main(String args[]){
        int a = 4, b = 3;
        System.out.println(naive(a,b));
    }
    private static int naive(int a, int b){
        int c = 0;
        while (a > 0){
            c = c + b;
            a = a - 1;
        }
        return c;
    }
}
