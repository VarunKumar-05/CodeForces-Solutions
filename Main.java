import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        StringBuilder sb = new StringBuilder();
        
        int T = sc.nextInt();
        if (T == -1) return;
        
        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] A = new int[N];
            
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            
            int cnt = 0, prev = -1;
            boolean flag = false;
            
            for (int i = 0; i < N; ++i) {
                if (prev == A[i]) {
                    ++cnt;
                } else {
                    cnt = 1;
                    prev = A[i];
                }
                
                if (cnt >= M) {
                    flag = true;
                    break;
                }
            }
            sb.append(flag ? "NO\n" : "YES\n");
        }
        System.out.print(sb);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
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