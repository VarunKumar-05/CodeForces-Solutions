import java.io.*;
import java.util.*;

public class AprilfoolA {
    static class Edge {
        int to;
        int weight;      
        Edge(int to, int weight) {
            this.to=to;
            this.weight=weight;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if (n == -1) return;
        int m=sc.nextInt();
        
        ArrayList<Edge>[] adj=new ArrayList[n + 1];
        for (int i=1;i <= n;i++) {
            adj[i]=new ArrayList<>();
        }

        for (int i=0;i < m;i++) {
            int u=sc.nextInt();
            int v=sc.nextInt();
            int w=sc.nextInt();
            adj[u].add(new Edge(v, w));
            adj[v].add(new Edge(u, w));
        }
        
        int[] dist=new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1]=0;
        for (int u=1;u <= n;u++) {
            if (dist[u] == Integer.MAX_VALUE) continue;
            
            for (Edge edge : adj[u]) {
                int v=edge.to;
                int w=edge.weight;
                if (dist[u] + w < dist[v]) {
                    dist[v]=dist[u] + w;
                }
            }
        }

        StringBuilder out=new StringBuilder();
        for (int i=2;i <= n;i++) {
            if (dist[i] == Integer.MAX_VALUE)
                out.append("-1\n");
            else
                out.append(dist[i]).append("\n");
        }
        System.out.print(out);
    }
}