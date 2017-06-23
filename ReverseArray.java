/**
 * Created by Devang on 19-Feb-17.
 */
public class ReverseArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        printArray(a);
        Reverse(a, 0, 10);
        Reverse(a, 0, 3);
        Reverse(a, 4, 10);
        printArray(a);
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
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("}");
    }
}
