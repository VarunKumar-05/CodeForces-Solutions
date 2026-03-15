import java.io.*;
import java.util.*;

public class Main{
    static boolean[][] A=new boolean[505][505];
    static boolean[][] reach=new boolean[505][505];
    static ArrayList<Integer>[] adj=new ArrayList[505];

    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        String tt=sc.next();
        if (tt ==null) return;
        int t=Integer.parseInt(tt);
        for (int i=0;i<505;i++)
            adj[i]=new ArrayList<>();
        while (t-- > 0){
            int n=sc.nextInt();
            for (int i=0;i<n;i++){
                String s=sc.next();
                for (int j=0;j<n;j++)
                    A[i][j]=(s.charAt(j) =='1');
                
            }

            ArrayList<int[]> edges=new ArrayList<>();
            
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    if (i !=j && A[i][j]){
                        boolean keep=true;
                        for (int k=0;k<n;k++){
                            if (k !=i && k !=j && A[i][k] && A[k][j]){
                                keep=false;
                                break;
                            }
                        }
                        if (keep) edges.add(new int[]{i, j});
                        
                    }
                }
            }

            if (edges.size() !=n - 1){
                out.println("No");
                continue;
            }

            DSU dsu=new DSU(n);
            for (int[] e: edges)
                dsu.union(e[0], e[1]);

            if (dsu.components !=1){
                out.println("No");
                continue;
            }
            for (int i=0;i<n;i++){
                adj[i].clear();
                for (int j=0;j<n;j++)reach[i][j]=false;
                
            }
            for (int[] e: edges)
                
                adj[e[0]].add(e[1]);

            for (int i=0;i<n;i++)dfs(i, i);

            boolean valid=true;
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    if (reach[i][j] !=A[i][j]){
                        valid=false;
                        break;
                    }
                }
                if (!valid) break;
            }

            if (valid){
                out.println("Yes");
                for (int[] e: edges)out.println((e[0] +1) +" " +(e[1] +1));
                
            }else out.println("No");
            
        }
        out.flush();
    }

    static void dfs(int start, int curr){
        reach[start][curr]=true;
        for (int next: adj[curr]){
            if (!reach[start][next]){
                dfs(start, next);
            }
        }
    }
    static class DSU{
        int[] parent;
        int components;

        DSU(int n){
            parent=new int[n];
            for (int i=0;i<n;i++){
                parent[i]=i;
            }
            components=n;
        }

        int find(int i){
            if (parent[i] ==i) return i;
            return parent[i]=find(parent[i]);
        }

        void union(int i, int j){
            int rootI=find(i);
            int rootJ=find(j);
            if (rootI !=rootJ){
                parent[rootI]=rootJ;
                components--;
            }
        }
    }

}