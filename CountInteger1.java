/**
 * Find number of times a given integer appears in a sorted array
 * of integers using a predecessor and successor
 * Created by Devang on 13-Jan-17.
 */
public class CountInteger1 {
    public static void main (String[] args) throws java.lang.Exception
    {
        int[] A = {1, 1, 1, 7, 7, 7, 13, 13, 21, 21, 24, 24, 24, 31};
        int[] B = {};
        test(A, 1);
        test(A, 7);
        test(A, 13);
        test(A, 21);
        test(A, 24);
        test(A, 31);
        test(A, 100);
        test(A, 12);
        test(B, 18);
    }
        
    private static void test(int[] A, int x) {
        System.out.print("A = [");
        for (int i = 0; i < A.length; ++i) {
            System.out.print(A[i] + " ");
        }
        System.out.print("] ");
        System.out.print(" x = " + x);
        System.out.println("; count = " + count(A, x));
    }
    
    public static int count(int[] A, int x) {
        // Assume A is sorted in non-decreasing order
        int predIndex = predecessor(A, x);
        int succIndex = successor(A, x);
        
        return succIndex - predIndex - 1;
    }
    
    // Returns the index of the predecessor of x in sorted array A.
    // If no predecessor exists it returns -1
    private static int  predecessor(int[] A, int x) {
        int left = 0;
        int right = A.length - 1;
        int pred = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] >= x) {
                right = mid - 1;
            } else {
                pred = mid;
                left = mid + 1;
            }
        }
        return pred;
    }
        
    // Returns the index of the successor of x in sorted array A.
    // If no successor exists it returns A.length
    // {1, 1, 1, 7, 7, 7, 13, 13, 21, 21, 24, 24, 24, 31}
    private static int successor(int[] A, int x) {
        int left = 0;
        int right = A.length - 1;
        int succ = A.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] <= x) {
                left = mid + 1;
            } else {
                succ  = mid;
                right = mid - 1;
            }
        }
        return succ;
    }
    

}
