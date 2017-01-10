/**
 * Maximum Contiguous Sub-sequence Sum Problem
 * -------------------------------------------
 * Given (possibly negative) integers , find (and identify the sequence
 * corresponding to) the maximum value of . The maximum contiguous subsequence
 * sum is zero if all the integers are negative
 * <From book: Data Structure and Problem Solving using Java ~Mark Allen Weiss>
 *
 * Solved using: Brute Force Algorithm
 * Efficiency: Cubic (O(N^3): Order en-cubed)
 *
 * Created by Devang on 10-Jan-17.
 */
public class MaximumContiguousSubsequence1 {
    public static void main(String[] args) {
        int[] a = {-2, 11, -4, 13, -5, 2};
        int[] b = { 1, -3, 4, -2, -1, 6 };
    
        System.out.println(maxSubsequence(a));
        System.out.println(maxSubsequence(b));
        
    }
    
    
    private static Sequence maxSubsequence(int[] a){
        Sequence s = new Sequence();
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int thisSum = 0;
                for (int k = i; k <= j; k++) {
                    thisSum+= a[k];
                }
                if (thisSum > s.max) {
                    s.max = thisSum;
                    s.seqStart = i;
                    s.seqEnd = j;
                }
            }
        }
        return s;
    }
    
    
}
