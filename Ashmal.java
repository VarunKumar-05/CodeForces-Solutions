import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            
            String s = sc.next();
            
            for (int i = 1; i < n; i++) {
                String a = sc.next();
                
                String prepend = a + s;
                String append = s + a;
                
                if (prepend.compareTo(append) < 0) {
                    s = prepend;
                } else {
                    s = append;
                }
            }
            
            System.out.println(s);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st==null||!st.hasMoreElements()) {
                try {
                    String line=br.readLine();
                    if(line == null)return null;
                    st=new StringTokenizer(line);
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