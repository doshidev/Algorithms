/**
 * Created by Devang on 19-Feb-17.
 */
public class ReverseArrayInPlace {
    public static void main(String[] args) {
    /* Read input and create array */
        int n = 5;
        int k = 3;
        int [] array = {1, 2, 3, 4, 5};
        
    
    /* Rotate array (in place) using 3 reverse operations */
        k = k % n; // to account for cases where k > n
        reverse(array, 0, array.length - 1);
        reverse(array, 0, k - 1);
        reverse(array, k, array.length - 1);
    
    /* Print output */
        for (int i = 0; i < array.length ; i++) {
            System.out.println(array[i] +" ");
        }
    }
    
    /* Reverses array from "start" to "end" inclusive */
    private static void reverse(int [] array, int start, int end) {
        if (array == null || start < 0 || start >= array.length ||
                end < 0 || end >= array.length || start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        for (int i = start; i <= mid; i++) {
            int offset = i - start;
            swap(array, start + offset, end - offset);
        }
    }
    
    private static void swap (int [] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
