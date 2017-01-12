/**
 * Find number of times a given integer appears in a sorted array of integers
 * Created by Devang on 11-Jan-17.
 */
public class CountInteger {
    public static void main(String[] args) {
       int[] a = {2, 3, 4, 5, 5, 5, 6, 7, 9, 10};
        System.out.println("Count: " + count(a, 2));
    }
    
    private static int count(int[] a, int n) {
        int count = 0, i = 0;
        while(i < a.length && a[i] <= n){
            if(a[i] == n){
                count++;
            }
            i++;
        }
        return count;
    }
}
