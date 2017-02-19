/**
 * Created by Devang on 19-Feb-17.
 */
public class CircularArrayShifting {
    public static void main(String[] args) {
        int[] a = {1, 5, 6, 11, 19, 25, 32, 65, 90};
        printArray(a);
        int [] b = CircularShift(a, 4);
        printArray(b);
    }
    
    public static int[] CircularShift(int[] a, int c){
        int[] b = new int[a.length];
        int shift;
        for (int i = 0; i < a.length ; i++) {
            shift = (i + c) % (a.length);
            b[shift] = a[i];
        }
        return b;
    }
    
    public static void printArray(int[] A){
        System.out.print("{");
        for (int i = 0; i < A.length ; i++) {
            System.out.print(A[i] +" ");
        }
        System.out.println("}");
    }
}
