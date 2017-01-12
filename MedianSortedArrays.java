/**
 * Given two sorted arrays, find median of the merged numbers
 * Created by Devang on 11-Jan-17.
 */
public class MedianSortedArrays {
    public static void main(String[] args) {
        int[] a = {12, 15, 22, 26, 34, 42, 56, 96};
        int[] b = {3, 13, 32, 45, 55, 63, 71, 82, 96, 105};
        
        int m = findMedian(a, b);
        System.out.println("Median: " + m);
    }
    
    private static int findMedian(int[] a, int[] b) {
        int median = 0;
        int ptra = 0, ptrb = 0;
        
        for(int i = 0; i < (a.length + b.length)/2; i++){
            if(ptra < a.length && a[ptra] < b[ptrb]){
                median = a[ptra++];
            } else if(ptrb < b.length) {
                median = b[ptrb++];
            }
        }
        return median;
    }
}
