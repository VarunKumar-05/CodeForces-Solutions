import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
public class CardsColoring {
    public static void main(String[] args) throws Exception {
        FastScanner fs=new FastScanner(System.in);
        int t=fs.nextInt();
        StringBuilder out = new StringBuilder();
        for (int caseIdx=0;caseIdx<t;caseIdx++) {
            int n=fs.nextInt();
            int[] arr=new int[n];
            int[] posByValue=new int[n + 1];
            for (int i=0;i<n;i++) {
                arr[i]=fs.nextInt();
                posByValue[arr[i]]=i;
            }
            List<List<Integer>> graph = new ArrayList<>(n);
            for (int i=0 ;i<n;i++)graph.add(new ArrayList<>());
            for (int i=0; i + 1 < n; i++)addEdge(graph, i, i + 1);
            for (int value=1; value<n; value++) {
                int u=posByValue[value];
                int v=posByValue[value + 1];
                addEdge(graph, u, v);
            }
            boolean possible = isBipartite(graph, n);
            out.append(possible ? "YES" : "NO");
            if (caseIdx + 1 < t) {
                out.append('\n');
            }
        }
        System.out.print(out);
    }

    private static void addEdge(List<List<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    private static boolean isBipartite(List<List<Integer>> graph, int n) {
        int[] color = new int[n];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int start=0; start<n; start++) {
            if (color[start] != 0) {
                continue;
            }
            color[start]=1;
            queue.add(start);
            while (!queue.isEmpty()) {
                int node = queue.poll();
                int nextColor=-color[node];
                for (int neighbor:graph.get(node)) {
                    if (color[neighbor]==0) {
                        color[neighbor]=nextColor;
                        queue.add(neighbor);
                    } else if (color[neighbor]!=nextColor) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }
        int nextInt() throws IOException {
            return (int) nextLong();
        }
        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1)return Long.MIN_VALUE;
            }
            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = read();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return neg ? -val : val;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }
    }
}
