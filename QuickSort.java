/**
 * This program QuickSorts an int array.
 * Created by Devang on 08-Jan-17.
 */
public class QuickSort {
    public static void main(String[] args){
        int[] collection = {5, 8, 24, 15, 200, 192, 86, 35, 78, 24 ,9, 24};
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
        /* if(right - left == 1){
            if(collection[left] > collection[right]) {
                int t2 = collection[left];
                collection[left] = collection[right];
                collection[right] = t2;
            }
            return;
        } */
        
        //Select pivot
        
        int p = findPivot(collection, left, right);
        int pivot = collection[p];
        
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
    
    private static int findPivot(int[] collection, int left, int right){
        int pivot;
        if(left == right || right - left == 1){
            if(collection[right] > collection[left]) {
                pivot = right;
            } else {
                pivot = left;
            }
        } else {
            int middle = (left + right) / 2;
            pivot = median(collection, left, right, middle);
        }
        return pivot;
    }
    
    private static int median(int[] collection, int left, int right, int middle){
        int a = collection[left];
        int b = collection[right];
        int c = collection[middle];
        if((a <= b && a >= c) ||(a >= b && a <= c))
            return left;
        if((b <= a && b >= c) ||(b >= a && b <= c))
            return right;
        return middle;
    }
    
    private static void printArray(int[] collection){
        for(int i : collection){
            System.out.print("\t" + i);
        }
        System.out.println();
    }
    
}
