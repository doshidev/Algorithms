import java.util.Arrays;

/**
 * Created by Devang on 7/12/2017.
 */
public class Fibonacci {
    public static void main(String[] args) {
        int n = 83;
        long[] cache = new long[n+1];
        
        Arrays.fill(cache, -1);
                
    
        System.out.println(fibonacci(n, cache));
    }
    
    public static long fibonacci(int n, long[] cache) {
        if(n == 0){
            return 0;
        }
        
        if(n == 1) {
            return 1;
        }
        
        if(cache[n] == -1) {
            cache[n] = fibonacci(n - 1, cache) + fibonacci(n - 2, cache);
        }
        
        
        return cache[n];
    }
}
