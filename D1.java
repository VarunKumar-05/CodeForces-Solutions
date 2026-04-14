import java.io.*;
import java.util.*;

public class D1 {
    static FastScanner sc;
    static PrintWriter out;

    static int query(int mid, int[] extra) {
        int k = mid + extra.length;
        out.print("? " + k);
        
        for (int i = 1; i <= mid; i++) 
            out.print(" " + i);
        
        for (int x : extra) 
            out.print(" " + x);
        
        out.println();
        out.flush();

        int res = sc.nextInt();
        if (res == -1) {
            System.exit(0);
        }
        return res;
    }

    public static void main(String[] args) {
        sc = new FastScanner();
        out = new PrintWriter(System.out);

        int t = sc.nextInt();
        if (t == -1) return;

        while (t-- > 0) {
            int n = sc.nextInt();
            if (n == -1) break;

            int N = 2 * n + 1;
            
            int lo = 1, hi = N;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                int ans = query(mid, new int[]{});
                
                if ((ans & 1) != (mid & 1))
                    hi = mid;
                else 
                    lo = mid + 1;
            }
            int p3 = lo;

            lo = 1;
            hi = p3 - 1;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                int ans = query(mid, new int[]{p3});
                
                if ((ans & 1) == (mid & 1))
                    hi = mid;
                else 
                    lo = mid + 1;
                
            }
            int p2 = lo;

            lo = 1;
            hi = p2 - 1;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                int ans = query(mid, new int[]{p2, p3});
                
                if ((ans & 1) != (mid & 1))
                    hi = mid;
                else
                    lo = mid + 1;
                
        }
            int p1 = lo;

            out.println("! " + p1 + " " + p2 + " " + p3);
            out.flush();
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            String s = next();
            if (s == null) return -1;
            return Integer.parseInt(s);
        }
    }
}