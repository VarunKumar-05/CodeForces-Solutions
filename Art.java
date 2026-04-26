import java.io.*;
import java.util.*;

public class Art {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            long totalSum = 0;
            ArrayList<Long> O = new ArrayList<>();
            ArrayList<Long> E = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                long val = sc.nextLong();
                totalSum += val;
                if ((i + 1) % 2 != 0) O.add(val);
                else E.add(val);
                }
            
            int co = 0;
            int ce = 0;
            
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                if (x % 2 != 0) co++;
                 else  ce++;
                
            }
            Collections.sort(O, Collections.reverseOrder());
            Collections.sort(E, Collections.reverseOrder());
            
            long markedSum = 0;
            
            if (co > 0 && !O.isEmpty()) {
                markedSum += O.get(0); 
                int limit = Math.min(O.size(), co);
                for (int i = 1; i < limit; i++) {
                    if (O.get(i) > 0)
                        markedSum += O.get(i);
                    else 
                        break; 
                    
                }
            }
            if (ce > 0 && !E.isEmpty()) {
                markedSum += E.get(0); 
                int limit = Math.min(E.size(), ce);
                for (int i = 1; i < limit; i++) {
                    if (E.get(i) > 0) markedSum += E.get(i);
                    else break; 
                    
                }
            }
            sb.append(totalSum - markedSum).append("\n");
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
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}