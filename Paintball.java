import java.io.*;
import java.util.*;

public class Paintball {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            
            boolean[] isRed = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                isRed[i + 1] = (s.charAt(i) == '1');
            }
            
            List<Integer>[] adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }
            
            int[] D = new int[n + 1];
            for (int i = 0; i < n - 1; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj[u].add(v);
                adj[v].add(u);
                D[u]++;
                D[v]++;
            }
            int[] r = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                if (!isRed[i]) {
                    for (int v : adj[i]) {
                        if (isRed[v]) r[i]++;
                    }
                }
            }

            boolean[] visited = new boolean[n + 1];
            int[] parent = new int[n + 1];
            double[] cost0 = new double[n + 1]; 
            double[] cost1 = new double[n + 1]; 

            double totalExpected = 0;

            for (int i = 1; i <= n; i++) {
                if (!isRed[i] && !visited[i]) {
                    List<Integer> comp = new ArrayList<>();
                    List<Integer> q = new ArrayList<>();
                    
                    q.add(i);
                    visited[i] = true;
                    parent[i] = 0; 
                    
                    int head = 0;
                    while (head < q.size()) {
                        int u = q.get(head++);
                        comp.add(u);
                        for (int v : adj[u]) {
                            if (!isRed[v] && !visited[v]) {
                                visited[v] = true;
                                parent[v] = u;
                                q.add(v);
                            }
                        }
                    }

                    for (int idx = comp.size() - 1; idx >= 0; idx--) {
                        int u = comp.get(idx);
                        double S = 0;
                        List<Double> deltas = new ArrayList<>();
                        
                        for (int v : adj[u]) {
                            if (!isRed[v] && parent[v] == u) {
                                S += cost0[v];
                                deltas.add(cost1[v] - cost0[v]);
                            }
                        }
                        Collections.sort(deltas);
                        double min0 = 1e18;
                        double cur_delta = 0;
                        for (int j = 0; j <= deltas.size(); j++) {
                            if (j > 0) cur_delta += deltas.get(j - 1);
                            if (cur_delta >= 1e14) break;
                            int c = 1 + r[u] + j;
                            min0 = Math.min(min0, (double) D[u] / c + S + cur_delta);
                        }
                        cost0[u] = min0;
                        double min1 = 1e18;
                        cur_delta = 0;
                        for (int j = 0; j <= deltas.size(); j++) {
                            if (j > 0) cur_delta += deltas.get(j - 1);
                            if (cur_delta >= 1e14) break;
                            
                            int c = 0 + r[u] + j;
                            if (c > 0) { 
                                min1 = Math.min(min1, (double) D[u] / c + S + cur_delta);
                            }
                        }
                        cost1[u] = min1;
                    }

                    totalExpected += cost1[comp.get(0)];
                }
            }
            out.printf(Locale.US, "%.10f\n", totalExpected);
        }
        out.flush();
    }
//fast scanner

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
    }
}