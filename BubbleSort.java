/**
 * This program bubble sorts an int array
 * Created by Devang on 08-Jan-17.
 */
public class BubbleSort {
    public static void main(String[] args){
        int[] collection = {5, 8, 24, 15, 200, 192, 86, 35, 78, 4 ,9, 20};
        printArray(collection);
        bubbleSort(collection, 'a');
        printArray(collection);
    }
    
    private static void bubbleSort(int[] collection, char order){
        if (order != 'a' && order != 'd') {
            System.out.println("Incorrect order parameter! Use [a or d]");
            return;
        }
            
        int temp;
        for (int i = 0; i < collection.length; i++){
            for(int j = 0; j < collection.length - i - 1; j++){
                if((order == 'd' && collection[j] < collection[j+1]) || (order == 'a' && collection[j] > collection[j+1])){
                    temp = collection[j];
                    collection[j] = collection[j+1];
                    collection[j+1] = temp;
                }
            }
        }
    }
    private static void printArray(int[] collection){
        for(int i = 0; i < collection.length; i++){
            System.out.print("\t" + collection[i]);
        }
        System.out.println();
    }
}
