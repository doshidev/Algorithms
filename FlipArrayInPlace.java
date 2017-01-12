import java.util.HashMap;
import java.util.Map;

/**
 * 1. Flip a 2D array given in the form a 1D array.
 * Example:
 * Inputs: Array = [1 2 3 4 5 6 7 8 9 10 11 12], rows = 3, columns = 4.
 * Hence the array represents:
 *    [1 2 3 4
 *     5 6 7 8
 *     9 10 11 12]
 * The output should be a representation of:
 *     1 5  9
 *     2 6 10
 *     3 7 11
 *     4 8 12
 * Flip in place
 * Created by Devang on 11-Jan-17.
 */
public class FlipArrayInPlace {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        flipArray(a, 3, 4);
        printArray(a);
    }
    
    private static void flipArray(int[] a, int rows, int cols){
        Map<Integer, Integer> buffer = new HashMap<>();
        int newPosX;
        
        for(int i = 0; i < a.length; i++){
            int value;
            if(buffer.containsKey(i)){
                value = buffer.get(i);
            } else {
                 value = a[i];
            }
            
            //Find new Position for the current element
            newPosX = (rows * (i % cols)) + (i / cols);
            
            // if new position is on the right side of the current pointer, save the new position in a buffer;
            if (newPosX > i){
                buffer.put(newPosX, a[newPosX]);
            }
            a[newPosX] = value;
        }
    }
    
    private static void printArray(int[] collection){
        for(int i : collection){
            System.out.print("\t" + i);
        }
        System.out.println();
    }
}
