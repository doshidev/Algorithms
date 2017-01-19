import java.util.ArrayList;

/**
 * Given N and S, print all combinations of N variables such that their sum equals to S
 *   Example 1: N = 2, S = 5; Output: (0,5  1,4  2,3  3,2  4,1  5,0)
 *   Example 2: N = 3, S = 5; Output: (0,0,5  0,1,4  …  1,0,4  1,1,3  …)
 */
public class CombinationSum {
    public static void main(String[] args) {
        test(0, 0,0);
        test(1, 5,1);
        test(2, 5, 2);
        test(3, 8, 3);
        test(4, 5, 4);
        test(5, 5, 5);
    }
    
    private static void test(int N, int S, int seq) {
        System.out.printf("[N: %d, S: %d] = {", N, S);
        String[] prefix = new String[1];
        prefix[0] = "";
        ArrayList<String> result = new ArrayList<>();
        findCombination(N, S, prefix, result, seq);
        printList(result);
        System.out.println("}\n");
    }
    
    private static void findCombination(int N, int S, String[] prefix, ArrayList<String> result, int seq) {
        if (N == 0) {
            return;
        }
        
        if (N == 1) {
            prefix[0] += S;
            result.add(prefix[0]);
            return;
        }
        
        for (int i = 0; i <= S; i++) {
            if(prefix[0].length() > seq - N) {
                prefix[0] = prefix[0].substring(0, seq - N);
            }
            prefix[0] += i;
            findCombination(N - 1, S - i, prefix, result, seq);
        }
    }
    
    private static void printList(ArrayList<String> result) {
        for(int i = 0; i < result.size(); i++) {
            if(i > 0 ){
                System.out.print(", ");
            }
            System.out.print(result.get(i));
        }
    }
}