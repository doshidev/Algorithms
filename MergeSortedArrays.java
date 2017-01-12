/**
 * Given two sorted arrays A and B, and assuming there is enough extra space
 * in array A to hold all elements of B, merge A and B into A.
 *
 * Example:
 *    A: [5, 10, 20, empty, empty, empty, empty]
 *    B: [1, 15, 19, 30]
 *
 * After the function is done:
 *    A: [1, 5, 10, 15, 19, 20, 30]
 *    B: [1, 15, 19, 30]
 *
 * Created by Devang on 11-Jan-17.
 */
public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] a = {5, 10, 20, 0, 0, 0, 0};
        int[] b = {1, 12, 19, 30};
        merge(a, b);
    
        int[] c = {5, 10, 20, 0, 0, 0, 0};
        int[] d = {1, 2, 3, 4};
        merge(c, d);
    
        int[] e = {5, 10, 20, 0, 0, 0, 0};
        int[] f = {21, 22, 29, 30};
        merge(e, f);
    
        int[] g = {5, 0};
        int[] h = {1};
        merge(g, h);
    
        int[] i = {0};
        int[] j = {1};
        merge(i, j);
    
        int[] k = {5};
        int[] l = {1};
        merge(k, l);
    }
    
    private static void merge(int[] a, int[] b){
        // Arrays before merge
        printArray(a);
        printArray(b);
        System.out.println("\n Merging...\n");
        
        int ptr = a.length - 1;
        int aptr = 0;
        int asize = a.length;
        
        // If there is length of array a[] is 1 and the value is empty, set pointer of a to -1
        if(asize == 1 && a[0] < 1){
            aptr = -1;
        } else {
            // find out the last filled element of array a[]
            for (int i = 0; i < asize; i++) {
                if (i+1 >= asize || a[i] > a[i + 1]) {
                    aptr = i;
                    break;
                }
            }
        }
        // If array a cannot accommodate all of b, return;
        if ((asize < 1) || ((asize - (aptr + 1)) != b.length)){
            System.out.println("Error!! not enough empty space");
            System.out.printf("------------------------------\n");
            return;
        }
            
        int bptr = b.length - 1;
        int avalue = 0;
        
        while(bptr >= 0){
            if(aptr >= 0){
                avalue = a[aptr];
            } else {
                avalue = 0;
            }
                
            if(b[bptr] > avalue){
                a[ptr--] = b[bptr--];
            } else {
                a[ptr--] = a[aptr--];
            }
        }
        
        // Arrays after merge
        printArray(a);
        printArray(b);
        System.out.printf("------------------------------\n");
    }
    
    private static void printArray(int[] collection){
        for(int i : collection){
            System.out.print("\t" + i);
        }
        System.out.println();
    }
}
