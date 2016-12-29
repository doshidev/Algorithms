/**
 * Created by Devang on 27-Dec-16.
 */
/**
 * Created by Devang on 27-Dec-16.
 */
public class Russian {
    public static void main(String args[]) {
        System.out.println("Answer C = " + russian(20,7));
    }

    private static int russian(int a, int b) {
        int c = 0;
        System.out.println("\ta\tb\tc");
        while (a > 0) {
            if (a % 2 == 1) {
                c = c + b;
                System.out.print("*");
            }
            System.out.println("\t"+ a + "\t" + b + "\t" + c);
            b = b << 1;
            a = a >> 1;
        }
        return c;
    }
}
