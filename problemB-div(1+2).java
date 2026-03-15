import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int l = sc.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) a[i] = sc.nextInt();

            int low = 0, high = l, ans = l;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (check(mid, n, m, l, a)) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            System.out.println(ans);
        }
    }

   private static boolean check(int x, int n, int m, int l, int[] a) {
        long D = x + 1;
        int k = 1;
        long INF = (long) 2e18;
        
        for (int i = n; i >= 0; i--) {
            long interval = (i == n ? l : a[i + 1]) - a[i];
             D -= interval;
            
            if (D <= 0) return false; 
            
            if (i > 0) {
                int Z = Math.min(k, m - 1);
                if(k> m - 1)return true;
                long maxElement =(D+k-1)/k;
                D +=maxElement;
                
                if (Z == 0) {
                    
                    D = INF;
                } else {
                    D += (D + Z - 1) / Z;
                    k++;
                    if (D > INF) D = INF;
                }
            }
        }
        
        return true;
    }
}