/**
 * This program QuickSorts an int array.
 * Created by Devang on 08-Jan-17.
 */
public class QuickSort {
    public static void main(String[] args){
        int[] collection = {0, 5, 1, 1, 1, 1, 2, 2, 2, 3, 0};
        printArray(collection);
        sort(collection, 0, collection.length - 1);
        printArray(collection);
        
    }
    
    private static void sort(int[] collection, int left, int right){
        //Base case
        if(right - left < 1){
            return;
        }
        //if only two elements, compare, swap and return
        if(right - left == 1){
            if(collection[left] > collection[right]) {
                int t2 = collection[left];
                collection[left] = collection[right];
                collection[right] = t2;
            }
            return;
        }
        //Select pivot
        int[] pvt = findPivot(collection, left, right);
        int p = pvt[0];
        int pivot = pvt[1];
        
        //Swap pivot with left
        int t1 = collection[left];
        collection[left] = collection[p];
        collection[p] = t1;
        left++;
        
        // Iterate
        int l = left;
        int r = right;
        while(l <= r) {
            
            while (collection[l] <= pivot && l < right) {
                l++;
            }
            while (collection[r] > pivot && r > left) {
                r--;
            }
    
            if(l <= r){
                //swap values of left and right
                int temp = collection[l];
                collection[l] = collection[r];
                collection[r] = temp;
                l++;
                r--;
                
            }
            
        }
        
        // swap left and pivot values in array
        int t = collection[left - 1];
        collection[left - 1] = collection[l-1];
        collection[l-1] = t;
        p = l - 1;
        
        // recurse for left, pivot - 1
        sort(collection, left - 1, p - 1);
    
        // recurse for pivot + 1, right
        sort(collection, p + 1, right);
    }
    
    private static int[] findPivot(int[] collection, int left, int right){
        int[] pivot = new int[2];
        if(left == right || right - left == 1){
            if(collection[right] > collection[left]) {
                pivot[0] = right;
                pivot[1] = collection[right];
            } else {
                pivot[0] = left;
                pivot[1] = collection[left];
            }
        } else {
            int middle = (left + right) / 2;
            int m = median(collection[left], collection[right], collection[middle]);
            
            if (collection[left] == m) {
                pivot[0] = left;
                pivot[1] = collection[left];
            } else if(collection[middle] == m){
                pivot[0] = middle;
                pivot[1] = collection[middle];
            } else if(collection[right] == m){
                pivot[0] = right;
                pivot[1] = collection[right];
            }
        }
        return pivot;
    }
    
    private static int median(int a, int b, int c){
        if((a <= b && a >= c) ||(a >= b && a <= c))
            return a;
        if((b <= a && b >= c) ||(b >= a && b <= c))
            return b;
        return c;
    }
    
    private static void printArray(int[] collection){
        for(int i : collection){
            System.out.print("\t" + i);
        }
        System.out.println();
    }
    
}
