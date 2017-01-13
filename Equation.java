/**
 * The equation (a^3 + b^3 + c^3 + d^3 + e^3 = f^3) has exactly one integral
 * solution that satisfies (0 < a <= b <= c <= d <= e <=f <= 75). Write a program
 * to find the solution. Hint: First, precompute all values of and store them in
 * an array. Then, for each tuple , you only need to verify that some F exists in
 * the array. (There are several ways to check for F, one of which is to use a
 * binary search to check for F. Other methods might prove to be more efficient.
 *
 * Book: Data Structure and Problem Solving using Java ~Mark Weiss
 * Exercise 5.41
 *
 * Created by Devang on 12-Jan-17.
 */
public class Equation {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] powers = generatePowers(75, 5);
        int[] result = solveEquation(powers, 5);
        System.out.printf("A = %d\nB = %d\nC = %d\nD = %d\nE = %d\nF = %d", result[0], result[1], result[2], result[3], result[4], result[5]);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("\nElapsed Time: " + elapsedTime + " ms");
    }
    
    private static int[] solveEquation(int[] powers, int power) {
        int[] result = new int[6];
        double sum = 0;
        for (int a = 1; a < powers.length; a++) {
            sum += a;
            for (int b = a; b < powers.length; b++) {
                for (int c = b; c < powers.length; c++) {
                    for (int d = c; d < powers.length; d++) {
                        for (int e = d; e < powers.length; e++) {
                            sum = Math.pow(a, power)
                                    + Math.pow(b, power)
                                    + Math.pow(c, power)
                                    + Math.pow(d, power)
                                    + Math.pow(e, power);
                            double f = (Math.pow(sum, (1.0/power)));
                            if((int)f < powers.length && powers[(int)f] == sum){
                                result[0] = a;
                                result[1] = b;
                                result[2] = c;
                                result[3] = d;
                                result[4] = e;
                                result[5] = (int)f;
                                return result;
                            }
                        }
                        
                    }
                    
                }
            }
            
        }
        
        return result;
    }
    
    private static int[] generatePowers(int ceiling, int power){
        int[] powers = new int[ceiling + 1];
        for (int i = 0; i <= ceiling; i++) {
            powers[i] = (int) Math.pow(i, power);
        }
        return powers;
    }
}
