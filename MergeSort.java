/**
 * This program MergeSorts an int array.
 * Created by Devang on 08-Jan-17.
 */
public class MergeSort {
    public static void main(String[] args){
        int[] array = {5, 8, 24, 15, 200, 192, 86, 35, 78, 4 ,9};
        printArray(array);
        array = sort(array);
        printArray(array);
    }
    
    private static int[] sort(int[] array){
        if (array.length <= 1)
            return array;
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];
        System.arraycopy(array, 0, left, 0, array.length/2);
        System.arraycopy(array, array.length/2, right, 0, array.length - array.length/2);
        left = sort(left);
        right = sort(right);
        array = merge(array, left, right);
        return array;
    }
    
    private static int[] merge(int[] array, int[] left, int[] right){
        int l = 0, r = 0;
        
        for(int i = 0; i < array.length; i++) {
            if((r < right.length && l < left.length && left[l] <= right[r]) || r >= right.length){
                array[i] = left[l++];
            } else {
                array[i] = right[r++];
            }
        }
        return array;
    }
    
    private static void printArray(int[] collection){
        for(int i = 0; i < collection.length; i++){
            System.out.print("\t" + collection[i]);
        }
        System.out.println();
    }
}
