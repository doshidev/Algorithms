/**
 * Created by Devang on 19-Feb-17.
 */
public class CircularArrayShifting {
    public static void main(String[] args) {
        int[] a = {1, 5, 6, 11, 19, 25, 32, 65, 90};
        printArray(a);
        CircularShift(a, 4);
        printArray(a);
    }
    
    public static void CircularShift(int[] a, int c){
        Reverse(a, 0, a.length - 1);
        Reverse(a, 0, c - 1);
        Reverse(a, c, a.length - 1);
    }
    
    public static void Reverse(int[] a, int s, int e){
        
        int temp;
        while (s < e){
            temp = a[s];
            a[s] = a[e];
            a[e] = temp;
            s++;
            e--;
        }
    }
    
    public static void printArray(int[] a){
        System.out.print("{");
        for (int i = 0; i < a.length ; i++) {
            System.out.print(a[i] +" ");
        }
        System.out.println("}");
    }
}
