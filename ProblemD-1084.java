import java.io.InputStream;
import java.io.IOException;
import java.util.*;

public class ProblemD {
    public static void main(String[] args) throws IOException {
        FastScanner sc =new FastScanner(System.in);
        int t =sc.nextInt();
        StringBuilder out =new StringBuilder();
        while (t-- > 0){
            int n =sc.nextInt();
            int x =sc.nextInt();
            int y =sc.nextInt();
            int[] p = new int[n];
            for (int i = 0;i<n; i++)p[i]=sc.nextInt();
            
            int[] B =new int[y - x];
            int minB =Integer.MAX_VALUE;
            int minIdx =-1;
            for (int i=x;i<y;i++) {
                B[i-x] =p[i];
                if (p[i] < minB){
                    minB =p[i];
                    minIdx =i-x;
                }
            }
            
            int[] B_min =new int[y-x];
            for (int i=0;i<y-x; i++)B_min[i] = B[(minIdx + i) % (y - x)];
            
            
            int[] AC =new int[n-(y-x)];
            int AA = 0;
            for (int i =0 ;i<x;i++)AC[AA++] =p[i];
        
            for (int i = y; i < n; i++)AC[AA++] =p[i];
            
            int k = 0;
            while (k < AC.length && AC[k] < B_min[0])k++;
            
            for (int i = 0;i <k; i++) out.append(AC[i]).append(" ");

            for (int i = 0;i <B_min.length; i++)out.append(B_min[i]).append(" ");

            for (int i = k;i <AC.length; i++)out.append(AC[i]).append(" ");
            
            out.append("\n");
        }
        System.out.print(out);
    }

    //skeleton for fast scanner
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
                if (c == -1) return Long.MIN_VALUE;
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
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
    }
}
