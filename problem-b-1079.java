import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] p = new int[n + 1];
            int[] pos = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                p[i] = Integer.parseInt(st.nextToken());
                pos[p[i]] = i;        
            }
            int[] a = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++)a[i] = Integer.parseInt(st.nextToken());
            boolean ok = true;
            int last = 0;
            for (int i = 1; i <= n; i++) {
                int cur = pos[a[i]];
                if (cur < last) {
                    ok = false;
                    break;
                }
                last = cur;
            }
            sb.append(ok ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
    }
}