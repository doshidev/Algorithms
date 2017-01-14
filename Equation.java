/**
 * The equation (a^5 + b^5 + c^5 + d^5 + e^5 = f^5) has exactly one integral
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
        int ceiling = 75;
        int power = 5;
        long startTime = System.currentTimeMillis();
        long[] powers = generatePowers(ceiling, power);

        solveEquation(ceiling, powers, power);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("\nElapsed Time: " + elapsedTime + " ms");
    }
    
    private static void solveEquation(int ceiling, long[] powers, int power) {
        // int[] result = new int[6];
        
        for(int f = ceiling; f > 0; f--){
            long sum = powers[f];
            int balanceRoot = (int) Math.pow(sum - 4, (1.0/power));
            if(balanceRoot > f){
                balanceRoot = f;
            }
            for(int e = balanceRoot; e > 0; e--){
                long balance = sum - powers[e];
                balanceRoot = (int) Math.pow(balance - 3, (1.0/power));
                if (balanceRoot > e){
                    balanceRoot = e;
                }
                for(int d = balanceRoot; d > 0; d--){
                    balance = sum - powers[e] - powers[d];
                    balanceRoot = (int) Math.pow(balance - 2, (1.0/power));
                    if (balanceRoot > d){
                        balanceRoot = d;
                    }
    
                    for(int c = balanceRoot; c > 0; c--){
                        balance = sum - powers[e] - powers[d] - powers[c];
                        balanceRoot = (int) Math.pow(balance - 1, (1.0/power));
                        if (balanceRoot > c){
                            balanceRoot = c;
                        }
                        
                        for(int b = balanceRoot; b > 0; b--){
                            balance = sum - powers[e] - powers[d] - powers[c] - powers[b];
                            balanceRoot = (int) Math.pow(balance, (1.0/power));
                            if(balanceRoot <= b && powers[balanceRoot] == balance){
                                System.out.printf("\n[A = %d, B = %d, C = %d, D = %d, E = %d, F = %d]", balanceRoot, b, c, d, e, f);
                                return;
                            }
                            
                        } // End for "b"
                    } // End for "c"
                } // End for "d"
            } // End for "e"
        } // End for "f"
        
    }
    
    private static long[] generatePowers(int ceiling, int power){
        long[] powers = new long[ceiling + 1];
        for (int i = 0; i <= ceiling; i++) {
            powers[i] = (long) Math.pow(i, power);
        }
        return powers;
    }
}
