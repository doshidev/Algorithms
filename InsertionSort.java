/** This program does an insertion sort on an int array
 * Created by Devang on 08-Jan-17.
 */
public class InsertionSort {
    public static void main(String[] args){
        int[] collection = {5, 8, 24, 15, 200, 192, 86, 35, 78, 4 ,9, 20};
        printArray(collection);
        insertionSort(collection, 'd');
        printArray(collection);
    }
    
    private static void insertionSort(int[] collection, char order){
        if (order != 'a' && order != 'd') {
            System.out.println("Incorrect order parameter! Use [a or d]");
            return;
        }
        
        for (int i = 0; i < collection.length; i++) {
            int value = collection[i];
            int j = i;
            while(j > 0 && ((order =='a' && value < collection[j-1])||(order == 'd' && value > collection[j-1]))){
                collection[j] = collection[j - 1];
                j--;
            }
            collection[j] = value;
        }
    }
    
    private static void printArray(int[] collection){
        for(int i = 0; i < collection.length; i++){
            System.out.print("\t" + collection[i]);
        }
        System.out.println();
    }
}
