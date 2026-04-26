import java.io.*;
import java.util.*;

public class PermutationCombination {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder out = new StringBuilder();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            
            long[][] p = new long[n][2];
            long cp = 0;
            for (int i = 0; i < n; i++) {
                p[i][0] = cp;
                p[i][1] = i;
                long a =sc.nextLong();
                cp += a;
            }
            Arrays.sort(p, (a, b) -> Long.compare(a[0], b[0]));
            
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) 
                ans[(int)p[i][1]] = n - i;
            for (int i = 0; i < n; i++) {
                out.append(ans[i]).append(i == n - 1 ? "" : " ");
            }
            out.append("\n");
        }
        System.out.print(out.toString());
    }
}