import java.util.*;

public class Balls {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int[] c = new int[n + 1];

        for (int i = 1; i <= n; i++) 
            c[i] = sc.nextInt();

        int[][] dp = new int[n + 2][n + 2];
        for (int len = 1; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                if (len == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 1 + dp[i + 1][j];
                    for (int k = i + 1; k <= j; k++) {
                        if (c[i] == c[k]) {
                            int cost = dp[i + 1][k - 1] + dp[k + 1][j];
                            dp[i][j] = Math.min(dp[i][j], cost);
                        }
                    }
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}